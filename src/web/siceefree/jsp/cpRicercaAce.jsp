<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ace -->
<!-- pageId:cpRicercaAce -->

<s:form id="cpRicercaAce" action="cpRicercaAce" namespace="/base/ace" method="post">


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

	
		
			
<s:if test="isWidgetVisible('cpRicercaAce','menu')" >

	


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
				<h3><s:text name="cpRicercaAce.pMain.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pErrorRicercaAce" class="stdMessagePanelBlock"><!-- startFragment:p_pErrorRicercaAce -->
	
	
<div class="stdMessagePanel" id="pErrorRicercaAce">
	<customtag:stdMessagePanel id="pErrorRicercaAce" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrorRicercaAce --></div>

			
	
	<div id="p_pRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAce -->
	
	

<div class="widgetsPanel" id="pRicercaAce">
	
	<customtag:widgetsPanel id="pRicercaAceTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','tfAnno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfAnno.label')}" labelFor="widg_tfAnno" errorFor="appDatafiltroAce.anno" labelId="tfAnnoLbl"
	position="first"  >


<!-- widget tfAnno -->
<s:textfield 
	
	
	name="appDatafiltroAce.anno" id="widg_tfAnno"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfAnno')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfCerticatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfCerticatore.label')}" labelFor="widg_tfCerticatore" errorFor="appDatafiltroAce.certificatore" labelId="tfCerticatoreLbl"
	  >


<!-- widget tfCerticatore -->
<s:textfield 
	
	
	name="appDatafiltroAce.certificatore" id="widg_tfCerticatore"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaAce','tfCerticatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfNumero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfNumero.label')}" labelFor="widg_tfNumero" errorFor="appDatafiltroAce.numero" labelId="tfNumeroLbl"
	position="last"  >


<!-- widget tfNumero -->
<s:textfield 
	
	
	name="appDatafiltroAce.numero" id="widg_tfNumero"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfNumero')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAce --></div>

			
	
	<div id="p_pNote" class="widgetsPanelBlock"><!-- startFragment:p_pNote -->
	
	

<div class="widgetsPanel" id="pNote">
	
	<customtag:widgetsPanel id="pNoteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaA -->
<s:text name="cpRicercaAce.ptNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaB')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaB -->
<s:text name="cpRicercaAce.ptNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pNote --></div>

			
	
	<div id="p_pRicercaAceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAce','btnAvanti')" >

	



<!-- widget btnAvanti -->
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpRicercaAce.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAce','btnAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceNav --></div>

			
	
	<div id="p_pRicercaAceFiltro" class="widgetsPanelBlock"><!-- startFragment:p_pRicercaAceFiltro -->
	
	

<div class="widgetsPanel" id="pRicercaAceFiltro">
	
	<customtag:widgetsPanel id="pRicercaAceFiltroTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','cbProvRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbProvRicercaAce.label')}" labelFor="widg_cbProvRicercaAce" errorFor="appDatafiltroAce.codProv" labelId="cbProvRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbProvRicercaAce -->

<s:url id="widg_cbProvRicercaAceurlComboBoxValueChange"
   action="/siceefree/cpRicercaAce!handleCbProvRicercaAce_VALUE_CHANGED" namespace="/base/ace"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatafiltroAce.codProv" id="widg_cbProvRicercaAce"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaAce','cbProvRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvRicercaAce','conferma','%{widg_cbProvRicercaAceurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbComRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbComRicercaAce.label')}" labelFor="widg_cbComRicercaAce" errorFor="appDatafiltroAce.codComune" labelId="cbComRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget cbComRicercaAce -->
<s:select name="appDatafiltroAce.codComune" id="widg_cbComRicercaAce"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaAce','cbComRicercaAce')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfComRicercaAce')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="4" >


<!-- widget tfComRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descComune" id="widg_tfComRicercaAce"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaAce','tfComRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfIndirizzoRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfIndirizzoRicercaAce.label')}" labelFor="widg_tfIndirizzoRicercaAce" errorFor="appDatafiltroAce.descIndirizzo" labelId="tfIndirizzoRicercaAceLbl"
	position="first" colSpan="3" >


<!-- widget tfIndirizzoRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.descIndirizzo" id="widg_tfIndirizzoRicercaAce"
maxlength="160"	disabled="isWidgetDisabled('cpRicercaAce','tfIndirizzoRicercaAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfNCivRicercaAce')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfNCivRicercaAce.label')}" labelFor="widg_tfNCivRicercaAce" errorFor="appDatafiltroAce.numCivico" labelId="tfNCivRicercaAceLbl"
	  >


<!-- widget tfNCivRicercaAce -->
<s:textfield 
	
	
	name="appDatafiltroAce.numCivico" id="widg_tfNCivRicercaAce"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfNCivRicercaAce')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSezCatasto.label')}" labelFor="widg_tfSezCatasto" errorFor="appDatafiltroAce.sezione" labelId="tfSezCatastoLbl"
	position="first"  >


<!-- widget tfSezCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.sezione" id="widg_tfSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAce','tfSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfFoglioCatasto.label')}" labelFor="widg_tfFoglioCatasto" errorFor="appDatafiltroAce.foglio" labelId="tfFoglioCatastoLbl"
	  >


<!-- widget tfFoglioCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.foglio" id="widg_tfFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAce','tfFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfParticCatasto.label')}" labelFor="widg_tfParticCatasto" errorFor="appDatafiltroAce.particella" labelId="tfParticCatastoLbl"
	  >


<!-- widget tfParticCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.particella" id="widg_tfParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpRicercaAce','tfParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSubaltCatasto.label')}" labelFor="widg_tfSubaltCatasto" errorFor="appDatafiltroAce.subalterno" labelId="tfSubaltCatastoLbl"
	position="last"  >


<!-- widget tfSubaltCatasto -->
<s:textfield 
	
	
	name="appDatafiltroAce.subalterno" id="widg_tfSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pRicercaAceFiltro --></div>

			
	
	<div id="p_pRicercaAceByFiltroNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceByFiltroNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceByFiltroNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAce','btnAvantiFiltro')" >

	



<!-- widget btnAvantiFiltro -->
<s:submit name="widg_btnAvantiFiltro" id="widg_btnAvantiFiltro" method="handleBtnAvantiFiltro_CLICKED"
	key="cpRicercaAce.btnAvantiFiltro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAce','btnAvantiFiltro')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceByFiltroNav --></div>

	

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
