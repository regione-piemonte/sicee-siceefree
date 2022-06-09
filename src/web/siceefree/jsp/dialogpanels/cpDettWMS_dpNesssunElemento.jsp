<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpNesssunElementoForm" action="cpDettWMS" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpDettWMS.dpNesssunElemento.label" /></h3>
				<div class="dialogPanel" id="dpNesssunElemento">

		
		
<div id="p_errorMsg" class="msgBoxPanelBlock"><!-- startFragment:p_errorMsg -->

	
<div class="msgBoxPanel warning" id="errorMsg">


		
<s:if test="isWidgetVisible('cpDettWMS','errormsgtext')" >

	
<p>


<!-- widget errormsgtext -->
<s:text name="cpDettWMS.errormsgtext.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_errorMsg --></div>

	
	<div id="p_cpErrorDialog" class="commandPanelBlock"><!-- startFragment:p_cpErrorDialog -->
	
	
<div class="commandPanel functional" id="cpErrorDialog">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettWMS','btnOk')" >

	



<!-- widget btnOk -->
<s:submit name="widg_btnOk" id="widg_btnOk" method="handleBtnOk_CLICKED"
	key="cpDettWMS.btnOk.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettWMS','btnOk')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpErrorDialog --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
