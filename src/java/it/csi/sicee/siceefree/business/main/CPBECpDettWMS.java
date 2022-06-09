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

/*PROTECTED REGION ID(R1731366140) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpDettWMS {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [listDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_LISTDETTAGLIOGEOGRAFICO_CODE = "appDatalistDettaglioGeografico";

	// ApplicationData: [currentDettaglioGeografico, scope:USER_SESSION]
	public static final String APPDATA_CURRENTDETTAGLIOGEOGRAFICO_CODE = "appDatacurrentDettaglioGeografico";

	// ApplicationData: [WMSClass, scope:USER_SESSION]
	public static final String APPDATA_WMSCLASS_CODE = "appDataWMSClass";

	// ApplicationData: [WMSCoordinates, scope:USER_SESSION]
	public static final String APPDATA_WMSCOORDINATES_CODE = "appDataWMSCoordinates";

	// ApplicationData: [paginaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_PAGINASELEZIONATA_CODE = "appDatapaginaSelezionata";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettWMS";

	public static final String MULTIPANEL_MULTIDATAPANEL = "multiDataPanel";
	public static final String MPI_MULTIDATAPANEL_FPDATI = CPNAME + "_" + MULTIPANEL_MULTIDATAPANEL + "_" + "fpDati";
	public static final String MPI_MULTIDATAPANEL_FPMESSAGGIO = CPNAME + "_" + MULTIPANEL_MULTIDATAPANEL + "_"
			+ "fpMessaggio";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciSuccessivo definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults gestisciSuccessivo(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String GESTISCISUCCESSIVO_OUTCOME_CODE__OK_ULTIMO = //NOSONAR  Reason:EIAS
				"OK_ULTIMO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1586539409) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			ArrayList<DettaglioGeograficoPortale> list = theModel.getAppDatalistDettaglioGeografico();
			Integer paginaSelez = theModel.getAppDatapaginaSelezionata();
			paginaSelez++;
			if ((list.size() - 1) == paginaSelez) {
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__OK_ULTIMO);
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
			} else if (list.size() - 1 < paginaSelez) {
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__KO);
			} else {
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
				result.setResultCode(GESTISCISUCCESSIVO_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciSuccessivo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciPrecedente definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults gestisciPrecedente(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String GESTISCIPRECEDENTE_OUTCOME_CODE__OK_PRIMO = //NOSONAR  Reason:EIAS
				"OK_PRIMO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1461166665) ENABLED START*/
			ArrayList<DettaglioGeograficoPortale> list = theModel.getAppDatalistDettaglioGeografico();
			Integer paginaSelez = theModel.getAppDatapaginaSelezionata();
			paginaSelez--;
			log.info(paginaSelez);
			log.info(list.size());
			log.info(paginaSelez == 0);
			if (paginaSelez == 0) {
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__OK_PRIMO);
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
			} else if (paginaSelez < 0) {
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__KO);
			} else {
				theModel.setAppDatacurrentDettaglioGeografico(list.get(paginaSelez));
				theModel.setAppDatapaginaSelezionata(paginaSelez);
				result.setResultCode(GESTISCIPRECEDENTE_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciPrecedente] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo clearFields definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults clearFields(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CLEARFIELDS_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2083137581) ENABLED START*/
			DettaglioGeograficoPortale dto = new DettaglioGeograficoPortale();
			dto.setCertificato(null);
			dto.setUbicazione(null);
			dto.setRifCatasto(null);
			dto.setFoglio(null);
			dto.setParticella(null);
			dto.setSezione(null);
			dto.setSub(null);
			dto.setDtScadenza(null);
			dto.setDestinazioneUso(null);
			dto.setAnnoCostruzione(null);
			dto.setAnnoUltRist(null);
			dto.setVolLordoRiscaldato(null);
			dto.setVolLordoRaffrescato(null);
			dto.setMotivazioneRilascio(null);
			dto.setClasseEnergetica(null);
			theModel.setAppDatalistDettaglioGeografico(null);
			theModel.setAppDatacurrentDettaglioGeografico(dto);
			result.setResultCode(CLEARFIELDS_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::clearFields] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaInterrogazioneGeoportale definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults visualizzaInterrogazioneGeoportale(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-36544421) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String[] coordinates = theModel.getAppDataWMSCoordinates().split(";");
			// impostazione del result code
			if (theModel.getAppDataWMSClass() != null) {
				it.csi.sicee.siceeorch.dto.siceeorch.DettaglioGeografico[] dettagli = soaIntegrationMgr
						.getDettaglioGeoportale(coordinates[0], coordinates[1], theModel.getAppDataWMSClass());
				if (dettagli != null && dettagli.length != 0) {
					log.debug("dettagli: " + Arrays.toString(dettagli));

					ArrayList<DettaglioGeograficoPortale> dettaglioGeograficoPortaleArrayList = new ArrayList<>();
					dettaglioGeograficoPortaleArrayList = mapDettaglioGeografico(dettagli);

					theModel.setAppDatalistDettaglioGeografico(dettaglioGeograficoPortaleArrayList);
					theModel.setAppDatacurrentDettaglioGeografico(dettaglioGeograficoPortaleArrayList.get(0));
					theModel.setAppDatapaginaSelezionata(0);
					if (dettagli.length == 1) {
						log.debug("-----------OK SINGOLO-------------");
						result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO);
					} else {
						log.debug("-----------OK-------------");
						result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK);
					}
				} else {
					log.debug("-----------KO-------------");
					result.getGlobalMessages().add("Nessun elemento trovato");
					result.setResultCode(VISUALIZZAINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO);
				}

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaInterrogazioneGeoportale] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkAppdata definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults checkAppdata(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKAPPDATA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CHECKAPPDATA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2013256316) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDatalistDettaglioGeografico() != null)
				result.setResultCode(CHECKAPPDATA_OUTCOME_CODE__OK);
			else
				result.setResultCode(CHECKAPPDATA_OUTCOME_CODE__KO);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkAppdata] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo refreshInterrogazioneGeoportale definito in un ExecCommand del
	 * ContentPanel cpDettWMS
	 */
	public ExecResults refreshInterrogazioneGeoportale(

			it.csi.sicee.siceefree.dto.main.CpDettWMSModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO = //NOSONAR  Reason:EIAS
				"OK_SINGOLO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1638875342) ENABLED START*/
			String[] coordinates = theModel.getAppDataWMSCoordinates().split(";");
			// impostazione del result code
			if (theModel.getAppDataWMSClass() != null) {
				it.csi.sicee.siceeorch.dto.siceeorch.DettaglioGeografico[] dettagli = soaIntegrationMgr
						.getDettaglioGeoportale(coordinates[0], coordinates[1], theModel.getAppDataWMSClass());
				if (dettagli != null && dettagli.length != 0) {
					log.debug("dettagli: " + Arrays.toString(dettagli));

					ArrayList<DettaglioGeograficoPortale> dettaglioGeograficoPortaleArrayList = new ArrayList<>();
					dettaglioGeograficoPortaleArrayList = mapDettaglioGeografico(dettagli);

					theModel.setAppDatalistDettaglioGeografico(dettaglioGeograficoPortaleArrayList);
					theModel.setAppDatacurrentDettaglioGeografico(dettaglioGeograficoPortaleArrayList.get(0));
					theModel.setAppDatapaginaSelezionata(0);
					if (dettagli.length == 1) {
						log.debug("-----------refresh OK SINGOLO-------------");
						result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK_SINGOLO);
					} else {
						log.debug("-----------refresh OK-------------");
						result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__OK);
					}
				} else {
					log.debug("-----------refresh KO-------------");
					result.getGlobalMessages().add("Nessun elemento trovato");
					result.setResultCode(REFRESHINTERROGAZIONEGEOPORTALE_OUTCOME_CODE__KO);
				}

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::refreshInterrogazioneGeoportale] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1820169074) ENABLED START*/
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private ArrayList<DettaglioGeograficoPortale> mapDettaglioGeografico(it.csi.sicee.siceeorch.dto.siceeorch.DettaglioGeografico[] dettagli) {
		ArrayList<DettaglioGeograficoPortale> dettaglioGeograficoArrayList = new ArrayList<>();
		for (it.csi.sicee.siceeorch.dto.siceeorch.DettaglioGeografico elem : dettagli) {
			DettaglioGeograficoPortale dto = new DettaglioGeograficoPortale();
			String certificato =
					(elem.getAnno() != null ? elem.getAnno() : "") + " " + (elem.getNumCertificatore() != null ? elem.getNumCertificatore() : "") + " " + (elem.getProgrCertificato() != null ?
							elem.getProgrCertificato() : "");

			String ubicazione =
					(elem.getIndirizzo() != null ? elem.getIndirizzo() : "") + " " + (elem.getCivico() != null ? elem.getCivico() : "") + ", " + (elem.getDescComune() != null ? elem.getDescComune() :
							"") + " (" + (elem.getDescProvincia() != null ? elem.getDescProvincia() : "") + "), " + (elem.getPiano() != null ? "Piano " + elem.getPiano() : "");

			String destUso = (elem.getDestinazioneUso() != null ? elem.getDestinazioneUso() : "") + " - " + (elem.getDescrDestinazioneUso() != null ? elem.getDescrDestinazioneUso() : "");

			dto.setCertificato(certificato);
			dto.setUbicazione(ubicazione);
			dto.setRifCatasto(elem.getRifCatasto());
			dto.setFoglio(elem.getFoglio());
			dto.setParticella(elem.getParticella());
			dto.setSezione(elem.getSezione());
			dto.setSub(elem.getSub());
			dto.setDtScadenza(elem.getDtScadenza());
			dto.setDestinazioneUso(destUso);
			dto.setAnnoCostruzione(elem.getAnnoCostruzione());
			dto.setAnnoUltRist(elem.getAnnoUltRist());
			dto.setVolLordoRiscaldato(elem.getVolLordoRiscaldato());
			dto.setVolLordoRaffrescato(elem.getVolLordoRaffrescato());
			dto.setMotivazioneRilascio(elem.getMotivazioneRilascio());
			dto.setClasseEnergetica(elem.getClasseEnergetica());
			dettaglioGeograficoArrayList.add(dto);
		}
		return dettaglioGeograficoArrayList;
	}
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
