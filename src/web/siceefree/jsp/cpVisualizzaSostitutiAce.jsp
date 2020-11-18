<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceefree/presentation/siceefree/action/ace/CpVisualizzaSostitutiAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ace -->
<!-- pageId:cpVisualizzaSostitutiAce -->

<s:form id="cpVisualizzaSostitutiAce" action="cpVisualizzaSostitutiAce" namespace="/base/ace" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpVisualizzaSostitutiAce','menu')" >

	


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
				<h3><s:text name="cpVisualizzaSostitutiAce.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_wpAceSostituito" class="widgetsPanelBlock"><!-- startFragment:p_wpAceSostituito -->
	
	

<div class="widgetsPanel" id="wpAceSostituito">
	
	<customtag:widgetsPanel id="wpAceSostituitoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVisualizzaSostitutiAce','ptNCertificato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpVisualizzaSostitutiAce.ptNCertificato.label')}" labelFor="widg_ptNCertificato" errorFor="appDatacodAceSelezionato" labelId="ptNCertificatoLbl"   >


<!-- widget ptNCertificato -->
<s:property value="appDatacodAceSelezionato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAceSostituito --></div>

			
	
	<div id="p_pRisultatoSostituzioni" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoSostituzioni -->
	
	

<div class="widgetsPanel" id="pRisultatoSostituzioni">
	

	
	
<s:if test="isWidgetVisible('cpVisualizzaSostitutiAce','tblSostitutiAce')" >

	
<div class="tableWidget">


<!-- widget tblSostitutiAce -->
<s:set name="cpVisualizzaSostitutiAce_tblSostitutiAce_clearStatus" value="isTableClearStatus('cpVisualizzaSostitutiAce_tblSostitutiAce')" />
<s:url id="cpVisualizzaSostitutiAceViewUrl"						   
					   action="cpVisualizzaSostitutiAce"
					   namespace="/base/ace"/>
<display:table name="appDatacertificatiSostitutivi"  				
			   excludedParams="*"			   export="false"
               id="widg_tblSostitutiAce"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpVisualizzaSostitutiAceViewUrl}"  
               clearStatus="${cpVisualizzaSostitutiAce_tblSostitutiAce_clearStatus}"
               uid="row_tblSostitutiAce"
               summary="" 
               class="dataTable">
	
		<display:column property="codice" titleKey="cpVisualizzaSostitutiAce.tblSostitutiAce.codice.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpVisualizzaSostitutiAce.tblSostitutiAce.descStato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoSostituzioni --></div>

			
	
	<div id="p_cpSostituzioniNav" class="commandPanelBlock"><!-- startFragment:p_cpSostituzioniNav -->
	
	
<div class="commandPanel navigation" id="cpSostituzioniNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpVisualizzaSostitutiAce','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpVisualizzaSostitutiAce.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVisualizzaSostitutiAce','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpSostituzioniNav --></div>

	

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
