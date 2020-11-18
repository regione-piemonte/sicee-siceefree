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

/*PROTECTED REGION ID(R-1047857410) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpVerificaEmailNotai {

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
	public static final String CPNAME = "cpVerificaEmailNotai";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaEmailNotaio definito in un ExecCommand del
	 * ContentPanel cpVerificaEmailNotai
	 */
	public ExecResults verificaEmailNotaio(

			it.csi.sicee.siceefree.dto.main.CpVerificaEmailNotaiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAEMAILNOTAIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICAEMAILNOTAIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1021712814) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatanotaio().getEmail())) {
				addMissingRequiredFieldError("appDatanotaio.email", result);
				result.setResultCode(VERIFICAEMAILNOTAIO_OUTCOME_CODE__KO);
			} else {
				Notaio not = getSoaIntegrationMgr().findNotaio(theModel.getAppDatanotaio().getEmail().toLowerCase());
				theModel.setAppDatanotaio(not);

				if (not == null) {
					result.getGlobalErrors().add(
							"Attenzione: l'indirizzo e-mail inserito non &egrave; registrato presso il Notariato.");
					result.setResultCode(VERIFICAEMAILNOTAIO_OUTCOME_CODE__KO);
				} else {
					result.setResultCode(VERIFICAEMAILNOTAIO_OUTCOME_CODE__OK);
				}
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaEmailNotaio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaLogAccesso definito in un ExecCommand del
	 * ContentPanel cpVerificaEmailNotai
	 */
	public ExecResults salvaLogAccesso(

			it.csi.sicee.siceefree.dto.main.CpVerificaEmailNotaiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVALOGACCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R79023595) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Notaio notaio = theModel.getAppDatanotaio();

			getSoaIntegrationMgr().insertLogAccesso(notaio.getCodiceFiscale(), notaio.getNome(), notaio.getCognome(),
					Constants.RUOLO_NOTAIO_LOG_ACCESSO);

			// impostazione del result code 
			result.setResultCode(SALVALOGACCESSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaLogAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2003672822) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "e' obbligatorio");
	}

	/*PROTECTED REGION END*/
}
