package it.csi.sicee.siceefree.business.ace;

import java.util.*;

import it.csi.sicee.siceefree.dto.*;
import it.csi.sicee.siceefree.dto.ace.*;
import it.csi.sicee.siceefree.dto.certificatore.*;
import it.csi.sicee.siceefree.dto.geo.*;
import it.csi.sicee.siceefree.dto.notaio.*;
import it.csi.sicee.siceefree.dto.common.*;

import org.apache.log4j.*;
import it.csi.sicee.siceefree.util.*;
import it.csi.sicee.siceefree.business.*;

/*PROTECTED REGION ID(R-504307221) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpVisualizzaSostitutiAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificatiSostitutivi, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATISOSTITUTIVI_CODE = "appDatacertificatiSostitutivi";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpVisualizzaSostitutiAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblSostitutiAce
	 */
	public static void resetClearStatus_widg_tblSostitutiAce(java.util.Map session) {
		session.put("cpVisualizzaSostitutiAce_tblSostitutiAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1601941655) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
