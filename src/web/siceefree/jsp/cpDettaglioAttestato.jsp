<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceefree/presentation/siceefree/action/ace/CpDettaglioAttestatoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ace -->
<!-- pageId:cpDettaglioAttestato -->

<s:form id="cpDettaglioAttestato" action="cpDettaglioAttestato" namespace="/base/ace" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioAttestato','menu')" >

	


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
				<h3><s:text name="cpDettaglioAttestato.pDettaglioAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pDettaglioAttestato" class="widgetsPanelBlock"><!-- startFragment:p_pDettaglioAttestato -->
	
	

<div class="widgetsPanel" id="pDettaglioAttestato">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioAttestato','tbDettaglioAttestato')" >

	
<div class="tableWidget">


<!-- widget tbDettaglioAttestato -->
<s:set name="cpDettaglioAttestato_tbDettaglioAttestato_clearStatus" value="isTableClearStatus('cpDettaglioAttestato_tbDettaglioAttestato')" />
<s:url id="cpDettaglioAttestatoViewUrl"						   
					   action="cpDettaglioAttestato"
					   namespace="/base/ace"/>
<display:table name="appDatalabelValueArray"  				
			   excludedParams="*"			   export="true"
               id="widg_tbDettaglioAttestato"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioAttestatoViewUrl}"  
               clearStatus="${cpDettaglioAttestato_tbDettaglioAttestato_clearStatus}"
               uid="row_tbDettaglioAttestato"
               summary="" 
               class="dataTable">
	
		<display:column property="label" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.label.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="label" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.label.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="label" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.label.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="value" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.value.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="value" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.value.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="value" titleKey="cpDettaglioAttestato.tbDettaglioAttestato.value.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pDettaglioAttestato --></div>

			
	
	<div id="p_pDettaglioNav" class="commandPanelBlock"><!-- startFragment:p_pDettaglioNav -->
	
	
<div class="commandPanel navigation" id="pDettaglioNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioAttestato','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpDettaglioAttestato.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioAttestato','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDettaglioNav --></div>

	

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
