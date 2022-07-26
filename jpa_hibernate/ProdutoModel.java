package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {
    public void create(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("criando um produto");
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!" + produto);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("atualizando um produto");
            Produto p = em.find(Produto.class, produto.getId());
            em.getTransaction().begin();
            p.setNome("nome atualizado");
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!" + p);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("deletando um produto");
            Produto p = em.find(Produto.class, produto.getId());
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Produto deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void findById(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Buscando um produto por id");
            Produto p1 = em.find(Produto.class, produto.getId());
            System.out.println(p1);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Buscando todos os produtos");
            List<Produto> produtos = em.createQuery("FROM " + Produto.class.getName()).getResultList();
            return produtos;
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return null;
    }
}
