package it.csi.sicee.siceefree.dto.main;

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
 * logica di business associata alla Schermata [cpDettWMS]
 */
@Validation
public class CpDettWMSModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistDettaglioGeografico'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistDettaglioGeografico(
			java.util.ArrayList<it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale> value) {
		getSession().put("appDatalistDettaglioGeografico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistDettaglioGeografico'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale> getAppDatalistDettaglioGeografico() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale>) (getSession()
				.get("appDatalistDettaglioGeografico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentDettaglioGeografico'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentDettaglioGeografico(it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale value) {
		getSession().put("appDatacurrentDettaglioGeografico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentDettaglioGeografico'
	 * @generated
	 */
	public it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale getAppDatacurrentDettaglioGeografico() {
		return (it.csi.sicee.siceefree.dto.DettaglioGeograficoPortale) (getSession()
				.get("appDatacurrentDettaglioGeografico"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataWMSClass'
	 * @param value
	 * @generated
	 */

	public void setAppDataWMSClass(java.lang.String value) {
		getSession().put("appDataWMSClass", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataWMSClass'
	 * @generated
	 */
	public java.lang.String getAppDataWMSClass() {
		return (java.lang.String) (getSession().get("appDataWMSClass"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataWMSCoordinates'
	 * @param value
	 * @generated
	 */

	public void setAppDataWMSCoordinates(java.lang.String value) {
		getSession().put("appDataWMSCoordinates", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataWMSCoordinates'
	 * @generated
	 */
	public java.lang.String getAppDataWMSCoordinates() {
		return (java.lang.String) (getSession().get("appDataWMSCoordinates"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaSelezionata(java.lang.Integer value) {
		getSession().put("appDatapaginaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaSelezionata'
	 * @generated
	 */
	public java.lang.Integer getAppDatapaginaSelezionata() {
		return (java.lang.Integer) (getSession().get("appDatapaginaSelezionata"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
