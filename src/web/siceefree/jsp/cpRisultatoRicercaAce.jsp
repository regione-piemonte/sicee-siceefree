<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceefree/presentation/siceefree/action/ace/CpRisultatoRicercaAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ace -->
<!-- pageId:cpRisultatoRicercaAce -->

<s:form id="cpRisultatoRicercaAce" action="cpRisultatoRicercaAce" namespace="/base/ace" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','menu')" >

	


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
				<h3><s:text name="cpRisultatoRicercaAce.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrorRisultatoAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrorRisultatoAce -->
	
	
<div class="stdMessagePanel" id="pErrorRisultatoAce">
	<customtag:stdMessagePanel id="pErrorRisultatoAce" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrorRisultatoAce --></div>

			
	
	<div id="p_pRisultatoRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoRicercaAce -->
	
	

<div class="widgetsPanel" id="pRisultatoRicercaAce">
	
	<customtag:widgetsPanel id="pRisultatoRicercaAceTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','tfEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRisultatoRicercaAce.tfEmail.label')}" labelFor="widg_tfEmail" errorFor="appDatanotaio.email" labelId="tfEmailLbl"
	  >


<!-- widget tfEmail -->
<s:textfield 
	
title=""	
	name="appDatanotaio.email" id="widg_tfEmail"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','tfEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRisultatoRicercaAce --></div>

			
	
	<div id="p_pRisultatoRicercaAceTabella" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoRicercaAceTabella -->
	
	

<div class="widgetsPanel" id="pRisultatoRicercaAceTabella">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','tblRisultatoAce')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoAce -->
	<csiuicore:ajaxify id="p_pRisultatoRicercaAceTabella" 
		widgetType="table"		
		pageId="cpRisultatoRicercaAce"
		javascriptDetection="false">
<s:set name="cpRisultatoRicercaAce_tblRisultatoAce_clearStatus" value="isTableClearStatus('cpRisultatoRicercaAce_tblRisultatoAce')" />
<s:url id="cpRisultatoRicercaAceViewUrl"						   
					   action="cpRisultatoRicercaAce"
					   namespace="/base/ace"/>
<display:table name="appDatacertificati"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoRicercaAceViewUrl}"  
               clearStatus="${cpRisultatoRicercaAce_tblRisultatoAce_clearStatus}"
               uid="row_tblRisultatoAce"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoAce.codice}" name="appDatacodAceSelezionato" id="%{'tblRisultatoAce-editcell-'+ (#attr.row_tblRisultatoAce_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRisultatoRicercaAce.tblRisultatoAce.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisultatoRicercaAce.tblRisultatoAce.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataInvio" titleKey="cpRisultatoRicercaAce.tblRisultatoAce.dataInvio.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceefree.presentation.siceefree.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="dataScadenza" titleKey="cpRisultatoRicercaAce.tblRisultatoAce.dataScadenza.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceefree.presentation.siceefree.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpRisultatoRicercaAce.tblRisultatoAce.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoRicercaAceTabella --></div>

			
	
	<div id="p_pInvioAce" class="commandPanelBlock"><!-- startFragment:p_pInvioAce -->
	
	
<div class="commandPanel functional" id="pInvioAce">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','bStampaReport')" >

	



<!-- widget bStampaReport -->
<s:submit name="widg_bStampaReport" id="widg_bStampaReport" method="handleBStampaReport_CLICKED"
	key="cpRisultatoRicercaAce.bStampaReport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','bStampaReport')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','btnInvioAce')" >

	



<!-- widget btnInvioAce -->
<s:submit name="widg_btnInvioAce" id="widg_btnInvioAce" method="handleBtnInvioAce_CLICKED"
	key="cpRisultatoRicercaAce.btnInvioAce.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','btnInvioAce')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','btnStampaCopia')" >

	



<!-- widget btnStampaCopia -->
<s:submit name="widg_btnStampaCopia" id="widg_btnStampaCopia" method="handleBtnStampaCopia_CLICKED"
	key="cpRisultatoRicercaAce.btnStampaCopia.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','btnStampaCopia')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pInvioAce --></div>

			
	
	<div id="p_pRisultatoAceNav" class="commandPanelBlock"><!-- startFragment:p_pRisultatoAceNav -->
	
	
<div class="commandPanel navigation" id="pRisultatoAceNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','btnNuovaRicerca')" >

	



<!-- widget btnNuovaRicerca -->
<s:submit name="widg_btnNuovaRicerca" id="widg_btnNuovaRicerca" method="handleBtnNuovaRicerca_CLICKED"
	key="cpRisultatoRicercaAce.btnNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','btnNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAce','btnSostituzioni')" >

	



<!-- widget btnSostituzioni -->
<s:submit name="widg_btnSostituzioni" id="widg_btnSostituzioni" method="handleBtnSostituzioni_CLICKED"
	key="cpRisultatoRicercaAce.btnSostituzioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAce','btnSostituzioni')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRisultatoAceNav --></div>

	

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
