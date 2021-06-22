import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Produto;

/**
 * 
 */

/**
 * @author vande
 *
 */
public class ProgramaListar {
	
	private static EntityManagerFactory emf;
	
	private static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("produto");
		}
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		EntityManager em = getEntityManager();
		
		Query query = em.createQuery("select p from Produto p", Produto.class);
		produtos = query.getResultList();
		
		for (Produto produto : produtos) {
			System.out.println("======= Produto " + produto.getId() + " =======");
			System.out.println("Nome: " + produto.getName());
			System.out.println("Quantidade: " + produto.getQuantidade());
		}
		
		em.close();
		emf.close();
	}
	

}
