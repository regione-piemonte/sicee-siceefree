package it.csi.sicee.siceefree.business.certificatore;

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

/*PROTECTED REGION ID(R-2029709860) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaCertificatori {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificatori, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORI_CODE = "appDatacertificatori";

	// ApplicationData: [idCertificatore, scope:USER_SESSION]
	public static final String APPDATA_IDCERTIFICATORE_CODE = "appDataidCertificatore";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [idDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTO_CODE = "appDataidDocumento";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaCertificatori";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaDettaglioCertificatore definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaCertificatori
	 */
	public ExecResults ricercaDettaglioCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRisultatoRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCADETTAGLIOCERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCADETTAGLIOCERTIFICATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1438009703) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:			

			if (!GenericUtil.isNullOrEmpty(theModel.getAppDataidCertificatore()) && isCertificatorePresente(
					theModel.getAppDataidCertificatore(), theModel.getAppDatacertificatori())) {

				Certificatore cert = getSoaIntegrationMgr().findCertificatore(theModel.getAppDataidCertificatore());
				theModel.setAppDatacertificatore(cert);
				theModel.setAppDataidDocumento(cert.getUidCurriculum());
				// impostazione del result code
				result.setResultCode(RICERCADETTAGLIOCERTIFICATORE_OUTCOME_CODE__OK);
			} else {

				theModel.setAppDataidCertificatore(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(RICERCADETTAGLIOCERTIFICATORE_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaDettaglioCertificatore] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaPulsanteDettaglio definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaCertificatori
	 */
	public ExecResults abilitaPulsanteDettaglio(

			it.csi.sicee.siceefree.dto.certificatore.CpRisultatoRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAPULSANTEDETTAGLIO_OUTCOME_CODE__ENABLE = //NOSONAR  Reason:EIAS
				"ENABLE"; //NOSONAR  Reason:EIAS
		final String ABILITAPULSANTEDETTAGLIO_OUTCOME_CODE__DISABLE = //NOSONAR  Reason:EIAS
				"DISABLE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2095762608) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDatacertificatori() != null && theModel.getAppDatacertificatori().size() > 0) {
				result.setResultCode(ABILITAPULSANTEDETTAGLIO_OUTCOME_CODE__ENABLE);
			} else {
				result.setResultCode(ABILITAPULSANTEDETTAGLIO_OUTCOME_CODE__DISABLE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaPulsanteDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoCertificatori
	 */
	public static void resetClearStatus_widg_tblRisultatoCertificatori(java.util.Map session) {
		session.put("cpRisultatoRicercaCertificatori_tblRisultatoCertificatori_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2139994414) ENABLED START*/
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

	public static boolean isCertificatorePresente(String idCertificatore, ArrayList<Certificatore> certificatoreList) {
		boolean isPresente = false;

		if (idCertificatore != null && certificatoreList != null) {
			for (Certificatore ace : certificatoreList) {

				if (idCertificatore.equals(ace.getMatricola())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}
	/*PROTECTED REGION END*/
}
