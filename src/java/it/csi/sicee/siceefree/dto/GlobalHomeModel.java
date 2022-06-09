package it.csi.sicee.siceefree.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sicee.siceefree.dto.ace.*;
import it.csi.sicee.siceefree.dto.certificatore.*;
import it.csi.sicee.siceefree.dto.geo.*;
import it.csi.sicee.siceefree.dto.notaio.*;
import it.csi.sicee.siceefree.dto.common.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla OnInit action
 */
public class GlobalHomeModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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
	 * Activation Param [tipo]
	 * @generated
	 */
	private java.lang.String tipo = null;

	/**
	 * imposta il valore dell' Activation Param [tipo]
	 * @praram val
	 * @generated
	 */
	public void setTipo(java.lang.String val) {
		tipo = val;
	}

	/**
	 * legge il valore dell' Activation Param [tipo]
	 * @generated
	 */
	public java.lang.String getTipo() {
		return tipo;
	}

	/**
	 * Activation Param [wms]
	 * @generated
	 */
	private java.lang.String wms = null;

	/**
	 * imposta il valore dell' Activation Param [wms]
	 * @praram val
	 * @generated
	 */
	public void setWms(java.lang.String val) {
		wms = val;
	}

	/**
	 * legge il valore dell' Activation Param [wms]
	 * @generated
	 */
	public java.lang.String getWms() {
		return wms;
	}

	/**
	 * Activation Param [classe]
	 * @generated
	 */
	private java.lang.String classe = null;

	/**
	 * imposta il valore dell' Activation Param [classe]
	 * @praram val
	 * @generated
	 */
	public void setClasse(java.lang.String val) {
		classe = val;
	}

	/**
	 * legge il valore dell' Activation Param [classe]
	 * @generated
	 */
	public java.lang.String getClasse() {
		return classe;
	}

}
