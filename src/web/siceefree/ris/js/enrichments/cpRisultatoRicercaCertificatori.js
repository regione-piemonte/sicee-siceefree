

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoRicercaCertificatori] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoRicercaCertificatori() {
	var contentPanelName = "cpRisultatoRicercaCertificatori";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoRicercaCertificatori(){
/*PROTECTED REGION ID(R-1778664591) ENABLED START*/
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

function initUIStructCpRisultatoRicercaCertificatori(){
	var contentPanelName = "cpRisultatoRicercaCertificatori";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pError", panels: [
            ]
          }
,          {
            name: "p_pRisultatoRicercaCertificatori", panels: []
          }
,          {
            name: "p_pRisultatoCertificatoreNav", panels: []
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

	initStdEnrichments4CpRisultatoRicercaCertificatori();
	initCustomEnrichments4CpRisultatoRicercaCertificatori();
	initUIStructCpRisultatoRicercaCertificatori();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoRicercaCertificatori");

});



