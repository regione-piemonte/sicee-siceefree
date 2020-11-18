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

/*PROTECTED REGION ID(R1573794296) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpRicercaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [filtroAce, scope:USER_SESSION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [certificati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATI_CODE = "appDatacertificati";

	// ApplicationData: [checkNotaio, scope:USER_SESSION]
	public static final String APPDATA_CHECKNOTAIO_CODE = "appDatacheckNotaio";

	// ApplicationData: [notaio, scope:USER_SESSION]
	public static final String APPDATA_NOTAIO_CODE = "appDatanotaio";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAce definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAce(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String RICERCAACE_OUTCOME_CODE__ABNORMAL = //NOSONAR  Reason:EIAS
				"ABNORMAL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R722342487) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//			if (theModel.getAppDatanotaio() != null) {

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			if (checkFiltroAce(filtro, result)) {

				filtro.setStato(Constants.INVIATO_ANNULLATO);

				ArrayList<Ace> ace = (ArrayList<Ace>) getSoaIntegrationMgr().findAce(filtro);
				theModel.setAppDatacertificati(ace);

				result.setResultCode(RICERCAACE_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(RICERCAACE_OUTCOME_CODE__KO);
			}
			//			} else {
			//
			//				result.setResultCode(RICERCAACE_OUTCOME_CODE__ABNORMAL);
			//				log.info("ABNORMAL!!! Uso fraudolento nella ricerca ace.");
			//
			//			}

			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1660213186) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAceByFiltro definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__ABNORMAL = //NOSONAR  Reason:EIAS
				"ABNORMAL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1922690648) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

			if (checkFiltroAce2(filtro)) {

				log.debug("STAMPO LO STATO: " + filtro.getStato());

				Integer countAce = getSoaIntegrationMgr().findAceFiltroCount(filtro);

				log.debug("Stampo il countAce: " + countAce);
				ArrayList<Ace> aceList = null;

				if (countAce != null && countAce > 0) {

					Integer numMax = Converter
							.convertToInteger(getSoaIntegrationMgr().getParametro(Constants.NUMERO_MAX_ACE_FREE));

					log.debug("Stampo il numMax: " + numMax);

					if (countAce < numMax) {

						/*
						aceList = (ArrayList<Ace>) getCertificatoMgr()
								.getCertificatiAnnullaSostByParametri(filtro,
										idCerificatore, statoAce, flgPregresso);
						 */
						filtro.setStato(Constants.INVIATO_ANNULLATO);
						aceList = (ArrayList<Ace>) getSoaIntegrationMgr().findAceFiltro(filtro);

						// impostazione del result code
						result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Sono stati estratti " + countAce
								+ " record. E' necessario restringere il campo della ricerca. Il massimo consentito e' "
								+ numMax + " record.");

						result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
					}
				} else {
					aceList = new ArrayList<Ace>();
					result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
				}
				theModel.setAppDatacertificati(aceList);

			} else {
				result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAceByFiltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciCombo definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBO_OUTCOME_CODE__OKCOMBO = //NOSONAR  Reason:EIAS
				"OKCOMBO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R129722134) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);

			// impostazione del result code
			result.setResultCode(GESTISCICOMBO_OUTCOME_CODE__OKCOMBO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciCombo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo precaricaFiltroRicercaACE definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA = //NOSONAR  Reason:EIAS
				"OKPRECARICA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-634064405) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();
			if (filtro == null) {
				filtro = new FiltroRicercaAce();
				filtro.setStato(Constants.INVIATO_ANNULLATO);
			}

			theModel.setAppDatafiltroAce(filtro);

			// impostazione del result code 
			result.setResultCode(PRECARICAFILTRORICERCAACE_OUTCOME_CODE__OKPRECARICA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::precaricaFiltroRicercaACE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1524485308) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private boolean checkFiltroAce(FiltroRicercaAce filtro, ExecResults result) {
		int errors = 0;
		if (!GenericUtil.checkValideFourNumber(filtro.getAnno())) {
			errors++;
		}
		if (!GenericUtil.checkValideSixNumber(filtro.getCertificatore())) {
			errors++;
		}
		if (!GenericUtil.checkValideFourNumber(filtro.getNumero())) {
			errors++;
		}

		if (errors > 0) {
			result.getGlobalErrors().add("Tutti i campi sono obbligatori e numerici.");
			return false;
		}

		return true;
	}

	public static boolean checkFiltroAce2(FiltroRicercaAce filtro) {

		if (isNullOrEmpty(filtro.getCodProv()) && isNullOrEmpty(filtro.getCodComune())
				&& isNullOrEmpty(filtro.getDescComune()) && isNullOrEmpty(filtro.getDescIndirizzo())
				&& isNullOrEmpty(filtro.getNumCivico()) && isNullOrEmpty(filtro.getSezione())
				&& isNullOrEmpty(filtro.getFoglio()) && isNullOrEmpty(filtro.getParticella())
				&& isNullOrEmpty(filtro.getSubalterno()) && isNullOrEmpty(filtro.getStato())) {
			return false;
		}

		return true;
	}

	private void gestisciComboDtCatasto(it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel) throws BEException {

		FiltroRicercaAce filtro = theModel.getAppDatafiltroAce();

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		province = (ArrayList<Provincia>) getSoaIntegrationMgr().getProvinceByPiemonte();
		theModel.setAppDataprovince(province);

		String actProvSel = filtro != null ? filtro.getCodProv() : null;
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSoaIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuni(comuni);
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
