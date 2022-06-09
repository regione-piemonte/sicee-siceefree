<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_pError" class="stdMessagePanelBlock"><!-- startFragment:p_pError -->
	
	
<div class="stdMessagePanel" id="pError">
	<customtag:stdMessagePanel id="pError" errorMessage="true" errorDetails="true" actionMessage="true" />
</div>

	<!-- endFragment:p_pError --></div>

			
	
	<div id="p_wDettWMS" class="widgetsPanelBlock"><!-- startFragment:p_wDettWMS -->
	
	

<div class="widgetsPanel" id="wDettWMS">
	
	<customtag:widgetsPanel id="wDettWMSTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettWMS','tfCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfCertificato.label')}" labelFor="widg_tfCertificato" errorFor="appDatacurrentDettaglioGeografico.certificato" labelId="tfCertificatoLbl"
	position="first"  >


<!-- widget tfCertificato -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.certificato" id="widg_tfCertificato"
	disabled="isWidgetDisabled('cpDettWMS','tfCertificato')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfUbicazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfUbicazione.label')}" labelFor="widg_tfUbicazione" errorFor="appDatacurrentDettaglioGeografico.ubicazione" labelId="tfUbicazioneLbl"
	position="first"  >


<!-- widget tfUbicazione -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.ubicazione" id="widg_tfUbicazione"
	disabled="isWidgetDisabled('cpDettWMS','tfUbicazione')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wDettWMS --></div>

			
	
	<div id="p_wDettWMS2" class="widgetsPanelBlock"><!-- startFragment:p_wDettWMS2 -->
	
	

<div class="widgetsPanel" id="wDettWMS2">
	
	<customtag:widgetsPanel id="wDettWMS2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettWMS','wDettWMS2_1_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wDettWMS2_1_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','wDettWMS2_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wDettWMS2_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','wDettWMS2_3_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wDettWMS2_3_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfScadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfScadenza.label')}" labelFor="widg_tfScadenza" errorFor="appDatacurrentDettaglioGeografico.dtScadenza" labelId="tfScadenzaLbl"
	position="first"  >


<!-- widget tfScadenza -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.dtScadenza" id="widg_tfScadenza"
	disabled="isWidgetDisabled('cpDettWMS','tfScadenza')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfDestinazioneDuso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfDestinazioneDuso.label')}" labelFor="widg_tfDestinazioneDuso" errorFor="appDatacurrentDettaglioGeografico.destinazioneUso" labelId="tfDestinazioneDusoLbl"
	position="first"  >


<!-- widget tfDestinazioneDuso -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.destinazioneUso" id="widg_tfDestinazioneDuso"
	disabled="isWidgetDisabled('cpDettWMS','tfDestinazioneDuso')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfAnnoCostruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfAnnoCostruzione.label')}" labelFor="widg_tfAnnoCostruzione" errorFor="appDatacurrentDettaglioGeografico.annoCostruzione" labelId="tfAnnoCostruzioneLbl"
	position="first"  >


<!-- widget tfAnnoCostruzione -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.annoCostruzione" id="widg_tfAnnoCostruzione"
	disabled="isWidgetDisabled('cpDettWMS','tfAnnoCostruzione')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfAnnoUltRist')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfAnnoUltRist.label')}" labelFor="widg_tfAnnoUltRist" errorFor="appDatacurrentDettaglioGeografico.annoUltRist" labelId="tfAnnoUltRistLbl"
	position="first"  >


<!-- widget tfAnnoUltRist -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.annoUltRist" id="widg_tfAnnoUltRist"
	disabled="isWidgetDisabled('cpDettWMS','tfAnnoUltRist')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfVolLordorisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfVolLordorisc.label')}" labelFor="widg_tfVolLordorisc" errorFor="appDatacurrentDettaglioGeografico.volLordoRiscaldato" labelId="tfVolLordoriscLbl"
	position="first"  >


<!-- widget tfVolLordorisc -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.volLordoRiscaldato" id="widg_tfVolLordorisc"
	disabled="isWidgetDisabled('cpDettWMS','tfVolLordorisc')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfVolLordoRinf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfVolLordoRinf.label')}" labelFor="widg_tfVolLordoRinf" errorFor="appDatacurrentDettaglioGeografico.volLordoRaffrescato" labelId="tfVolLordoRinfLbl"
	position="first"  >


<!-- widget tfVolLordoRinf -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.volLordoRaffrescato" id="widg_tfVolLordoRinf"
	disabled="isWidgetDisabled('cpDettWMS','tfVolLordoRinf')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wDettWMS2 --></div>

			
	
	<div id="p_wRifCatastali" class="widgetsPanelBlock"><!-- startFragment:p_wRifCatastali -->
	
	
<h4 class="wpLabel">Riferimenti catastali principali </h4>
<div class="widgetsPanel" id="wRifCatastali">
	
	<customtag:widgetsPanel id="wRifCatastaliTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettWMS','tfRifCatastali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfRifCatastali.label')}" labelFor="widg_tfRifCatastali" errorFor="appDatacurrentDettaglioGeografico.rifCatasto" labelId="tfRifCatastaliLbl"
	position="first"  >


<!-- widget tfRifCatastali -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.rifCatasto" id="widg_tfRifCatastali"
	disabled="isWidgetDisabled('cpDettWMS','tfRifCatastali')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfFoglio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfFoglio.label')}" labelFor="widg_tfFoglio" errorFor="appDatacurrentDettaglioGeografico.foglio" labelId="tfFoglioLbl"
	position="first"  >


<!-- widget tfFoglio -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.foglio" id="widg_tfFoglio"
	disabled="isWidgetDisabled('cpDettWMS','tfFoglio')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfsezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfsezione.label')}" labelFor="widg_tfsezione" errorFor="appDatacurrentDettaglioGeografico.sezione" labelId="tfsezioneLbl"
	position="first"  >


<!-- widget tfsezione -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.sezione" id="widg_tfsezione"
	disabled="isWidgetDisabled('cpDettWMS','tfsezione')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfParticella')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfParticella.label')}" labelFor="widg_tfParticella" errorFor="appDatacurrentDettaglioGeografico.particella" labelId="tfParticellaLbl"
	position="first"  >


<!-- widget tfParticella -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.particella" id="widg_tfParticella"
	disabled="isWidgetDisabled('cpDettWMS','tfParticella')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettWMS','tfSub')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettWMS.tfSub.label')}" labelFor="widg_tfSub" errorFor="appDatacurrentDettaglioGeografico.sub" labelId="tfSubLbl"
	position="first"  >


<!-- widget tfSub -->
<s:textfield 
	
	
	name="appDatacurrentDettaglioGeografico.sub" id="widg_tfSub"
	disabled="isWidgetDisabled('cpDettWMS','tfSub')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wRifCatastali --></div>

			
	
	<div id="p_pDettaglioFun" class="commandPanelBlock"><!-- startFragment:p_pDettaglioFun -->
	
	
<div class="commandPanel functional" id="pDettaglioFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettWMS','btPrecedente')" >

	



<!-- widget btPrecedente -->
<s:submit name="widg_btPrecedente" id="widg_btPrecedente" method="handleBtPrecedente_CLICKED"
	key="cpDettWMS.btPrecedente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettWMS','btPrecedente')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettWMS','btSuccessivo')" >

	



<!-- widget btSuccessivo -->
<s:submit name="widg_btSuccessivo" id="widg_btSuccessivo" method="handleBtSuccessivo_CLICKED"
	key="cpDettWMS.btSuccessivo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettWMS','btSuccessivo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDettaglioFun --></div>

	

	<!-- endFragment:p_pCenter --></div>
