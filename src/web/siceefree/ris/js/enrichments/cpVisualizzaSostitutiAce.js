

/**
 * Arricchimenti standard per il ContentPanel [cpVisualizzaSostitutiAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVisualizzaSostitutiAce() {
	var contentPanelName = "cpVisualizzaSostitutiAce";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVisualizzaSostitutiAce(){
/*PROTECTED REGION ID(R-1240611832) ENABLED START*/
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

function initUIStructCpVisualizzaSostitutiAce(){
	var contentPanelName = "cpVisualizzaSostitutiAce";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_wpAceSostituito", panels: []
          }
,          {
            name: "p_pRisultatoSostituzioni", panels: []
          }
,          {
            name: "p_cpSostituzioniNav", panels: []
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

	initStdEnrichments4CpVisualizzaSostitutiAce();
	initCustomEnrichments4CpVisualizzaSostitutiAce();
	initUIStructCpVisualizzaSostitutiAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVisualizzaSostitutiAce");

});



