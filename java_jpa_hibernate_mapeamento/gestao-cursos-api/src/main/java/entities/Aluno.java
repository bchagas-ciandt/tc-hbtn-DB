package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo")
    private String nomeCompleto;
    private String matricula;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    private String email;

   /* @ManyToMany(mappedBy = "alunos")
    private Set<Curso> cursos = new HashSet<>(); */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Telefone> telefones = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }


    public Set<Telefone> getTelefones() {
        return telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;

        Aluno aluno = (Aluno) o;

        if (!getId().equals(aluno.getId())) return false;
        if (getNomeCompleto() != null ? !getNomeCompleto().equals(aluno.getNomeCompleto()) : aluno.getNomeCompleto() != null)
            return false;
        if (getMatricula() != null ? !getMatricula().equals(aluno.getMatricula()) : aluno.getMatricula() != null)
            return false;
        return getNascimento() != null ? getNascimento().equals(aluno.getNascimento()) : aluno.getNascimento() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeCompleto(), getMatricula(), getNascimento());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", enderecos=" + enderecos +
                ", telefones=" + telefones +
                '}';
    }
}
