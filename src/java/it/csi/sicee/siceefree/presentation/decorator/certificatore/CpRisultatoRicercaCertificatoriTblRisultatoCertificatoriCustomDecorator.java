package it.csi.sicee.siceefree.presentation.decorator.certificatore;

/*PROTECTED REGION ID(R294738006) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sicee.siceefree.dto.certificatore.Certificatore;
import it.csi.sicee.siceefree.util.GenericUtil;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRisultatoRicercaCertificatoriTblRisultatoCertificatoriCustomDecorator extends TableDecorator {

	public CpRisultatoRicercaCertificatoriTblRisultatoCertificatoriCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-272525677) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2
	public String getEsameSostenuto() {
		Certificatore res = (Certificatore) this.getCurrentRowObject();
		if (GenericUtil.isNullOrEmpty(res.getEsameSostenuto())) {
			return "";
		}

		if (GenericUtil.isTrue(res.getEsameSostenuto())) {
			//return "<img src=\"./img/true-icon.gif\" />";
			return "<img src=\"/siceefree/img/true-icon.gif\" />";
		} else {
			return ""; //"<img src=\"./img/false-icon.gif\" />";
		}
	}
	/*PROTECTED REGION END*/

}
