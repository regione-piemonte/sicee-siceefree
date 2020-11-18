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
 * logica di business associata alla Schermata [cpRicercaAce]
 */
@Validation
public class CpRicercaAceModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
