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
 * logica di business associata alla Schermata [cpRicercaCertificatori]
 */
@Validation
public class CpRicercaCertificatoriModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatafiltroCertificatore'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroCertificatore(
			it.csi.sicee.siceefree.dto.certificatore.FiltroRicercaCertificatori value) {
		getSession().put("appDatafiltroCertificatore", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroCertificatore'
	 * @generated
	 */
	public it.csi.sicee.siceefree.dto.certificatore.FiltroRicercaCertificatori getAppDatafiltroCertificatore() {
		return (it.csi.sicee.siceefree.dto.certificatore.FiltroRicercaCertificatori) (getSession()
				.get("appDatafiltroCertificatore"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuni'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuni(java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Comune> value) {
		getSession().put("appDatacomuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Comune> getAppDatacomuni() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Comune>) (getSession().get("appDatacomuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovince'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovince(java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Provincia> value) {
		getSession().put("appDataprovince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Provincia> getAppDataprovince() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Provincia>) (getSession().get("appDataprovince"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitoli'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitoli(java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Titolo> value) {
		getSession().put("appDatatitoli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitoli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Titolo> getAppDatatitoli() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Titolo>) (getSession().get("appDatatitoli"));
	}

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
	 * imposta il valore dell' ApplicationData 'appDataregioni'
	 * @param value
	 * @generated
	 */

	public void setAppDataregioni(java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Regione> value) {
		getSession().put("appDataregioni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregioni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Regione> getAppDataregioni() {
		return (java.util.ArrayList<it.csi.sicee.siceefree.dto.geo.Regione>) (getSession().get("appDataregioni"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
