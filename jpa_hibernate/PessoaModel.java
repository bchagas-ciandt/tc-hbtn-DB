package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {
    public void create(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Criando uma pessoa");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!" + pessoa);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Atualizando uma pessoa");
            Pessoa p = em.find(Pessoa.class, pessoa.getId());
            em.getTransaction().begin();
            p.setNome("Nome Atualizado");
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!" + p);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Deletando uma pessoa");
            Pessoa p = em.find(Pessoa.class, pessoa.getId());
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void findById(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Buscando uma pessoa por id");
            Pessoa p1 = em.find(Pessoa.class, pessoa.getId());
            System.out.println(p1);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Buscando todas as pessoas");
            List<Pessoa> pessoas = em.createQuery("FROM " + Pessoa.class.getName()).getResultList();
            return pessoas;
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return null;
    }
}
