package br.com.caelum.goodbuy.testes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;

public class AlteracaoDeProduto {
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		// Aquisição da sessão
		Session session = new CriadorDeSession(factory).getInstance();
		
	     // carrega o produto do banco de dados                  indica o codigo do produto
	     Produto produto = alteraProduto(session);
	     
	     // alteração do produto no banco de dados
	     new ProdutoDao(session).altera(produto);
	   }

	private static Produto alteraProduto(Session session) {
		Produto produto = (Produto) session.load(Produto.class, 3L);
		return produto;
	}


}
