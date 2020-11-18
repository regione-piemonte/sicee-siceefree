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

/*PROTECTED REGION ID(R-680752879) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpRisultatoRicercaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [certificati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATI_CODE = "appDatacertificati";

	// ApplicationData: [idDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTO_CODE = "appDataidDocumento";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [checkNotaio, scope:USER_SESSION]
	public static final String APPDATA_CHECKNOTAIO_CODE = "appDatacheckNotaio";

	// ApplicationData: [notaio, scope:USER_SESSION]
	public static final String APPDATA_NOTAIO_CODE = "appDatanotaio";

	// ApplicationData: [filtroAce, scope:USER_SESSION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [certificatiSostitutivi, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATISOSTITUTIVI_CODE = "appDatacertificatiSostitutivi";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoRicercaAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaReport definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAREPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAREPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1747431416) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDatacertificati())) {
				// impostazione del result code 
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__OK);
			} else {

				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invioAce definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults invioAce(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIOACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2121705762) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDatacertificati())) {

				Ace ace = getSoaIntegrationMgr().findAce(codiceCertificato);

				if (ace != null) {
					if (ace.getIdStato() == Constants.INVIATO) {
						if (getSoaIntegrationMgr().updateInvioLog(theModel.getAppDatanotaio(), ace)) {
							result.getGlobalMessages().add("E-mail inviata correttamente.");
						} else {
							result.getGlobalErrors()
									.add("Problema nell'invio della e-mail. Contattare l'assistenza tecnica.");
						}
					} else {
						result.getGlobalErrors()
								.add("Il certificato &egrave; in stato annullato, non lo si pu&ograve; inviare.");
					}
				} else {
					result.getGlobalErrors().add("Problema nel recupero del certificato.");
				}
			} else {

				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
			}

			result.setResultCode(INVIOACE_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::invioAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaCopia definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaCopia(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPACOPIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1543213264) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDatacertificati())) {

				Ace ace = getSoaIntegrationMgr().findAce(codiceCertificato);

				if (ace != null) {
					if (ace.getIdStato() == Constants.INVIATO) {

						// IMPLEMENTARE LA STAMPA

					} else {
						result.getGlobalErrors()
								.add("Il certificato &egrave; in stato annullato, non lo si pu&ograve; stampare.");
					}
				} else {
					result.getGlobalErrors().add("Problema nel recupero del certificato.");
				}
			} else {

				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
			}

			// impostazione del result code 
			result.setResultCode(STAMPACOPIA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaCopia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciSostituzioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults gestisciSostituzioni(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCISOSTITUZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCISOSTITUZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1420570483) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)) {

				Ace ace = getSoaIntegrationMgr().findAce(codiceCertificato);

				if (ace != null) {
					if (ace.getIdStato() == Constants.ANNULLATO || ace.getIdStato() == Constants.ANNULLATO_BO) {

						//theModel.setAppDatacodAceSelezionato(ace.getCodice());

						ArrayList<Ace> aceListSostitutivi = (ArrayList<Ace>) getSoaIntegrationMgr()
								.findAceSostitutivi(codiceCertificato);
						theModel.setAppDatacertificatiSostitutivi(aceListSostitutivi);

						result.setResultCode(GESTISCISOSTITUZIONI_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Il certificato non e' in stato annullato.");
						result.setResultCode(GESTISCISOSTITUZIONI_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Problema nel recupero del certificato.");
					result.setResultCode(GESTISCISOSTITUZIONI_OUTCOME_CODE__KO);

				}
			} else {
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(GESTISCISOSTITUZIONI_OUTCOME_CODE__KO);

			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciSostituzioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaPulsanteInvioAce definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteInvioAce(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAPULSANTEINVIOACE_OUTCOME_CODE__ENABLE = //NOSONAR  Reason:EIAS
				"ENABLE"; //NOSONAR  Reason:EIAS
		final String ABILITAPULSANTEINVIOACE_OUTCOME_CODE__DISABLE = //NOSONAR  Reason:EIAS
				"DISABLE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1141973978) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDatacheckNotaio() && theModel.getAppDatacertificati() != null
					&& theModel.getAppDatacertificati().size() > 0) {
				result.setResultCode(ABILITAPULSANTEINVIOACE_OUTCOME_CODE__ENABLE);
			} else {
				result.setResultCode(ABILITAPULSANTEINVIOACE_OUTCOME_CODE__DISABLE);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaPulsanteInvioAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaPulsanteSostituzioni definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteSostituzioni(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAPULSANTESOSTITUZIONI_OUTCOME_CODE__ENABLE_SOS = //NOSONAR  Reason:EIAS
				"ENABLE_SOS"; //NOSONAR  Reason:EIAS
		final String ABILITAPULSANTESOSTITUZIONI_OUTCOME_CODE__DISABLE_SOS = //NOSONAR  Reason:EIAS
				"DISABLE_SOS"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-763002012) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (theModel.getAppDatacertificati() != null && theModel.getAppDatacertificati().size() > 0) {
				result.setResultCode(ABILITAPULSANTESOSTITUZIONI_OUTCOME_CODE__ENABLE_SOS);
			} else {
				result.setResultCode(ABILITAPULSANTESOSTITUZIONI_OUTCOME_CODE__DISABLE_SOS);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaPulsanteSostituzioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaPulsanteStampaCopia definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteStampaCopia(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAPULSANTESTAMPACOPIA_OUTCOME_CODE__ENABLE_COPIA = //NOSONAR  Reason:EIAS
				"ENABLE_COPIA"; //NOSONAR  Reason:EIAS
		final String ABILITAPULSANTESTAMPACOPIA_OUTCOME_CODE__DISABLE_COPIA = //NOSONAR  Reason:EIAS
				"DISABLE_COPIA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R135046792) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if ((!theModel.getAppDatacheckNotaio()) && theModel.getAppDatacertificati() != null
					&& theModel.getAppDatacertificati().size() > 0) {
				result.setResultCode(ABILITAPULSANTESTAMPACOPIA_OUTCOME_CODE__ENABLE_COPIA);
			} else {
				result.setResultCode(ABILITAPULSANTESTAMPACOPIA_OUTCOME_CODE__DISABLE_COPIA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaPulsanteStampaCopia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaPulsanteStampaReport definito in un ExecCommand del
	 * ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteStampaReport(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAPULSANTESTAMPAREPORT_OUTCOME_CODE__ENABLE_REPORT = //NOSONAR  Reason:EIAS
				"ENABLE_REPORT"; //NOSONAR  Reason:EIAS
		final String ABILITAPULSANTESTAMPAREPORT_OUTCOME_CODE__DISABLE_REPORT = //NOSONAR  Reason:EIAS
				"DISABLE_REPORT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1043943744) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			if (theModel.getAppDatacertificati() != null && theModel.getAppDatacertificati().size() > 0) {
				result.setResultCode(ABILITAPULSANTESTAMPAREPORT_OUTCOME_CODE__ENABLE_REPORT);
			} else {
				result.setResultCode(ABILITAPULSANTESTAMPAREPORT_OUTCOME_CODE__DISABLE_REPORT);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaPulsanteStampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoAce
	 */
	public static void resetClearStatus_widg_tblRisultatoAce(java.util.Map session) {
		session.put("cpRisultatoRicercaAce_tblRisultatoAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1647327165) ENABLED START*/
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
