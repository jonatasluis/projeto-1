package com.projeto1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto1.domain.Categoria;
import com.projeto1.domain.Cidade;
import com.projeto1.domain.Cliente;
import com.projeto1.domain.Endereco;
import com.projeto1.domain.Estado;
import com.projeto1.domain.Produto;
import com.projeto1.domain.enums.TipoCliente;
import com.projeto1.repositories.CategoriaRepository;
import com.projeto1.repositories.CidadeRepository;
import com.projeto1.repositories.ClienteRepository;
import com.projeto1.repositories.EnderecoRepository;
import com.projeto1.repositories.EstadoRepository;
import com.projeto1.repositories.ProdutoRepository;

@SpringBootApplication
public class Projeto1Application  implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cit1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade cit2 = new Cidade(null, "São Paulo" , est2);
		Cidade cit3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cit1));
		est2.getCidades().addAll(Arrays.asList(cit2,cit3));
		
		
		Cliente cliente1 = new Cliente(null, "Jônatas Luis", "jonatas.luis@gmail.com", "00716854058", TipoCliente.PESSOAFISICA);
		
		cliente1.getTelefones().addAll(Arrays.asList("54991470811","5434515657"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "", "J Pessoa", "95700-000", cliente1, cit1);
		Endereco e2 = new Endereco(null, "Rua das Neves", "100", "", "Jardim C", "95700-350", cliente1, cit2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cit1, cit2, cit3));
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
	}

}
