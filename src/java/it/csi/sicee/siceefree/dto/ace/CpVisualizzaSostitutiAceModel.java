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
 * logica di business associata alla Schermata [cpVisualizzaSostitutiAce]
 */
@Validation
public class CpVisualizzaSostitutiAceModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblSostitutiAce

	private java.lang.String widgTblSostitutiAce;

	public void setWidg_tblSostitutiAce(java.lang.String value) {
		widgTblSostitutiAce = value;
	}

	public java.lang.String getWidg_tblSostitutiAce() {
		return widgTblSostitutiAce;
	}

}
