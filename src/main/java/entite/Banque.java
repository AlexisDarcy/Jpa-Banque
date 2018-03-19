/**
 * 
 */
package entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "BANQUE")
public class Banque {
	
	/**id : int*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**nom : String*/
	@Column(name = "NOM", nullable = false,  unique = true)
	private String nom;
	/**listClient : Set<Client>*/
	@OneToMany(mappedBy = "banque")
	private Set<Client> listeClient = new HashSet<Client>(0);
	
	/**
	 * Constructeur
	 */
	public Banque() {

	}
	
	/**
	 * Constructeur
	 * @param id
	 * @param nom
	 */
	public Banque(String nom) {
		this.nom = nom;
	}



	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/** Getter
	 * @return the listClient
	 */
	public Set<Client> getListeClient() {
		return listeClient;
	}

	/** Setter
	 * @param listClient the listClient to set
	 */
	public void setListeClient(Set<Client> listeClient) {
		this.listeClient = listeClient;
	}
}
