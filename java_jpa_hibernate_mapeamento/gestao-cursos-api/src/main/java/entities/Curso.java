package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.MERGE, fetch= FetchType.EAGER)
    @JoinColumn(name = "aluno_id")
    private Set<Aluno> alunos = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private MaterialCurso materialCurso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Professor getProfessor() {
        return professor;
    }



    public void setProfessor(Professor professor) {
        this.professor = professor;
    }



    public MaterialCurso getMaterialCurso() {
        return materialCurso;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return Objects.equals(getId(), curso.getId()) && Objects.equals(getNome(), curso.getNome()) && Objects.equals(getSigla(), curso.getSigla());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSigla());
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", professor=" + professor +
                ", alunos=" + alunos +
                ", materialCurso=" + materialCurso +
                '}';
    }
}
