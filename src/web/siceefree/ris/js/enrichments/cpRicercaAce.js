

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAce() {
	var contentPanelName = "cpRicercaAce";
	/// arricchimento di base per guigen::TextField [tfAnno]
	var addBasicEnrichmentToTfAnno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAce", addBasicEnrichmentToTfAnno);
	/// arricchimento di base per guigen::TextField [tfCerticatore]
	var addBasicEnrichmentToTfCerticatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCerticatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAce", addBasicEnrichmentToTfCerticatore);
	/// arricchimento di base per guigen::TextField [tfNumero]
	var addBasicEnrichmentToTfNumero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAce", addBasicEnrichmentToTfNumero);



	/// arricchimento di base per guigen::TextField [tfComRicercaAce]
	var addBasicEnrichmentToTfComRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfComRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfComRicercaAce);
	/// arricchimento di base per guigen::TextField [tfIndirizzoRicercaAce]
	var addBasicEnrichmentToTfIndirizzoRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfIndirizzoRicercaAce);
	/// arricchimento di base per guigen::TextField [tfNCivRicercaAce]
	var addBasicEnrichmentToTfNCivRicercaAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNCivRicercaAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfNCivRicercaAce);
	/// arricchimento di base per guigen::TextField [tfSezCatasto]
	var addBasicEnrichmentToTfSezCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfSezCatasto);
	/// arricchimento di base per guigen::TextField [tfFoglioCatasto]
	var addBasicEnrichmentToTfFoglioCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglioCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfFoglioCatasto);
	/// arricchimento di base per guigen::TextField [tfParticCatasto]
	var addBasicEnrichmentToTfParticCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfParticCatasto);
	/// arricchimento di base per guigen::TextField [tfSubaltCatasto]
	var addBasicEnrichmentToTfSubaltCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubaltCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaAceFiltro", addBasicEnrichmentToTfSubaltCatasto);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAce(){
/*PROTECTED REGION ID(R1885815131) ENABLED START*/
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

function initUIStructCpRicercaAce(){
	var contentPanelName = "cpRicercaAce";
	var structure =
      {
        name: "p_pMain", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_pErrorRicercaAce", panels: [
            ]
          }
,          {
            name: "p_pRicercaAce", panels: []
          }
,          {
            name: "p_pNote", panels: []
          }
,          {
            name: "p_pRicercaAceNav", panels: []
          }
,          {
            name: "p_pRicercaAceFiltro", panels: []
          }
,          {
            name: "p_pRicercaAceByFiltroNav", panels: []
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

	initStdEnrichments4CpRicercaAce();
	initCustomEnrichments4CpRicercaAce();
	initUIStructCpRicercaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAce");

});



