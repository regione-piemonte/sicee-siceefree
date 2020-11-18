<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/certificatore -->
<!-- pageId:cpRicercaCertificatori -->

<s:form id="cpRicercaCertificatori" action="cpRicercaCertificatori" namespace="/base/certificatore" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
		
			
<s:if test="isWidgetVisible('cpRicercaCertificatori','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRicercaCertificatori.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pError" class="stdMessagePanelBlock"><!-- startFragment:p_pError -->
	
	
<div class="stdMessagePanel" id="pError">
	<customtag:stdMessagePanel id="pError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pError --></div>

			
	
	<div id="p_pRicercaCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaCertificatore -->
	
	

<div class="widgetsPanel" id="pRicercaCertificatore">
	
	<customtag:widgetsPanel id="pRicercaCertificatoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbTitolo.label')}" labelFor="widg_cbTitolo" errorFor="appDatafiltroCertificatore.titolo" labelId="cbTitoloLbl"
	  >


<!-- widget cbTitolo -->
<s:select name="appDatafiltroCertificatore.titolo" id="widg_cbTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatitoli"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbTitolo')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDatafiltroCertificatore.nome" labelId="tfNomeLbl"
	  >


<!-- widget tfNome -->
<s:textfield 
	
	
	name="appDatafiltroCertificatore.nome" id="widg_tfNome"
	disabled="isWidgetDisabled('cpRicercaCertificatori','tfNome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfCognome.label')}" labelFor="widg_tfCognome" errorFor="appDatafiltroCertificatore.cognome" labelId="tfCognomeLbl"
	  >


<!-- widget tfCognome -->
<s:textfield 
	
	
	name="appDatafiltroCertificatore.cognome" id="widg_tfCognome"
	disabled="isWidgetDisabled('cpRicercaCertificatori','tfCognome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRagioneSociale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfRagioneSociale.label')}" labelFor="widg_tfRagioneSociale" errorFor="appDatafiltroCertificatore.ragioneSociale" labelId="tfRagioneSocialeLbl"
	  >


<!-- widget tfRagioneSociale -->
<s:textfield 
	
	
	name="appDatafiltroCertificatore.ragioneSociale" id="widg_tfRagioneSociale"
	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRagioneSociale')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbRegione.label')}" labelFor="widg_cbRegione" errorFor="appDatafiltroCertificatore.regione" labelId="cbRegioneLbl"
	  >


<!-- widget cbRegione -->
	<csiuicore:ajaxify id="p_pRicercaCertificatore" 
		widgetType="combo" 
		requestUri="/siceefree/base/certificatore/cpRicercaCertificatori!handleCbRegione_VALUE_CHANGED.do"
		pageId="cpRicercaCertificatori"
		formName="cpRicercaCertificatori"
		javascriptDetection="false"
		nameSpace="/base/certificatore">

<s:url id="widg_cbRegioneurlComboBoxValueChange"
   action="/siceefree/cpRicercaCertificatori!handleCbRegione_VALUE_CHANGED" namespace="/base/certificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroCertificatore.regione" id="widg_cbRegione"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregioni"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbRegione')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDatafiltroCertificatore.provincia" labelId="cbProvinciaLbl"
	  >


<!-- widget cbProvincia -->
	<csiuicore:ajaxify id="p_pRicercaCertificatore" 
		widgetType="combo" 
		requestUri="/siceefree/base/certificatore/cpRicercaCertificatori!handleCbProvincia_VALUE_CHANGED.do"
		pageId="cpRicercaCertificatori"
		formName="cpRicercaCertificatori"
		javascriptDetection="false"
		nameSpace="/base/certificatore">

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/siceefree/cpRicercaCertificatori!handleCbProvincia_VALUE_CHANGED" namespace="/base/certificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroCertificatore.provincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbProvincia')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDatafiltroCertificatore.comune" labelId="cbComuneLbl"
	  >


<!-- widget cbComune -->
	<csiuicore:ajaxify id="p_pRicercaCertificatore" 
		widgetType="combo" 
		requestUri="/siceefree/base/certificatore/cpRicercaCertificatori!handleCbComune_VALUE_CHANGED.do"
		pageId="cpRicercaCertificatori"
		formName="cpRicercaCertificatori"
		javascriptDetection="false"
		nameSpace="/base/certificatore">

<s:url id="widg_cbComuneurlComboBoxValueChange"
   action="/siceefree/cpRicercaCertificatori!handleCbComune_VALUE_CHANGED" namespace="/base/certificatore"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroCertificatore.comune" id="widg_cbComune"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbComune')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbComune','conferma','%{widg_cbComuneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbComune','conferma','%{widg_cbComuneurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaCertificatore --></div>

			
	
	<div id="p_pRicercaCertificatoreNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaCertificatoreNav -->
	
	
<div class="commandPanel navigation" id="pRicercaCertificatoreNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaCertificatori','btnAvanti')" >

	



<!-- widget btnAvanti -->
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpRicercaCertificatori.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaCertificatori','btnAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaCertificatoreNav --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
