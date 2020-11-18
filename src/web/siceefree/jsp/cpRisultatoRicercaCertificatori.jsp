<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceefree/presentation/siceefree/action/certificatore/CpRisultatoRicercaCertificatoriAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/certificatore -->
<!-- pageId:cpRisultatoRicercaCertificatori -->

<s:form id="cpRisultatoRicercaCertificatori" action="cpRisultatoRicercaCertificatori" namespace="/base/certificatore" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoRicercaCertificatori','menu')" >

	


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
				<h3><s:text name="cpRisultatoRicercaCertificatori.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pError" class="stdMessagePanelBlock"><!-- startFragment:p_pError -->
	
	
<div class="stdMessagePanel" id="pError">
	<customtag:stdMessagePanel id="pError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pError --></div>

			
	
	<div id="p_pRisultatoRicercaCertificatori" class="widgetsPanelBlock"><!-- startFragment:p_pRisultatoRicercaCertificatori -->
	
	

<div class="widgetsPanel" id="pRisultatoRicercaCertificatori">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaCertificatori','tblRisultatoCertificatori')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoCertificatori -->
<s:set name="cpRisultatoRicercaCertificatori_tblRisultatoCertificatori_clearStatus" value="isTableClearStatus('cpRisultatoRicercaCertificatori_tblRisultatoCertificatori')" />
<s:url id="cpRisultatoRicercaCertificatoriViewUrl"						   
					   action="cpRisultatoRicercaCertificatori"
					   namespace="/base/certificatore"/>
<display:table name="appDatacertificatori"  				
			   excludedParams="*"			   export="true"
               id="widg_tblRisultatoCertificatori"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoRicercaCertificatoriViewUrl}"  
               clearStatus="${cpRisultatoRicercaCertificatori_tblRisultatoCertificatori_clearStatus}"
               uid="row_tblRisultatoCertificatori"
               summary="" 
decorator="it.csi.sicee.siceefree.presentation.decorator.certificatore.CpRisultatoRicercaCertificatoriTblRisultatoCertificatoriCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoCertificatori.matricola}" name="appDataidCertificatore" id="%{'tblRisultatoCertificatori-editcell-'+ (#attr.row_tblRisultatoCertificatori_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="matricola" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.matricola.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="matricola" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.matricola.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="matricola" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.matricola.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="nome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.nome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.nome.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="nome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.nome.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="cognome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="cognome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.cognome.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="cognome" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.cognome.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="titolo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.titolo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="titolo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.titolo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="titolo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.titolo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="ragioneSociale" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.ragioneSociale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="ragioneSociale" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.ragioneSociale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="ragioneSociale" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.ragioneSociale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="indirizzo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.indirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="indirizzo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.indirizzo.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="indirizzo" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.indirizzo.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="provincia" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.provincia.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="provincia" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.provincia.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="provincia" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.provincia.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="comune" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.comune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="comune" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.comune.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="comune" titleKey="cpRisultatoRicercaCertificatori.tblRisultatoCertificatori.comune.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_pRisultatoRicercaCertificatori --></div>

			
	
	<div id="p_pRisultatoCertificatoreNav" class="commandPanelBlock"><!-- startFragment:p_pRisultatoCertificatoreNav -->
	
	
<div class="commandPanel navigation" id="pRisultatoCertificatoreNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaCertificatori','btnDettaglio')" >

	



<!-- widget btnDettaglio -->
<s:submit name="widg_btnDettaglio" id="widg_btnDettaglio" method="handleBtnDettaglio_CLICKED"
	key="cpRisultatoRicercaCertificatori.btnDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaCertificatori','btnDettaglio')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaCertificatori','btnNuovaRicerca')" >

	



<!-- widget btnNuovaRicerca -->
<s:submit name="widg_btnNuovaRicerca" id="widg_btnNuovaRicerca" method="handleBtnNuovaRicerca_CLICKED"
	key="cpRisultatoRicercaCertificatori.btnNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaCertificatori','btnNuovaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaCertificatori','btnAffinaRicerca')" >

	



<!-- widget btnAffinaRicerca -->
<s:submit name="widg_btnAffinaRicerca" id="widg_btnAffinaRicerca" method="handleBtnAffinaRicerca_CLICKED"
	key="cpRisultatoRicercaCertificatori.btnAffinaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaCertificatori','btnAffinaRicerca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRisultatoCertificatoreNav --></div>

	

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
