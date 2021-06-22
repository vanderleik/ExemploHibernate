import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Produto;

/**
 * 
 */

/**
 * @author vande
 *
 */
public class ProgramaCadastrar {

	private static EntityManagerFactory emf;
	private static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("produto");
		}
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		Produto produto1 = new Produto();
		produto1.setName("Computador");
		produto1.setQuantidade(100);
		
		Produto produto2 = new Produto();
		produto2.setName("Mouse");
		produto2.setQuantidade(200);
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto1);
		em.persist(produto2);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		
	}
}
