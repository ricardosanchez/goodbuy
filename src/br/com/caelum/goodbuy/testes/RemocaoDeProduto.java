package br.com.caelum.goodbuy.testes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;

public class RemocaoDeProduto {
	 // Aquisição da sessão
	 public static void main(String[] args) {
		 SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		 Session session = new CriadorDeSession(factory).getInstance();
	     
	     // carrega o produto do banco de dados
	     Produto produto = removeProduto(session);
	     
	     new ProdutoDao(session).remove(produto);
	   }

	private static Produto removeProduto(Session session) {
		Produto produto = (Produto) session.load(Produto.class, 1L);
		return produto;
	}

	
	
}
