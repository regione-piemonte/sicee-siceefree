package it.csi.sicee.siceefree.business;

import java.util.*;

import it.csi.sicee.siceefree.dto.*;

import org.apache.log4j.*;
import it.csi.sicee.siceefree.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import it.csi.sicee.siceefree.business.facade.ActivationMgr;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [idDocumento, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTO_CODE = "appDataidDocumento";

	// ApplicationData: [filtroAce, scope:USER_SESSION]
	public static final String APPDATA_FILTROACE_CODE = "appDatafiltroAce";

	// ApplicationData: [certificati, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATI_CODE = "appDatacertificati";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [certificatiSostitutivi, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATISOSTITUTIVI_CODE = "appDatacertificatiSostitutivi";

	// ApplicationData: [filtroCertificatore, scope:USER_SESSION]
	public static final String APPDATA_FILTROCERTIFICATORE_CODE = "appDatafiltroCertificatore";

	// ApplicationData: [certificatori, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORI_CODE = "appDatacertificatori";

	// ApplicationData: [idCertificatore, scope:USER_SESSION]
	public static final String APPDATA_IDCERTIFICATORE_CODE = "appDataidCertificatore";

	// ApplicationData: [certificatore, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORE_CODE = "appDatacertificatore";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [regioni, scope:USER_SESSION]
	public static final String APPDATA_REGIONI_CODE = "appDataregioni";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	// ApplicationData: [notaio, scope:USER_SESSION]
	public static final String APPDATA_NOTAIO_CODE = "appDatanotaio";

	// ApplicationData: [checkNotaio, scope:USER_SESSION]
	public static final String APPDATA_CHECKNOTAIO_CODE = "appDatacheckNotaio";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAce utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAce(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().ricercaAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAceByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().ricercaAceByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciCombo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().gestisciCombo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo precaricaFiltroRicercaACE utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults precaricaFiltroRicercaACE(

			it.csi.sicee.siceefree.dto.ace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().precaricaFiltroRicercaACE(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().stampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invioAce utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults invioAce(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().invioAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaCopia utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults stampaCopia(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().stampaCopia(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciSostituzioni utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults gestisciSostituzioni(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().gestisciSostituzioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaPulsanteInvioAce utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteInvioAce(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().abilitaPulsanteInvioAce(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaPulsanteSostituzioni utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteSostituzioni(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().abilitaPulsanteSostituzioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaPulsanteStampaCopia utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteStampaCopia(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().abilitaPulsanteStampaCopia(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaPulsanteStampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaAce
	 */
	public ExecResults abilitaPulsanteStampaReport(

			it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaAce
		return getCPBECpRisultatoRicercaAce().abilitaPulsanteStampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaDettaglioAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceefree.dto.ace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioAttestato
		return getCPBECpDettaglioAttestato().visualizzaDettaglioAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneRicercaCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setRegioneRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().setRegioneRicercaCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaRicercaCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setProvinciaRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().setProvinciaRicercaCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComuneRicercaCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setComuneRicercaCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().setComuneRicercaCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaCertificatori utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults ricercaCertificatori(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().ricercaCertificatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceefree.dto.certificatore.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaDettaglioCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaCertificatori
	 */
	public ExecResults ricercaDettaglioCertificatore(

			it.csi.sicee.siceefree.dto.certificatore.CpRisultatoRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaCertificatori
		return getCPBECpRisultatoRicercaCertificatori().ricercaDettaglioCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaPulsanteDettaglio utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoRicercaCertificatori
	 */
	public ExecResults abilitaPulsanteDettaglio(

			it.csi.sicee.siceefree.dto.certificatore.CpRisultatoRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoRicercaCertificatori
		return getCPBECpRisultatoRicercaCertificatori().abilitaPulsanteDettaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaModulo utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaModulo(

			it.csi.sicee.siceefree.dto.certificatore.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().scaricaModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo selezionaCittadino utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults selezionaCittadino(

			it.csi.sicee.siceefree.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().selezionaCittadino(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo selezionaNotaio utilizzato in un ExecCommand
	 * del ContentPanel cpHome
	 */
	public ExecResults selezionaNotaio(

			it.csi.sicee.siceefree.dto.main.CpHomeModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpHome
		return getCPBECpHome().selezionaNotaio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaEmailNotaio utilizzato in un ExecCommand
	 * del ContentPanel cpVerificaEmailNotai
	 */
	public ExecResults verificaEmailNotaio(

			it.csi.sicee.siceefree.dto.main.CpVerificaEmailNotaiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificaEmailNotai
		return getCPBECpVerificaEmailNotai().verificaEmailNotaio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaLogAccesso utilizzato in un ExecCommand
	 * del ContentPanel cpVerificaEmailNotai
	 */
	public ExecResults salvaLogAccesso(

			it.csi.sicee.siceefree.dto.main.CpVerificaEmailNotaiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificaEmailNotai
		return getCPBECpVerificaEmailNotai().salvaLogAccesso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setErrorMessage utilizzato in un ExecCommand
	 * del ContentPanel cpErrorPage
	 */
	public ExecResults setErrorMessage(

			it.csi.sicee.siceefree.dto.main.CpErrorPageModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpErrorPage
		return getCPBECpErrorPage().setErrorMessage(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaRicercaAce definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults verificaRicercaAce(

			it.csi.sicee.siceefree.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICARICERCAACE_OUTCOME_CODE__OKVERIFIED = //NOSONAR  Reason:EIAS
				"OKVERIFIED"; //NOSONAR  Reason:EIAS
		final String VERIFICARICERCAACE_OUTCOME_CODE__OKNOTVERIFIED = //NOSONAR  Reason:EIAS
				"OKNOTVERIFIED"; //NOSONAR  Reason:EIAS
		final String VERIFICARICERCAACE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1492488681) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Check Notaio: " + theModel.getAppDatacheckNotaio());
			if (theModel.getAppDatacheckNotaio() != null && theModel.getAppDatacheckNotaio()) {
				if (theModel.getAppDatanotaio() != null) {
					result.setResultCode(VERIFICARICERCAACE_OUTCOME_CODE__OKVERIFIED);
				} else {
					result.setResultCode(VERIFICARICERCAACE_OUTCOME_CODE__OKNOTVERIFIED);
				}
			} else {
				//result.setResultCode(VERIFICANOTAIORICERCAACE_OUTCOME_CODE__KO);
				result.setResultCode(VERIFICARICERCAACE_OUTCOME_CODE__OKVERIFIED);

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaRicercaAce] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkEnabled definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults checkEnabled(

			it.csi.sicee.siceefree.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKENABLED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CHECKENABLED_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1679769053) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			if (getActivationMgr().isServiceEnabled()) {
				result.setResultCode(CHECKENABLED_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(CHECKENABLED_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkEnabled] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	private it.csi.sicee.siceefree.business.ace.CPBECpRicercaAce cPBECpRicercaAce = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	public void setCPBECpRicercaAce(it.csi.sicee.siceefree.business.ace.CPBECpRicercaAce bean) {
		this.cPBECpRicercaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	public it.csi.sicee.siceefree.business.ace.CPBECpRicercaAce getCPBECpRicercaAce() {
		return this.cPBECpRicercaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	private it.csi.sicee.siceefree.business.ace.CPBECpRisultatoRicercaAce cPBECpRisultatoRicercaAce = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	public void setCPBECpRisultatoRicercaAce(it.csi.sicee.siceefree.business.ace.CPBECpRisultatoRicercaAce bean) {
		this.cPBECpRisultatoRicercaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaAce
	 */
	public it.csi.sicee.siceefree.business.ace.CPBECpRisultatoRicercaAce getCPBECpRisultatoRicercaAce() {
		return this.cPBECpRisultatoRicercaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpVisualizzaSostitutiAce
	 */
	private it.csi.sicee.siceefree.business.ace.CPBECpVisualizzaSostitutiAce cPBECpVisualizzaSostitutiAce = null;

	/**
	 * riferimento al CPBE del content panel cpVisualizzaSostitutiAce
	 */
	public void setCPBECpVisualizzaSostitutiAce(it.csi.sicee.siceefree.business.ace.CPBECpVisualizzaSostitutiAce bean) {
		this.cPBECpVisualizzaSostitutiAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVisualizzaSostitutiAce
	 */
	public it.csi.sicee.siceefree.business.ace.CPBECpVisualizzaSostitutiAce getCPBECpVisualizzaSostitutiAce() {
		return this.cPBECpVisualizzaSostitutiAce;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	private it.csi.sicee.siceefree.business.ace.CPBECpDettaglioAttestato cPBECpDettaglioAttestato = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public void setCPBECpDettaglioAttestato(it.csi.sicee.siceefree.business.ace.CPBECpDettaglioAttestato bean) {
		this.cPBECpDettaglioAttestato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public it.csi.sicee.siceefree.business.ace.CPBECpDettaglioAttestato getCPBECpDettaglioAttestato() {
		return this.cPBECpDettaglioAttestato;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	private it.csi.sicee.siceefree.business.certificatore.CPBECpRicercaCertificatori cPBECpRicercaCertificatori = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	public void setCPBECpRicercaCertificatori(
			it.csi.sicee.siceefree.business.certificatore.CPBECpRicercaCertificatori bean) {
		this.cPBECpRicercaCertificatori = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	public it.csi.sicee.siceefree.business.certificatore.CPBECpRicercaCertificatori getCPBECpRicercaCertificatori() {
		return this.cPBECpRicercaCertificatori;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaCertificatori
	 */
	private it.csi.sicee.siceefree.business.certificatore.CPBECpRisultatoRicercaCertificatori cPBECpRisultatoRicercaCertificatori = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaCertificatori
	 */
	public void setCPBECpRisultatoRicercaCertificatori(
			it.csi.sicee.siceefree.business.certificatore.CPBECpRisultatoRicercaCertificatori bean) {
		this.cPBECpRisultatoRicercaCertificatori = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoRicercaCertificatori
	 */
	public it.csi.sicee.siceefree.business.certificatore.CPBECpRisultatoRicercaCertificatori getCPBECpRisultatoRicercaCertificatori() {
		return this.cPBECpRisultatoRicercaCertificatori;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	private it.csi.sicee.siceefree.business.certificatore.CPBECpDettaglioCertificatore cPBECpDettaglioCertificatore = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	public void setCPBECpDettaglioCertificatore(
			it.csi.sicee.siceefree.business.certificatore.CPBECpDettaglioCertificatore bean) {
		this.cPBECpDettaglioCertificatore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	public it.csi.sicee.siceefree.business.certificatore.CPBECpDettaglioCertificatore getCPBECpDettaglioCertificatore() {
		return this.cPBECpDettaglioCertificatore;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.sicee.siceefree.business.main.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.sicee.siceefree.business.main.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.sicee.siceefree.business.main.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpHomeHome
	 */
	private it.csi.sicee.siceefree.business.main.CPBECpHomeHome cPBECpHomeHome = null;

	/**
	 * riferimento al CPBE del content panel cpHomeHome
	 */
	public void setCPBECpHomeHome(it.csi.sicee.siceefree.business.main.CPBECpHomeHome bean) {
		this.cPBECpHomeHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHomeHome
	 */
	public it.csi.sicee.siceefree.business.main.CPBECpHomeHome getCPBECpHomeHome() {
		return this.cPBECpHomeHome;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificaEmailNotai
	 */
	private it.csi.sicee.siceefree.business.main.CPBECpVerificaEmailNotai cPBECpVerificaEmailNotai = null;

	/**
	 * riferimento al CPBE del content panel cpVerificaEmailNotai
	 */
	public void setCPBECpVerificaEmailNotai(it.csi.sicee.siceefree.business.main.CPBECpVerificaEmailNotai bean) {
		this.cPBECpVerificaEmailNotai = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificaEmailNotai
	 */
	public it.csi.sicee.siceefree.business.main.CPBECpVerificaEmailNotai getCPBECpVerificaEmailNotai() {
		return this.cPBECpVerificaEmailNotai;
	}

	/**
	 * riferimento al CPBE del content panel cpErrorPage
	 */
	private it.csi.sicee.siceefree.business.main.CPBECpErrorPage cPBECpErrorPage = null;

	/**
	 * riferimento al CPBE del content panel cpErrorPage
	 */
	public void setCPBECpErrorPage(it.csi.sicee.siceefree.business.main.CPBECpErrorPage bean) {
		this.cPBECpErrorPage = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpErrorPage
	 */
	public it.csi.sicee.siceefree.business.main.CPBECpErrorPage getCPBECpErrorPage() {
		return this.cPBECpErrorPage;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	private it.csi.sicee.siceefree.business.main.CPBECpDisabled cPBECpDisabled = null;

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public void setCPBECpDisabled(it.csi.sicee.siceefree.business.main.CPBECpDisabled bean) {
		this.cPBECpDisabled = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public it.csi.sicee.siceefree.business.main.CPBECpDisabled getCPBECpDisabled() {
		return this.cPBECpDisabled;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private ActivationMgr activationMgr = null;

	public ActivationMgr getActivationMgr() {
		return activationMgr;
	}

	public void setActivationMgr(ActivationMgr activationMgr) {
		this.activationMgr = activationMgr;
	}

	/*PROTECTED REGION END*/
}
