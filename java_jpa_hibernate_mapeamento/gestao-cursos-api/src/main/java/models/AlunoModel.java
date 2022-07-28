package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class AlunoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em;

    public void create(Aluno aluno) {
        em = emf.createEntityManager();

        try {
            System.out.println("Criando um aluno no banco de dados:");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso!!!" + aluno);
        } catch (Exception e){
            System.out.println("Erro ao criar aluno: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }

    }

    public void update(Aluno aluno) {
        em = emf.createEntityManager();

        try {
            System.out.println("Atualizando um aluno no banco de dados:");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso!!! " + aluno);
        } catch (Exception e){
            System.out.println("Erro ao atualizar aluno: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }

    }

    public Aluno findById(Long id) {
        em = emf.createEntityManager();
        Aluno aluno = null;
        try {
            System.out.print("Buscando um aluno pelo id: ");
            aluno = em.find(Aluno.class, id);
            return aluno;
        } catch (Exception e){
            System.out.println("Erro ao buscar aluno: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
        return aluno;
    }
    public List<Aluno> findAll() {
        em = emf.createEntityManager();
        List<Aluno> alunos = Collections.emptyList();
        try {
            System.out.println("Buscando todos os alunos");
            alunos = em.createQuery("FROM "+ Aluno.class.getName()).getResultList();
            System.out.println(alunos);
            return alunos;
        } catch (Exception e){
            System.out.println("Erro ao buscar alunos: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
        return alunos;
    }

    public void delete(Aluno aluno) {
        em = emf.createEntityManager();
        try {
            System.out.println("deletando um aluno");
            Aluno alunoDeletado = em.find(Aluno.class, aluno.getId());
            em.getTransaction().begin();
            em.remove(alunoDeletado);
            em.getTransaction().commit();
            System.out.println("Aluno " + aluno.getId() + " deletado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao deletar aluno: "+ e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transação");
        }
    }
}
