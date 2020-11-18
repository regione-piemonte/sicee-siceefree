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
 * logica di business associata alla Schermata [cpErrorPage]
 */
@Validation
public class CpErrorPageModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
