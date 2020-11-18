

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoRicercaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoRicercaAce() {
	var contentPanelName = "cpRisultatoRicercaAce";
	/// arricchimento di base per guigen::TextField [tfEmail]
	var addBasicEnrichmentToTfEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRisultatoRicercaAce", addBasicEnrichmentToTfEmail);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoRicercaAce(){
/*PROTECTED REGION ID(R2008656988) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/	
/*PROTECTED REGION END*/
}

function initUIStructCpRisultatoRicercaAce(){
	var contentPanelName = "cpRisultatoRicercaAce";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrorRisultatoAce", panels: [
            ]
          }
,          {
            name: "p_pRisultatoRicercaAce", panels: []
          }
,          {
            name: "p_pRisultatoRicercaAceTabella", panels: []
          }
,          {
            name: "p_pInvioAce", panels: []
          }
,          {
            name: "p_pRisultatoAceNav", panels: []
          }
          ]
        }
,        {
          name: "p_pLeft", panels: [
          {
            name: "p_pMenu", panels: []
          }
          ]
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpRisultatoRicercaAce();
	initCustomEnrichments4CpRisultatoRicercaAce();
	initUIStructCpRisultatoRicercaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoRicercaAce");

});



