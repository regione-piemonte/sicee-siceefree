<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/certificatore -->
<!-- pageId:cpDettaglioCertificatore -->

<s:form id="cpDettaglioCertificatore" action="cpDettaglioCertificatore" namespace="/base/certificatore" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioCertificatore','menu')" >

	


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
				<h3><s:text name="cpDettaglioCertificatore.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pError" class="stdMessagePanelBlock"><!-- startFragment:p_pError -->
	
	
<div class="stdMessagePanel" id="pError">
	<customtag:stdMessagePanel id="pError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pError --></div>

			
	
	<div id="p_pDettaglioCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_pDettaglioCertificatore -->
	
	

<div class="widgetsPanel" id="pDettaglioCertificatore">
	
	<customtag:widgetsPanel id="pDettaglioCertificatoreTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblMatricola')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblMatricola.label')}" labelFor="widg_lblMatricola" errorFor="appDatacertificatore.matricola" labelId="lblMatricolaLbl"   >


<!-- widget lblMatricola -->
<s:property value="appDatacertificatore.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblNome')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblNome.label')}" labelFor="widg_lblNome" errorFor="appDatacertificatore.nome" labelId="lblNomeLbl"   >


<!-- widget lblNome -->
<s:property value="appDatacertificatore.nome" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblCognome')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblCognome.label')}" labelFor="widg_lblCognome" errorFor="appDatacertificatore.cognome" labelId="lblCognomeLbl"   >


<!-- widget lblCognome -->
<s:property value="appDatacertificatore.cognome" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblTelefono')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblTelefono.label')}" labelFor="widg_lblTelefono" errorFor="appDatacertificatore.telefono" labelId="lblTelefonoLbl"   >


<!-- widget lblTelefono -->
<s:property value="appDatacertificatore.telefono" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblCellulare')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblCellulare.label')}" labelFor="widg_lblCellulare" errorFor="appDatacertificatore.cellulare" labelId="lblCellulareLbl"   >


<!-- widget lblCellulare -->
<s:property value="appDatacertificatore.cellulare" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblEmail')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblEmail.label')}" labelFor="widg_lblEmail" errorFor="appDatacertificatore.email" labelId="lblEmailLbl"   >


<!-- widget lblEmail -->
<s:property value="appDatacertificatore.email" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblSitoWeb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblSitoWeb.label')}" labelFor="widg_lblSitoWeb" errorFor="appDatacertificatore.sitoWeb" labelId="lblSitoWebLbl"   >


<!-- widget lblSitoWeb -->
<s:property value="appDatacertificatore.sitoWeb" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblTitolo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblTitolo.label')}" labelFor="widg_lblTitolo" errorFor="appDatacertificatore.titolo" labelId="lblTitoloLbl"   >


<!-- widget lblTitolo -->
<s:property value="appDatacertificatore.titolo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblRagioneSociale')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblRagioneSociale.label')}" labelFor="widg_lblRagioneSociale" errorFor="appDatacertificatore.ragioneSociale" labelId="lblRagioneSocialeLbl"   >


<!-- widget lblRagioneSociale -->
<s:property value="appDatacertificatore.ragioneSociale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblIndirizzo.label')}" labelFor="widg_lblIndirizzo" errorFor="appDatacertificatore.indirizzo" labelId="lblIndirizzoLbl"   >


<!-- widget lblIndirizzo -->
<s:property value="appDatacertificatore.indirizzo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblProvincia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblProvincia.label')}" labelFor="widg_lblProvincia" errorFor="appDatacertificatore.provincia" labelId="lblProvinciaLbl"   >


<!-- widget lblProvincia -->
<s:property value="appDatacertificatore.provincia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblComune')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblComune.label')}" labelFor="widg_lblComune" errorFor="appDatacertificatore.comune" labelId="lblComuneLbl"   >


<!-- widget lblComune -->
<s:property value="appDatacertificatore.comune" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDettaglioCertificatore --></div>

			
	
	<div id="p_pScaricoDocumento" class="commandPanelBlock"><!-- startFragment:p_pScaricoDocumento -->
	
	
<div class="commandPanel functional" id="pScaricoDocumento">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','btnScaricaCV')" >

	



<!-- widget btnScaricaCV -->
<s:submit name="widg_btnScaricaCV" id="widg_btnScaricaCV" method="handleBtnScaricaCV_CLICKED"
	key="cpDettaglioCertificatore.btnScaricaCV.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','btnScaricaCV')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pScaricoDocumento --></div>

			
	
	<div id="p_pRicercaCertificatoreNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaCertificatoreNav -->
	
	
<div class="commandPanel navigation" id="pRicercaCertificatoreNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpDettaglioCertificatore.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','btnIndietro')" />

	


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
