

/**
 * Arricchimenti standard per il ContentPanel [cpDettWMS] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettWMS() {
	var contentPanelName = "cpDettWMS";
	/// arricchimento di base per guigen::TextField [tfCertificato]
	var addBasicEnrichmentToTfCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfCertificato);
	/// arricchimento di base per guigen::TextField [tfUbicazione]
	var addBasicEnrichmentToTfUbicazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfUbicazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfUbicazione);
	/// arricchimento di base per guigen::TextField [tfScadenza]
	var addBasicEnrichmentToTfScadenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScadenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfScadenza);
	/// arricchimento di base per guigen::TextField [tfDestinazioneDuso]
	var addBasicEnrichmentToTfDestinazioneDuso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDestinazioneDuso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfDestinazioneDuso);
	/// arricchimento di base per guigen::TextField [tfAnnoCostruzione]
	var addBasicEnrichmentToTfAnnoCostruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCostruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfAnnoCostruzione);
	/// arricchimento di base per guigen::TextField [tfAnnoUltRist]
	var addBasicEnrichmentToTfAnnoUltRist =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoUltRist',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfAnnoUltRist);
	/// arricchimento di base per guigen::TextField [tfVolLordorisc]
	var addBasicEnrichmentToTfVolLordorisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordorisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfVolLordorisc);
	/// arricchimento di base per guigen::TextField [tfVolLordoRinf]
	var addBasicEnrichmentToTfVolLordoRinf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordoRinf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfVolLordoRinf);
	/// arricchimento di base per guigen::TextField [tfMotivoRilascio]
	var addBasicEnrichmentToTfMotivoRilascio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMotivoRilascio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfMotivoRilascio);
	/// arricchimento di base per guigen::TextField [tfClasseEnergetica]
	var addBasicEnrichmentToTfClasseEnergetica =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfClasseEnergetica',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS2", addBasicEnrichmentToTfClasseEnergetica);
	/// arricchimento di base per guigen::TextField [tfRifCatastali]
	var addBasicEnrichmentToTfRifCatastali =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRifCatastali',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRifCatastali", addBasicEnrichmentToTfRifCatastali);
	/// arricchimento di base per guigen::TextField [tfFoglio]
	var addBasicEnrichmentToTfFoglio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRifCatastali", addBasicEnrichmentToTfFoglio);
	/// arricchimento di base per guigen::TextField [tfsezione]
	var addBasicEnrichmentToTfsezione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfsezione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRifCatastali", addBasicEnrichmentToTfsezione);
	/// arricchimento di base per guigen::TextField [tfParticella]
	var addBasicEnrichmentToTfParticella =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticella',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRifCatastali", addBasicEnrichmentToTfParticella);
	/// arricchimento di base per guigen::TextField [tfSub]
	var addBasicEnrichmentToTfSub =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSub',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRifCatastali", addBasicEnrichmentToTfSub);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettWMS(){
/*PROTECTED REGION ID(R-2113468399) ENABLED START*/
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

function initUIStructCpDettWMS(){
	var contentPanelName = "cpDettWMS";
	var structure =
      {
        name: "p_pDettWMS", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_multiDataPanel", panels: [
            {
              name: "p_fpDati", panels: [
              {
                name: "p_wDettWMS", panels: []
              }
,              {
                name: "p_wDettWMS2", panels: []
              }
,              {
                name: "p_wRifCatastali", panels: []
              }
,              {
                name: "p_pDettaglioFun", panels: []
              }
              ]
            }
,            {
              name: "p_fpMessaggio", panels: [
              {
                name: "p_msgBoxNoElement", panels: [
                ]
              }
              ]
            }
            ]
          }
          ]
        }
,        {
          name: "p_pUp", panels: [
          {
            name: "p_pUserInfoCustom", panels: [
            ]
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

	initStdEnrichments4CpDettWMS();
	initCustomEnrichments4CpDettWMS();
	initUIStructCpDettWMS();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettWMS");

});



