package it.csi.sicee.siceefree.dto.notaio;

public class Notaio implements java.io.Serializable {

	/// Field [nome]
	private java.lang.String nome = null;

	/**
	 * imposta il valore del campo [nome]
	 * @param val
	 * @generated
	 */

	public void setNome(java.lang.String val) {
		nome = val;
	}

	/**
	 * legge il valore del campo [nome]
	 * @generated
	 */
	public java.lang.String getNome() {
		return nome;
	}

	/// Field [cognome]
	private java.lang.String cognome = null;

	/**
	 * imposta il valore del campo [cognome]
	 * @param val
	 * @generated
	 */

	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	/**
	 * legge il valore del campo [cognome]
	 * @generated
	 */
	public java.lang.String getCognome() {
		return cognome;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [email]
	private java.lang.String email = null;

	/**
	 * imposta il valore del campo [email]
	 * @param val
	 * @generated
	 */

	public void setEmail(java.lang.String val) {
		email = val;
	}

	/**
	 * legge il valore del campo [email]
	 * @generated
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/// Field [idNotaio]
	private java.lang.Long idNotaio = null;

	/**
	 * imposta il valore del campo [idNotaio]
	 * @param val
	 * @generated
	 */

	public void setIdNotaio(java.lang.Long val) {
		idNotaio = val;
	}

	/**
	 * legge il valore del campo [idNotaio]
	 * @generated
	 */
	public java.lang.Long getIdNotaio() {
		return idNotaio;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Notaio() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1254164450) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
