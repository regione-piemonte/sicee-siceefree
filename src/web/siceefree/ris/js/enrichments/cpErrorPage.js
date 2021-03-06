

/**
 * Arricchimenti standard per il ContentPanel [cpErrorPage] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpErrorPage() {
	var contentPanelName = "cpErrorPage";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpErrorPage(){
/*PROTECTED REGION ID(R-1216182932) ENABLED START*/
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

function initUIStructCpErrorPage(){
	var contentPanelName = "cpErrorPage";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pError", panels: [
            ]
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

	initStdEnrichments4CpErrorPage();
	initCustomEnrichments4CpErrorPage();
	initUIStructCpErrorPage();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpErrorPage");

});



