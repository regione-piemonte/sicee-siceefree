package it.csi.sicee.siceefree.dto.ace;

import java.util.*;
import it.csi.sicee.siceefree.dto.*;
import it.csi.sicee.siceefree.dto.ace.*;
import it.csi.sicee.siceefree.dto.certificatore.*;
import it.csi.sicee.siceefree.dto.geo.*;
import it.csi.sicee.siceefree.dto.notaio.*;
import it.csi.sicee.siceefree.dto.common.*;

import it.csi.sicee.siceefree.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpRisultatoRicercaAce]
 */
@Validation
public class CpRisultatoRicercaAceModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificati'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificati(java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace> value) {
		getSession().put("appDatacertificati", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificati'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace> getAppDatacertificati() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace>) (getSession().get("appDatacertificati"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidDocumento'
	 * @param value
	 * @generated
	 */

	public void setAppDataidDocumento(java.lang.String value) {
		getSession().put("appDataidDocumento", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidDocumento'
	 * @generated
	 */
	public java.lang.String getAppDataidDocumento() {
		return (java.lang.String) (getSession().get("appDataidDocumento"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAceSelezionato(java.lang.String value) {
		getSession().put("appDatacodAceSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodAceSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodAceSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacheckNotaio'
	 * @param value
	 * @generated
	 */

	public void setAppDatacheckNotaio(java.lang.Boolean value) {
		getSession().put("appDatacheckNotaio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacheckNotaio'
	 * @generated
	 */
	public java.lang.Boolean getAppDatacheckNotaio() {
		return (java.lang.Boolean) (getSession().get("appDatacheckNotaio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatanotaio'
	 * @param value
	 * @generated
	 */

	public void setAppDatanotaio(it.csi.sicee.siceefree.dto.notaio.Notaio value) {
		getSession().put("appDatanotaio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatanotaio'
	 * @generated
	 */
	public it.csi.sicee.siceefree.dto.notaio.Notaio getAppDatanotaio() {
		return (it.csi.sicee.siceefree.dto.notaio.Notaio) (getSession().get("appDatanotaio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatafiltroAce'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroAce(it.csi.sicee.siceefree.dto.ace.FiltroRicercaAce value) {
		getSession().put("appDatafiltroAce", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroAce'
	 * @generated
	 */
	public it.csi.sicee.siceefree.dto.ace.FiltroRicercaAce getAppDatafiltroAce() {
		return (it.csi.sicee.siceefree.dto.ace.FiltroRicercaAce) (getSession().get("appDatafiltroAce"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatiSostitutivi'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatiSostitutivi(java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace> value) {
		getSession().put("appDatacertificatiSostitutivi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatiSostitutivi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace> getAppDatacertificatiSostitutivi() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.ace.Ace>) (getSession()
				.get("appDatacertificatiSostitutivi"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
