package it.csi.sicee.siceefree.business.main;

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

/*PROTECTED REGION ID(R-201235706) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpHomeHome {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [notaio, scope:USER_SESSION]
	public static final String APPDATA_NOTAIO_CODE = "appDatanotaio";

	// ApplicationData: [checkNotaio, scope:USER_SESSION]
	public static final String APPDATA_CHECKNOTAIO_CODE = "appDatacheckNotaio";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpHomeHome";

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1632522670) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
