<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
			
<s:if test="isMenuVisible('mnuHome')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuHome')">
		<s:if test="isMenuEnabled('mnuHome')">
			<li class="parent<s:property value="%{(isMenuActive('mnuHome') || isSubMenuActive('mnuHome')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuHome')"> id="current"</s:if>>
				<s:url id="targetUrlMnuHome" action="goToMnuHomeFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuHome}" id="menu_items_mnuHome">
					<span><s:text name="mnuHome.label" /></span>
				</s:a>
				<ul>
					

<s:if test="isMenuVisible('mnuRicercaAce')">
	<s:if test="isMenuEnabled('mnuRicercaAce')">
		<s:url id="targetUrlMnuRicercaAce" action="goToMnuRicercaAceFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaAce')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaAce}" id="menu_items_mnuRicercaAce">
				<s:text name="mnuRicercaAce.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaAce.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuRicercaCertificatore')">
	<s:if test="isMenuEnabled('mnuRicercaCertificatore')">
		<s:url id="targetUrlMnuRicercaCertificatore" action="goToMnuRicercaCertificatoreFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaCertificatore')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaCertificatore}" id="menu_items_mnuRicercaCertificatore">
				<s:text name="mnuRicercaCertificatore.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaCertificatore.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:if>
		<s:else>
			<li class="parent<s:property value="%{(isMenuActive('mnuHome') || isSubMenuActive('mnuHome')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuHome')"> id="current"</s:if>><span><s:text name="mnuHome.label" /></span>
				<ul>
					

<s:if test="isMenuVisible('mnuRicercaAce')">
	<s:if test="isMenuEnabled('mnuRicercaAce')">
		<s:url id="targetUrlMnuRicercaAce" action="goToMnuRicercaAceFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaAce')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaAce}" id="menu_items_mnuRicercaAce">
				<s:text name="mnuRicercaAce.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaAce.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuRicercaCertificatore')">
	<s:if test="isMenuEnabled('mnuRicercaCertificatore')">
		<s:url id="targetUrlMnuRicercaCertificatore" action="goToMnuRicercaCertificatoreFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicercaCertificatore')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicercaCertificatore}" id="menu_items_mnuRicercaCertificatore">
				<s:text name="mnuRicercaCertificatore.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicercaCertificatore.label" /></li>
	</s:else>
	

</s:if>



				</ul>
			</li>
		</s:else>
		
	
	</s:if>
	<s:else>
		<s:if test="isMenuEnabled('mnuHome')">
			<li<s:if test="isMenuActive('mnuHome')"> id="current" class="active"</s:if>>
				<s:url id="targetUrlMnuHome" action="goToMnuHomeFromMenu" namespace="/secure" includeParams="none" />
				<s:a href="%{targetUrlMnuHome}" id="menu_items_mnuHome">
					<s:text name="mnuHome.label" />
				</s:a>
			</li>
		</s:if>
		<s:else>
			<li><s:text name="mnuHome.label" /></li>
		</s:else>
		
	
	</s:else>
</s:if>

		

		
<!-- STATIC LINKS -->

<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="ex">
	<r:include url="/ris/utheme/sisp7/siceefree/include/static_links.html" resourceProvider="sp" />
</c:catch>
	</ul>
</div>


