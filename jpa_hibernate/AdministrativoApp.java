package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Teste");
        pessoa1.setIdade(18);
        pessoa1.setCpf("1111111111");
        pessoa1.setDataNascimento(sdf.parse("25/05/1995"));

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) buscando um produto pelo id;
        produtoModel.findById(p1);

        //4) atualizando um produto
        produtoModel.update(p1);

        produtoModel.findById(p1);

        //5) removendo um produto
        produtoModel.delete(p1);

        // 1) Criando uma Pessoa
        pessoaModel.create(pessoa1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontrados : " + pessoas.size());

        //3) buscando uma pessoa pelo id;
        pessoaModel.findById(pessoa1);

        //5) atualizando uma pessoa
        pessoaModel.update(pessoa1);

        pessoaModel.findById(pessoa1);

        //4) removendo uma pessoa
        pessoaModel.delete(pessoa1);




    }
}
