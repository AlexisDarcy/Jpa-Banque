/**
 * 
 */
package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {
	
	/**taux : double*/
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/**
	 * Constructeur
	 */
	public LivretA() {
		super();
	}

	/**
	 * Constructeur
	 * @param taux
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

}
