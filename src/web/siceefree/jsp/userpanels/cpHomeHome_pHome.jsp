<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pHome" class="panelBlock"><!-- startFragment:p_pHome -->
<div class="userDefinedPanel" id="pHome">
<!--PROTECTED REGION ID(R1105740315) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div class="contenuti">	
	<dl>
	<dt>
	<s:url id="targetUrlRicercaAce" action="goToMnuRicercaAceFromMenu" includeParams="none" namespace="/secure" />
	<s:a href="%{targetUrlRicercaAce}">
		<s:text name="Ricerca A.P.E." />
	</s:a>
	</dt>
	<dd>
		In questa sezione &egrave; possibile effettuare una ricerca di A.P.E. trasmessi al SICEE sia tramite codice A.P.E. (es. 2009 - 100100 - 0001 indicando i seguenti numeri negli appositi campi 'anno' - 'certificatore' - 'numero A.P.E.') che per indirizzo e dati catastali. 
		Una volta effettuata la ricerca, per i cittadini sar&agrave; possibile visualizzare un dettaglio dell'attestato, mentre per i notai il sistema provveder&agrave; all'invio dell'A.P.E. originale e la copia della ricevuta di trasmissione all'indirizzo e-mail utilizzato per l'accesso.	</dd>
	<dt>
	<s:url id="targetUrlRicercaCert" action="goToMnuRicercaCertificatoreFromMenu" includeParams="none" namespace="/secure" />
	<s:a href="%{targetUrlRicercaCert}">
		<s:text name="Ricerca certificatore" />
	</s:a>
	</dt>
	<dd>
	Questa sezione consente la consultazione dell'elenco dei certificatori iscritti all'elenco regionale.
	Per ogni certificatore &egrave; possibile visualizzare i dati dello studio professionale, i contatti e l'eventuale curriculum.

	</dd>	
	</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pHome --></div>
