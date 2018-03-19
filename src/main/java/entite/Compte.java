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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
	
	/**id : int*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**numero : String*/
	@Column(name = "NUMERO")
	private String numero;
	/**solde : double*/
	@Column(name = "SOLDE")
	private double solde;
	/**listClient : Set<Client>*/
	@ManyToMany
	@JoinTable(name="POSSEDE", 
		joinColumns=@JoinColumn(name="ID_CPT", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="ID"))
	private Set<Client> listeClient = new HashSet<Client>(0);
	/**listeOperation : Set<Operation>*/
	@OneToMany(mappedBy = "compte")
	private Set<Operation> listeOperation = new HashSet<Operation>(0);
	
	/**
	 * Constructeur
	 */
	public Compte() {
		
	}

	/**
	 * Constructeur
	 * @param id
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/** Getter
	 * @return the listeClient
	 */
	public Set<Client> getListeClient() {
		return listeClient;
	}

	/** Setter
	 * @param listeClient the listeClient to set
	 */
	public void setListeClient(Set<Client> listeClient) {
		this.listeClient = listeClient;
	}

	/** Getter
	 * @return the listeOperation
	 */
	public Set<Operation> getListeOperation() {
		return listeOperation;
	}

	/** Setter
	 * @param listeOperation the listeOperation to set
	 */
	public void setListeOperation(Set<Operation> listeOperation) {
		this.listeOperation = listeOperation;
	}
	
}
