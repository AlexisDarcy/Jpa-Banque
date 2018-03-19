/**
 * 
 */
package entite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "CLIENT")
public class Client {
	/**id : int*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**nom : String*/
	@Column(name = "NOM", nullable = false)
	private String nom;
	/**prenom : String*/
	@Column(name = "PRENOM", nullable = false)
	private String prenom;
	/**dateNaissance : String*/
	@Column(name = "DATE_NAISSANCE", nullable = false)
	private LocalDate dateNaissance;
	/**adresse : Adresse*/
	@Embedded
	private Adresse adresse;
	/**banque : Banque*/
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	/**listCompte : Set<Compte>*/
	@ManyToMany
	@JoinTable(name="POSSEDE", 
		joinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_COM", referencedColumnName="ID"))
	private Set<Compte> listeCompte;
	
	/**
	 * Constructeur
	 *
	 */
	public Client() {
		
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the listeCompte
	 */
	public Set<Compte> getListeCompte() {
		return listeCompte;
	}

	/** Setter
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(Set<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}
}
