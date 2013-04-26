package br.com.caelum.goodbuy.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import static br.com.caelum.vraptor.view.Results.*;
@Resource
public class ProdutosController {
	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	
	// metodo para listar produtos
	@Get("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}
	

	// metodo para gravar produto
	@Post("/produtos")
	public void adiciona(Produto produto) {
		//validacao(produto);
		dao.salva(produto);
		result.redirectTo(this).lista();

	}
	@Get("/produtos/novo")
	public void formulario() {
	}

	@Get("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}

	@Put("/produtos/{produto.id}")
	public void altera(Produto produto) {
		//validacao(produto);
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	@Delete("/produtos/{id}")
	public void remove(long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}

	 public List<Produto> busca(String nome) {
		    result.include("nome", nome);
		    return dao.busca(nome);
		  }
	 @Get("/produtos/busca.json")
	 public void buscaJson(String q) {
	   result.use(json()).withoutRoot()
	       .from(dao.busca(q))
	     .exclude("id", "descricao")
	     .serialize();
	 }
	public void validacao(final Produto produto) {

		if (produto.getNome() == null || produto.getNome().length() < 3) {
			validator.add(new ValidationMessage(
					"Nome é obrigatório e precisa ter mais" + " de 3 letras",
					"produto.nome"));
		}
		if (produto.getDescricao() == null
				|| produto.getDescricao().length() > 40) {
			validator.add(new ValidationMessage(
					"Descrição é obrigatória não pode ter mais"
							+ " que 40 letras", "produto.descricao"));
		}
		if (produto.getPreco() <= 0) {
			validator.add(new ValidationMessage("Preço precisa ser positivo",
					"produto.preco"));
		}
		validator.onErrorUsePageOf(ProdutosController.class).formulario();
	}
}
