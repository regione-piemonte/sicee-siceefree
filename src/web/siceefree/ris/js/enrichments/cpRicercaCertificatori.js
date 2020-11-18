

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaCertificatori] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaCertificatori() {
	var contentPanelName = "cpRicercaCertificatori";
	/// arricchimento per guigen::ComboBox [cbTitolo]: autonarrowing
	var addNarrowingToCbTitolo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTitolo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addNarrowingToCbTitolo);


	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addBasicEnrichmentToTfNome);
	/// arricchimento di base per guigen::TextField [tfCognome]
	var addBasicEnrichmentToTfCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addBasicEnrichmentToTfCognome);
	/// arricchimento di base per guigen::TextField [tfRagioneSociale]
	var addBasicEnrichmentToTfRagioneSociale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRagioneSociale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addBasicEnrichmentToTfRagioneSociale);
	/// arricchimento per guigen::ComboBox [cbRegione]: autonarrowing
	var addNarrowingToCbRegione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRegione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addNarrowingToCbRegione);


	/// arricchimento per guigen::ComboBox [cbProvincia]: autonarrowing
	var addNarrowingToCbProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addNarrowingToCbProvincia);


	/// arricchimento per guigen::ComboBox [cbComune]: autonarrowing
	var addNarrowingToCbComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_pRicercaCertificatore", addNarrowingToCbComune);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaCertificatori(){
/*PROTECTED REGION ID(R-510763600) ENABLED START*/
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

function initUIStructCpRicercaCertificatori(){
	var contentPanelName = "cpRicercaCertificatori";
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
            name: "p_pRicercaCertificatore", panels: []
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

	initStdEnrichments4CpRicercaCertificatori();
	initCustomEnrichments4CpRicercaCertificatori();
	initUIStructCpRicercaCertificatori();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaCertificatori");

});



