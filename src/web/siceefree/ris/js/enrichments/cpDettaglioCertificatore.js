

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioCertificatore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioCertificatore() {
	var contentPanelName = "cpDettaglioCertificatore";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioCertificatore(){
/*PROTECTED REGION ID(R2126882616) ENABLED START*/
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

function initUIStructCpDettaglioCertificatore(){
	var contentPanelName = "cpDettaglioCertificatore";
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
            name: "p_pDettaglioCertificatore", panels: []
          }
,          {
            name: "p_pScaricoDocumento", panels: []
          }
,          {
            name: "p_pRicercaCertificatoreNav", panels: []
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

	initStdEnrichments4CpDettaglioCertificatore();
	initCustomEnrichments4CpDettaglioCertificatore();
	initUIStructCpDettaglioCertificatore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioCertificatore");

});



