/**
 * 
 */
package entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {

	@Column(name = "BENEFICIAIRE", nullable = false)
	private String beneficiaire;

	/**
	 * Constructeur
	 */
	public Virement() {
		super();
	}
	
	/**
	 * Constructeur
	 * @param beneficiaire
	 */
	public Virement(LocalDateTime date, double montant, String motif, Compte compte ,String beneficiaire) {
		super(date,  montant,  motif,  compte);
		this.beneficiaire = beneficiaire;
	}



	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
