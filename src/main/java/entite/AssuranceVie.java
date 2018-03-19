/**
 * 
 */
package entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alexis Darcy
 *
 */
@Entity
@Table(name = "ASSURANCEVIE")
public class AssuranceVie extends Compte {
	
	@Column(name = "DATEFIN", nullable = false)
	private LocalDate dateFin;
	
	/**taux : double*/
	@Column(name = "TAUX", nullable = false)
	private double taux;

	/**
	 * Constructeur
	 */
	public AssuranceVie() {
		super();
	}

	/**
	 * Constructeur
	 * @param dateFin
	 * @param taux
	 */
	public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}


	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
