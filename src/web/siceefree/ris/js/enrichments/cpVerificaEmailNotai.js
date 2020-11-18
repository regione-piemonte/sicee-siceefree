

/**
 * Arricchimenti standard per il ContentPanel [cpVerificaEmailNotai] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVerificaEmailNotai() {
	var contentPanelName = "cpVerificaEmailNotai";
	/// arricchimento di base per guigen::TextField [tfEmailNotaio]
	var addBasicEnrichmentToTfEmailNotaio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailNotaio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pVerificaEmail", addBasicEnrichmentToTfEmailNotaio);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVerificaEmailNotai(){
/*PROTECTED REGION ID(R-1929964651) ENABLED START*/
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

function initUIStructCpVerificaEmailNotai(){
	var contentPanelName = "cpVerificaEmailNotai";
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
            name: "p_pVerificaEmail", panels: []
          }
,          {
            name: "p_cmdVerificaEmail", panels: []
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

	initStdEnrichments4CpVerificaEmailNotai();
	initCustomEnrichments4CpVerificaEmailNotai();
	initUIStructCpVerificaEmailNotai();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVerificaEmailNotai");

});



