

/**
 * Arricchimenti standard per il ContentPanel [cpHomeHome] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpHomeHome() {
	var contentPanelName = "cpHomeHome";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpHomeHome(){
/*PROTECTED REGION ID(R1993852493) ENABLED START*/
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

function initUIStructCpHomeHome(){
	var contentPanelName = "cpHomeHome";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pHome", panels: [
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

	initStdEnrichments4CpHomeHome();
	initCustomEnrichments4CpHomeHome();
	initUIStructCpHomeHome();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpHomeHome");

});



