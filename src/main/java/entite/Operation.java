/**
 * 
 */
package entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Operation {
	/**id : int*/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/**date : LocalDateTime*/
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date;
	/**montant : double*/
	@Column(name = "MONTANT", nullable = false)
	private double montant;
	/**motif : String*/
	@Column(name = "MOTIF")
	private String motif;
	/**compte : Compte*/
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte;
	
	/**
	 * Constructeur
	 */
	public Operation() {

	}

	/**
	 * Constructeur
	 * @param id
	 * @param date
	 * @param montant
	 * @param motif
	 * @param compte
	 */
	public Operation(LocalDateTime date, double montant, String motif, Compte compte) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/** Setter
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/** Getter
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
		
}
