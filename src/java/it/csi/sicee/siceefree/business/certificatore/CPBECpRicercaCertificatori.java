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

/*PROTECTED REGION ID(R-1210971645) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;
/*PROTECTED REGION END*/

public class CPBECpRicercaCertificatori {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [filtroCertificatore, scope:USER_SESSION]
	public static final String APPDATA_FILTROCERTIFICATORE_CODE = "appDatafiltroCertificatore";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [certificatori, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORI_CODE = "appDatacertificatori";

	// ApplicationData: [regioni, scope:USER_SESSION]
	public static final String APPDATA_REGIONI_CODE = "appDataregioni";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaCertificatori";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneRicercaCertificatore definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setRegioneRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONERICERCACERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1301847796) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatafiltroCertificatore().setProvincia(null);
			theModel.getAppDatafiltroCertificatore().setComune(null);
			theModel.setAppDatacomuni(new ArrayList<Comune>());
			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneRicercaCertificatore] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaRicercaCertificatore definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setProvinciaRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIARICERCACERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1949057712) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDatafiltroCertificatore().setComune(null);

			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::setProvinciaRicercaCertificatore] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComuneRicercaCertificatore definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setComuneRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNERICERCACERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2111376746) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComuneRicercaCertificatore] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaCertificatori definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults ricercaCertificatori(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCACERTIFICATORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCACERTIFICATORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1032110327) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<Certificatore> cert = (ArrayList<Certificatore>) getSoaIntegrationMgr()
					.findElencoCertificatore(theModel.getAppDatafiltroCertificatore());
			theModel.setAppDatacertificatori(cert);
			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaCertificatori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R968981062) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatafiltroCertificatore() == null) {
				theModel.setAppDatafiltroCertificatore(new FiltroRicercaCertificatori());
			}
			caricaCombo(theModel);

			// impostazione del result code
			result.setResultCode("OK");
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-872093423) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private void caricaCombo(it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel)
			throws BEException {

		if (theModel.getAppDataregioni() == null) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSoaIntegrationMgr().getAllRegioni();
			theModel.setAppDataregioni(regioni);
		}
		String actRegSel = theModel.getAppDatafiltroCertificatore().getRegione();
		log.debug("Regione selezionata: " + actRegSel);
		String actProvSel = theModel.getAppDatafiltroCertificatore().getProvincia();
		log.debug("Provincia selezionata: " + actProvSel);
		String actComSel = theModel.getAppDatafiltroCertificatore().getComune();
		log.debug("Comune selezionato: " + actComSel);

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSoaIntegrationMgr().getProvinceByRegione(actRegSel);
		}

		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSoaIntegrationMgr().getComuniByProvincia(actProvSel.toString());
		}

		theModel.setAppDataprovince(province);
		theModel.setAppDatacomuni(comuni);

		if (theModel.getAppDatatitoli() == null || theModel.getAppDatatitoli().isEmpty()) {
			theModel.setAppDatatitoli((ArrayList<Titolo>) getSoaIntegrationMgr().getElencoTitoli());
		}
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
