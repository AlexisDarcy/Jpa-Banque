/**
 * 
 */
package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Adresse;
import entite.AssuranceVie;
import entite.Banque;
import entite.Client;
import entite.Compte;
import entite.LivretA;
import entite.Operation;
import entite.Virement;

/**
 * @author Alexis Darcy
 *
 */
public class Console {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();		
				
		et.begin();
		
		Banque banque = new Banque("Gringotts");

		Adresse adresse = new Adresse(4, "Privet Drive", 44000, "Little Whinging");

		Client client1 = new Client("Potter", "Harry", LocalDate.of(1980, 7, 31), adresse, banque);

		Client client2 = new Client("Potter", "Lily", LocalDate.of(1960, 1, 30), adresse, banque);
		
		Client client3 = new Client("Potter", "James", LocalDate.of(1960, 3, 27), adresse, banque);
		
		Compte livretA1 = new LivretA("521FS1", 50000.00, 0.75);
		
		Compte livretA2 = new LivretA("520FS1", 100000.00, 0.75);
		
		Compte assuranceVie1 = new AssuranceVie("361FS1", 150000.00, LocalDate.of(2020, 7, 31) ,0.75);
		
		Compte assuranceVie2 = new AssuranceVie("360FS1", 50000.00, LocalDate.of(2020, 3, 27) ,0.75);
		
		Compte assuranceVie3 = new AssuranceVie("362FS1", 50000.00, LocalDate.of(2020, 1, 30) ,0.75);
		
		Operation operation1 = new Virement(LocalDateTime.of(LocalDate.of(1992, 3, 27), LocalTime.of(12, 0, 0)), 5000, "Rentrer scolaire", livretA1, "Poudlard");
		
		Operation operation2 = new Virement(LocalDateTime.of(LocalDate.of(1994, 3, 27), LocalTime.of(12, 0, 0)), 2000, "Achat balai", livretA1, "Haggrid");
		
		Operation operation3 = new Virement(LocalDateTime.of(LocalDate.of(1978, 12, 31), LocalTime.of(12, 0, 0)), 50000, "Achat maison", livretA2, "Agence immobilier");
		
		Operation operation4 = new Virement(LocalDateTime.of(LocalDate.of(1979, 8, 14), LocalTime.of(12, 0, 0)), 2000, "Mariage", livretA2, "Traiteur");

		Operation operation5 = new Virement(LocalDateTime.of(LocalDate.of(1980, 7, 31), LocalTime.of(12, 0, 0)), 500, "Achat Naissance", livretA2, "Cadeau de naissance");
		
		Operation operation6 = new Virement(LocalDateTime.of(LocalDate.of(1992, 3, 27), LocalTime.of(12, 0, 0)), 5000, "Rentrer scolaire", assuranceVie1, "Poudlard");
		
		Operation operation7 = new Virement(LocalDateTime.of(LocalDate.of(1994, 3, 27), LocalTime.of(12, 0, 0)), 2000, "Achat balai", assuranceVie1, "Haggrid");
		
		Operation operation8 = new Virement(LocalDateTime.of(LocalDate.of(1979, 8, 14), LocalTime.of(12, 0, 0)), 2000, "Mariage", assuranceVie2, "Traiteur");
		
		Operation operation9 = new Virement(LocalDateTime.of(LocalDate.of(1978, 12, 31), LocalTime.of(12, 0, 0)), 50000, "Achat maison", assuranceVie2, "Agence immobilier");
	
		Operation operation10 = new Virement(LocalDateTime.of(LocalDate.of(1980, 7, 31), LocalTime.of(12, 0, 0)), 500, "Achat Naissance", assuranceVie3, "Cadeau de naissance");
		
		livretA1.getListeClient().add(client1);
		
		livretA2.getListeClient().add(client2);
		
		livretA2.getListeClient().add(client3);
		
		assuranceVie1.getListeClient().add(client1);
		
		assuranceVie2.getListeClient().add(client2);
		
		assuranceVie3.getListeClient().add(client3);
		
		em.persist(banque);
		
		em.persist(client1);
		
		em.persist(client2);
		
		em.persist(client3);
		
		em.persist(livretA1);
		
		em.persist(livretA2);
		
		em.persist(assuranceVie1);
		
		em.persist(assuranceVie2);
		
		em.persist(assuranceVie3);
		
		em.persist(operation1);
		
		em.persist(operation2);
		
		em.persist(operation3);
		
		em.persist(operation4);
		
		em.persist(operation5);
		
		em.persist(operation6);
		
		em.persist(operation7);
		
		em.persist(operation8);
		
		em.persist(operation9);
		
		em.persist(operation10);
		
		et.commit();
		
		em.close();
		entityManagerFactory.close();
	}

}
