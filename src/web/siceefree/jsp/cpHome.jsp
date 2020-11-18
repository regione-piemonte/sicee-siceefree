<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpHome -->

<s:form id="cpHome" action="cpHome" namespace="/base/main" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpHome.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pCittadino" class="widgetsPanelBlock"><!-- startFragment:p_pCittadino -->
	
	
<h4 class="wpLabel">Cittadino </h4>
<div class="widgetsPanel" id="pCittadino">
	
	<customtag:widgetsPanel id="pCittadinoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','ptCittadino1')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptCittadino1 -->
<s:text name="cpHome.ptCittadino1.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpHome','ptCittadino2')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptCittadino2 -->
<s:text name="cpHome.ptCittadino2.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pCittadino --></div>

			
	
	<div id="p_cpSceltaCittadino" class="commandPanelBlock"><!-- startFragment:p_cpSceltaCittadino -->
	
	
<div class="commandPanel navigation" id="cpSceltaCittadino">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpHome','btnCittadini')" >

	



<!-- widget btnCittadini -->
<s:submit name="widg_btnCittadini" id="widg_btnCittadini" method="handleBtnCittadini_CLICKED"
	key="cpHome.btnCittadini.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btnCittadini')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpSceltaCittadino --></div>

			
	
	<div id="p_pNotaio" class="widgetsPanelBlock"><!-- startFragment:p_pNotaio -->
	
	
<h4 class="wpLabel">Notaio </h4>
<div class="widgetsPanel" id="pNotaio">
	
	<customtag:widgetsPanel id="pNotaioTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpHome','ptNotaio1')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaio1 -->
<s:text name="cpHome.ptNotaio1.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpHome','ptNotaio2')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaio2 -->
<s:text name="cpHome.ptNotaio2.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpHome','ptNotaio3')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaio3 -->
<s:text name="cpHome.ptNotaio3.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pNotaio --></div>

			
	
	<div id="p_pSceltaNotai" class="commandPanelBlock"><!-- startFragment:p_pSceltaNotai -->
	
	
<div class="commandPanel navigation" id="pSceltaNotai">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpHome','btnNotai')" >

	



<!-- widget btnNotai -->
<s:submit name="widg_btnNotai" id="widg_btnNotai" method="handleBtnNotai_CLICKED"
	key="cpHome.btnNotai.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpHome','btnNotai')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pSceltaNotai --></div>

	

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
