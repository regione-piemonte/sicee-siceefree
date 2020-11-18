/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceefree.business.facade;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.sicee.siceefree.util.Constants;
import it.csi.sicee.siceeorch.interfacecsi.siceeorch.SiceeorchSrv;

import java.io.InputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivationMgr.
 */
public class ActivationMgr extends BaseMgr {

/** The srv. */
protected static SiceeorchSrv srv;
	
	/** The Constant PD_SORCH_RES. */
	public final static String PD_SORCH_RES = "/META-INF/defpd_siceeorch.xml";
	
	static{
		
		InputStream is = SOAIntegrationMgr.class.getResourceAsStream(PD_SORCH_RES);
		if (is != null){
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				srv = (SiceeorchSrv)PDProxy.newInstance(info);
				log.info("SICEEORCH Istanziato");
			} catch (Exception e) {
				log.error("ERRORE nell caricamento della PD del servizio di orchestrazione:"+e, e); // TODO log4j
			}
		}
		else{
			log.error("ERRORE nell caricamento della PD del servizio di orchestrazione:input stream nullo"); // TODO log4j
		}
		
	}

	/**
	 * Checks if is service enabled.
	 *
	 * @return true, if is service enabled
	 */
	public boolean isServiceEnabled() {
		boolean ret = false;
		try {
			ret = srv.isServiceEnabled(Constants.SICEEFREE);
		} catch (Exception e) {
			log.error("", e);
			return false;
		}
		
		return ret;
		
	}
}
