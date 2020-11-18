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

}
