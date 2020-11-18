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

/*PROTECTED REGION ID(R-85924552) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpDettaglioAttestato {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioAttestato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglioAttestato definito in un ExecCommand del
	 * ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceefree.dto.ace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-169960929) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			ArrayList<LabelValue> labelValueList = getSoaIntegrationMgr().getDettaglioAce(codiceCertificato);

			log.debug("STAMPO il labelValueList: " + labelValueList);
			log.debug("STAMPO il labelValueList.size(): " + labelValueList.size());

			theModel.setAppDatalabelValueArray(labelValueList);

			// impostazione del result code 
			result.setResultCode(VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDettaglioAttestato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDettaglioAttestato
	 */
	public static void resetClearStatus_widg_tbDettaglioAttestato(java.util.Map session) {
		session.put("cpDettaglioAttestato_tbDettaglioAttestato_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1371320708) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	/*PROTECTED REGION END*/
}
