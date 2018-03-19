/**
 * 
 */
package console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Adresse;
import entite.Banque;
import entite.Client;
import entite.Compte;
import entite.Operation;

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
		
		Set<Client> listClient = new HashSet<Client>();
		Set<Client> listClientConjiont = new HashSet<Client>();
		Set<Compte> listeCompte = new HashSet<Compte>();
		
		Banque banque = new Banque();
		Adresse adresse = new Adresse();
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		Compte compte1 = new Compte();
		Compte compte2 = new Compte();
		Operation operation1 = new Operation();
		Operation operation2 = new Operation();
		Operation operation3 = new Operation();
		Operation operation4 = new Operation();
		Operation operation5 = new Operation();
				
		et.begin();
		banque.setNom("Gringotts");
		em.persist(banque);
		
		adresse.setNumero(4);
		adresse.setRue("Privet Drive");
		adresse.setCodePostal(44000);
		adresse.setVille("Little Whinging");
		
		client1.setNom("Potter");
		client1.setPrenom("Harry");
		client1.setAdresse(adresse);
		client1.setDateNaissance(LocalDate.of(1980, 7, 31));
		client1.setBanque(banque);
		listClient.add(client1);
		em.persist(client1);
		
		client2.setNom("Potter");
		client2.setPrenom("Lily");
		client2.setAdresse(adresse);
		client2.setDateNaissance(LocalDate.of(1960, 1, 30));
		client2.setBanque(banque);
		listClientConjiont.add(client2);
		em.persist(client2);
		
		client3.setNom("Potter");
		client3.setPrenom("James");
		client3.setAdresse(adresse);
		client3.setDateNaissance(LocalDate.of(1960, 3, 27));
		client3.setBanque(banque);
		listClientConjiont.add(client3);
		em.persist(client3);
		

		compte1.setNumero("521FS1");
		compte1.setSolde(50000.00);
		compte1.setListeClient(listClient);
		listeCompte.add(compte1);
		client1.setListeCompte(listeCompte);
		em.persist(compte1);
		
		listeCompte = new HashSet<Compte>();
		compte2.setNumero("520FS1");
		compte2.setSolde(100000.00);
		listeCompte.add(compte2);
		compte2.setListeClient(listClientConjiont);
		client2.setListeCompte(listeCompte);
		client3.setListeCompte(listeCompte);
		em.persist(compte2);
		
		operation1.setCompte(compte1);
		operation1.setDate(LocalDateTime.of(LocalDate.of(1992, 3, 27), LocalTime.of(12, 0, 0)));
		operation1.setMontant(2000);
		operation1.setMotif("Rentrer scolaire");
		em.persist(operation1);
		
		
		operation2.setCompte(compte1);
		operation2.setDate(LocalDateTime.of(LocalDate.of(1994, 3, 27), LocalTime.of(12, 0, 0)));
		operation2.setMontant(2000);
		operation2.setMotif("Achat balai");
		em.persist(operation2);
		
		operation3.setCompte(compte2);
		operation3.setDate(LocalDateTime.of(LocalDate.of(1978, 12, 31), LocalTime.of(12, 0, 0)));
		operation3.setMontant(50000);
		operation3.setMotif("Achat maison");
		em.persist(operation3);
		
		operation4.setCompte(compte2);
		operation4.setDate(LocalDateTime.of(LocalDate.of(1979, 8, 14), LocalTime.of(12, 0, 0)));
		operation4.setMontant(2000);
		operation4.setMotif("Mariage");
		em.persist(operation4);
		
		operation5.setCompte(compte2);
		operation5.setDate(LocalDateTime.of(LocalDate.of(1980, 7, 31), LocalTime.of(12, 0, 0)));
		operation5.setMontant(500);
		operation5.setMotif("Achat Naissance");
		em.persist(operation5);
		
		et.commit();
		
		em.close();
		entityManagerFactory.close();
	}

}
