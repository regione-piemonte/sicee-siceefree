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
 * logica di business associata alla Schermata [cpDettaglioAttestato]
 */
@Validation
public class CpDettaglioAttestatoModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceefree.dto.LabelValue> appDatalabelValueArray = new java.util.ArrayList<it.csi.sicee.siceefree.dto.LabelValue>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatalabelValueArray'
	 * @param value
	 * @generated
	 */

	public void setAppDatalabelValueArray(java.util.ArrayList<it.csi.sicee.siceefree.dto.LabelValue> value) {
		appDatalabelValueArray = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalabelValueArray'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.LabelValue> getAppDatalabelValueArray() {
		return appDatalabelValueArray;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbDettaglioAttestato

	private java.lang.String widgTbDettaglioAttestato;

	public void setWidg_tbDettaglioAttestato(java.lang.String value) {
		widgTbDettaglioAttestato = value;
	}

	public java.lang.String getWidg_tbDettaglioAttestato() {
		return widgTbDettaglioAttestato;
	}

}
