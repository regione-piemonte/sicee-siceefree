package it.csi.sicee.siceefree.dto.certificatore;

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
 * logica di business associata alla Schermata [cpRisultatoRicercaCertificatori]
 */
@Validation
public class CpRisultatoRicercaCertificatoriModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatori'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatori(
			java.util.ArrayList<it.csi.sicee.siceefree.dto.certificatore.Certificatore> value) {
		getSession().put("appDatacertificatori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatori'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.certificatore.Certificatore> getAppDatacertificatori() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.certificatore.Certificatore>) (getSession()
				.get("appDatacertificatori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCertificatore'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCertificatore(java.lang.String value) {
		getSession().put("appDataidCertificatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCertificatore'
	 * @generated
	 */
	public java.lang.String getAppDataidCertificatore() {
		return (java.lang.String) (getSession().get("appDataidCertificatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatore(it.csi.sicee.siceefree.dto.certificatore.Certificatore value) {
		getSession().put("appDatacertificatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatore'
	 * @generated
	 */
	public it.csi.sicee.siceefree.dto.certificatore.Certificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceefree.dto.certificatore.Certificatore) (getSession().get("appDatacertificatore"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
