package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Telefone telefone1 = new Telefone();
        telefone1.setDdd("81");
        telefone1.setNumero("88888-8888");

        Endereco endereco1 = new Endereco();
        endereco1.setEndereco("Rua tal");
        endereco1.setBairro("bairro tal");
        endereco1.setLogradouro("teste");
        endereco1.setCep(50860160);
        endereco1.setNumero("90");
        endereco1.setCidade("hellcife");
        endereco1.setEstado("Pernambuco");

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Joao da Silva");
        aluno.setEmail("teste@email.com");
        aluno.setMatricula("191919");
        aluno.setNascimento(sdf.parse("22/12/2000"));
        aluno.getEnderecos().add(endereco1);
        aluno.getTelefones().add(telefone1);

        alunoModel.create(aluno);

        aluno.setNomeCompleto("nome editado");

        alunoModel.update(aluno);

        System.out.println(alunoModel.findById(aluno.getId()).toString());

        List<Aluno> alunos = alunoModel.findAll();
        System.out.println(alunos);

        alunoModel.delete(aluno);

        System.out.println("---------------------------------------------------------------");

        Professor professor = new Professor();
        professor.setNomeCompleto("Andre Marques");
        professor.setEmail("andre@email.com");
        professor.setMatricula("123456");

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("wwww.pontocompontobr.com");

        Curso curso = new Curso();
        curso.setNome("Java com JPA");
        curso.setProfessor(professor);
        curso.setSigla("JPA");
        curso.setMaterialCurso(materialCurso);
        curso.getAlunos().add(aluno);

        cursoModel.create(curso);

        curso.setNome("novo curso de java!");
        cursoModel.update(curso);

        System.out.println(cursoModel.findById(curso.getId()).toString());

        System.out.println(cursoModel.findAll().toString());

        cursoModel.delete(curso);



    }
}
