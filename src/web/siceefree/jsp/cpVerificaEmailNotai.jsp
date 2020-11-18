<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpVerificaEmailNotai -->

<s:form id="cpVerificaEmailNotai" action="cpVerificaEmailNotai" namespace="/base/main" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpVerificaEmailNotai','menu')" >

	


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
				<h3><s:text name="cpVerificaEmailNotai.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pError" class="stdMessagePanelBlock"><!-- startFragment:p_pError -->
	
	
<div class="stdMessagePanel" id="pError">
	<customtag:stdMessagePanel id="pError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pError --></div>

			
	
	<div id="p_pVerificaEmail" class="widgetsPanelBlock"><!-- startFragment:p_pVerificaEmail -->
	
	
<h4 class="wpLabel">Verifica e-mail notaio </h4>
<div class="widgetsPanel" id="pVerificaEmail">
	
	<customtag:widgetsPanel id="pVerificaEmailTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVerificaEmailNotai','lblCampiObbligatori')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget lblCampiObbligatori -->
<s:text name="cpVerificaEmailNotai.lblCampiObbligatori.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpVerificaEmailNotai','tfEmailNotaio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVerificaEmailNotai.tfEmailNotaio.label')}" labelFor="widg_tfEmailNotaio" errorFor="appDatanotaio.email" labelId="tfEmailNotaioLbl"
	  >


<!-- widget tfEmailNotaio -->
<s:textfield 
	
	
	name="appDatanotaio.email" id="widg_tfEmailNotaio"
maxlength="200"	disabled="isWidgetDisabled('cpVerificaEmailNotai','tfEmailNotaio')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pVerificaEmail --></div>

			
	
	<div id="p_cmdVerificaEmail" class="commandPanelBlock"><!-- startFragment:p_cmdVerificaEmail -->
	
	
<div class="commandPanel navigation" id="cmdVerificaEmail">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpVerificaEmailNotai','btnVerificaEmail')" >

	



<!-- widget btnVerificaEmail -->
<s:submit name="widg_btnVerificaEmail" id="widg_btnVerificaEmail" method="handleBtnVerificaEmail_CLICKED"
	key="cpVerificaEmailNotai.btnVerificaEmail.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVerificaEmailNotai','btnVerificaEmail')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cmdVerificaEmail --></div>

	

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
