package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class CursoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em;

    public void create(Curso curso) {
        em = emf.createEntityManager();

        try {
            System.out.println("Criando um curso no banco de dados:");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("curso criado com sucesso!!!");
        } catch (Exception e){
            System.out.println("Erro ao criar curso: "+ e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }

    }

    public void update(Curso curso) {
        em = emf.createEntityManager();

        try {
            System.out.println("Atualizando um curso no banco de dados:");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("curso atualizado com sucesso!!!");
        } catch (Exception e){
            System.out.println("Erro ao atualizar curso: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }

    }

    public Curso findById(Long id) {
        em = emf.createEntityManager();
        Curso curso = null;
        try {
            System.out.println("Buscando um curso pelo id:");

            curso = em.find(Curso.class, id);
            return curso;
        } catch (Exception e){
            System.out.println("Erro ao buscar curso: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
        return curso;
    }
    public List<Curso> findAll() {
        em = emf.createEntityManager();
        List<Curso> cursos = Collections.emptyList();
        try {
            System.out.println("Buscando todos os alunos:");
            cursos = em.createQuery("FROM "+ Curso.class.getName()).getResultList();
            return cursos;
        } catch (Exception e){
            System.out.println("Erro ao buscar cursos: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
        return cursos;
    }

    public void delete(Curso curso) {
        em = emf.createEntityManager();
        try {
            System.out.println("deletando um aluno:");
            Curso cursoDeletado = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            em.remove(cursoDeletado);
            em.getTransaction().commit();
            System.out.println("Curso deletado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao deletar curso");
            e.printStackTrace();
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
    }
}
