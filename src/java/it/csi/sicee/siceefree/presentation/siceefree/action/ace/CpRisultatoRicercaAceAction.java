package it.csi.sicee.siceefree.presentation.siceefree.action.ace;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sicee.siceefree.util.*;
import it.csi.sicee.siceefree.dto.*;
import it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel;

import it.csi.sicee.siceefree.presentation.siceefree.command.*;

import it.csi.sicee.siceefree.presentation.siceefree.security.*;

import it.csi.sicee.siceefree.business.*;

import it.csi.sicee.siceefree.presentation.siceefree.action.*;

import it.csi.sicee.siceefree.presentation.siceefree.action.ace.states.CpRisultatoRicercaAceScreenStates;

import it.csi.sicee.siceefree.presentation.siceefree.interceptor.MethodProtection;

import it.csi.sicee.siceefree.presentation.siceefree.interceptor.FatClientOnly;
import it.csi.sicee.siceefree.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRisultatoRicercaAceAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRisultatoRicercaAceAction extends AbstractCPAction<CpRisultatoRicercaAceModel>
		implements
			Preparable,
			ModelDriven<CpRisultatoRicercaAceModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRisultatoRicercaAceModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRisultatoRicercaAceModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRisultatoRicercaAceModel modello) {
		this.model = modello;
	}

	/**
	 * Il metodo setSession() viene ridefinito in modo che venga asosciato all'oggetto
	 * model.
	 * N.B: il model deve essere creato in precedenza, altrimenti l'impostazione non 
	 * e' possibile. 
	 * Per questo motivo esso viene creato in questo (se non gia' esistente).
	 */
	@Override
	public void setSession(Map session) {
		// implementazione standard di SessionAware
		super.setSession(session);
		// creo una nuova istanza di modello, se gia' non esiste 
		if (model == null) {
			model = new CpRisultatoRicercaAceModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRisultatoRicercaAce";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "ace";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/ace";

	/**
	 * restituisce il nome del content panel
	 */
	public String getCPName() {
		return CP_NAME;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel
	 */
	public String getCPNamespace() {
		return CP_NAMESPACE;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel, comprensivo di prefisso "base"/"secure"
	 */
	public String getCPFullNamespace() {
		return CP_FULL_NAMESPACE;
	}

	private static final String URL_BACK_COMMAND = "/base/ace/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceefree.dto.ace.CpRisultatoRicercaAceModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH //NOSONAR
				.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return true;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento CLICKED sul widget [bStampaReport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBStampaReport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ace", "cprisultatoricercaace", "bStampaReport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnInvioAce]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnInvioAce_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ace", "cprisultatoricercaace", "btnInvioAce", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnStampaCopia]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnStampaCopia_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ace", "cprisultatoricercaace", "btnStampaCopia", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ace", "cprisultatoricercaace", "btnNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSostituzioni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSostituzioni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ace", "cprisultatoricercaace", "btnSostituzioni", "CLICKED");

	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodo di data providing sull'intero ContentPanel
	/// metodo: provide_CPDATA
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/// metodi di data providing sui widget dotati di multi data binding
	/// contenuti nel contentPanel
	/// metodo: provide<nomeWidget>_<tipologia dati>
	/// es: provideCbComuni_DATASET
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblRisultatoAce.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblRisultatoAce_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacertificati", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1442610171) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 * Metodo di preparazione della schermata/action
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();

	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// nothing to clear...
	}

	@SkipValidation
	public String handleChangeTab() {
		if (this.hasActionErrors() || this.hasFieldErrors() || this.hasErrors())
			return INPUT;
		else {
			session.put(getModel().getSelectedTabKey(), getModel().getSelectedTabValue());
			return SUCCESS;
		}
	}

}
