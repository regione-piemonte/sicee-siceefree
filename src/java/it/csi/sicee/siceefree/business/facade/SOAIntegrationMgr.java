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
import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sicee.siceefree.business.BEException;
import it.csi.sicee.siceefree.dto.LabelValue;
import it.csi.sicee.siceefree.dto.ace.Ace;
import it.csi.sicee.siceefree.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceefree.dto.certificatore.Certificatore;
import it.csi.sicee.siceefree.dto.certificatore.FiltroRicercaCertificatori;
import it.csi.sicee.siceefree.dto.geo.Comune;
import it.csi.sicee.siceefree.dto.geo.Provincia;
import it.csi.sicee.siceefree.dto.geo.Regione;
import it.csi.sicee.siceefree.dto.geo.Titolo;
import it.csi.sicee.siceefree.util.Constants;
import it.csi.sicee.siceefree.util.Converter;
import it.csi.sicee.siceefree.util.GenericUtil;
import it.csi.sicee.siceefree.util.MailSender;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeorch.dto.siceeorch.Impianto;
import it.csi.sicee.siceeorch.dto.siceeorch.InvioLog;
import it.csi.sicee.siceeorch.dto.siceeorch.Protocollazione;
import it.csi.sicee.siceeorch.exception.siceeorch.DocumentoException;
import it.csi.sicee.siceeorch.exception.siceeorch.SiceesrvException;
import it.csi.sicee.siceeorch.exception.siceeorch.ToponomasticaException;
import it.csi.sicee.siceeorch.interfacecsi.siceeorch.SiceeorchSrv;
import it.csi.sicee.siceews.stubs.Allegato;
import it.csi.sicee.siceews.stubs.Mail;
import it.csi.sicee.siceews.stubs.SiceewsMgrLocator;
import it.csi.sicee.siceews.stubs.SiceewsMgrSoapBindingStub;

//import javax.wsdl.OperationType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Questa classe rappresenta il punto di contatto tra lo strato spring della web application
 * e il servizio di orchestrazione siceeorch.
 *
 * @author 869
 */
public class SOAIntegrationMgr extends BaseMgr {

	/** The srv. */
	protected static SiceeorchSrv srv;
	protected static SiceewsMgrSoapBindingStub srvSiceews;

	/** The Constant PD_SORCH_RES. */
	public final static String PD_SORCH_RES = "/META-INF/defpd_siceeorch.xml";
	
	private static String wsSiceeUrl = null;

	/**
	 * @param prot protocollo di richiamo del PEP. Puo' valere: 
	 * 1) EJB (default)
	 * 2) WS
	 * utilizzato solo se la security non e' custom
	 */
	public void setWSSiceeUrl(String ws) {
		log.debug("Stampo il ws passato: "+ws);
		wsSiceeUrl = ws;
	}

	public static String getWSSiceeUrl() {
		return wsSiceeUrl;
	}
	
	// Questo metodo non serve piu' perche' srvSiceews viene creato quando si istanzia la classe, lo lascio per sicurezza
	private static SiceewsMgrSoapBindingStub getWSSicee()
	{
		log.debug("PROVA - srvSiceews - prima: "+srvSiceews);
		
		if (srvSiceews == null)
		{
			SiceewsMgrLocator loc = new SiceewsMgrLocator();
			//+Constants.WS_SICEEWS_URL
			//				log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
			//				loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
			log.debug("SOAIntegrationMgr - PASSO 2");
			try {
				srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
				
				log.debug("PROVA - srvSiceews - dopo: "+srvSiceews);

				log.debug("SOAIntegrationMgr - PASSO 3");

			} catch (Exception e) {
				log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
			}
			catch (Throwable t)
			{
				log.debug("SOAIntegrationMgr - PASSO 4");

				log.error(t);
				log.debug("SOAIntegrationMgr - PASSO 5");

			}
		}
		return srvSiceews;
	}

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
	
	static{
		
		SiceewsMgrLocator loc = new SiceewsMgrLocator();
		//+Constants.WS_SICEEWS_URL
		log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
		loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
		log.debug("SOAIntegrationMgr - PASSO 2");
		try {
			srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
			
			log.debug("SOAIntegrationMgr - PASSO 3");

		} catch (Exception e) {
			log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
		}
		catch (Throwable t)
		{
			log.debug("SOAIntegrationMgr - PASSO 4");
			
			log.error(t);
			log.debug("SOAIntegrationMgr - PASSO 5");

		}
		
	}
	
	/**
	 * Gets the province by piemonte.
	 *
	 * @return the province by piemonte
	 * @throws BEException the bE exception
	 */
	public List<Provincia> getProvinceByPiemonte() throws BEException{
		List<Provincia> ris = new ArrayList<Provincia>();
			try {
				ris = this.getProvinceByRegione("01");
			} catch (BEException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			}
			
			return ris;
	}
	
	/**
	 * Gets the all regioni.
	 *
	 * @return the all regioni
	 * @throws BEException the bE exception
	 */
	public List<Regione> getAllRegioni() throws BEException {
		ArrayList<Regione> ris = new ArrayList<Regione>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Regione[] regioni = srv
					.elencoRegioni();
			if (regioni != null) {
				for (it.csi.sicee.siceeorch.dto.siceeorch.Regione currReg : regioni) {
					Regione currRis = new Regione();
					currRis.setCod(currReg.getCod());
					currRis.setNome(currReg.getNome());
					ris.add(currRis);
				}
			}
			return ris;
		} catch (ToponomasticaException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getAllRegioni:" + e, e);
		}
	}
	
	/**
	 * Gets the province by regione.
	 *
	 * @param codRegione the cod regione
	 * @return the province by regione
	 * @throws BEException the bE exception
	 */
	public List<Provincia> getProvinceByRegione(String codRegione) throws BEException{
		ArrayList<Provincia> ris = new ArrayList<Provincia>();
		if (codRegione !=null && codRegione.length()>0){
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Provincia[] province = 
					srv.elencoProvince(codRegione);
				if (province!=null){
					for(it.csi.sicee.siceeorch.dto.siceeorch.Provincia currProv:province){
						Provincia currRis = new Provincia();
						currRis.setCod(currProv.getCod());
						currRis.setNome(currProv.getNome());
						ris.add(currRis);
					}
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			}
		}
		else
			return ris;
	}
	
	
	/**
	 * Gets the comuni by provincia.
	 *
	 * @param codProvincia the cod provincia
	 * @return the comuni by provincia
	 * @throws BEException the bE exception
	 */
	public List<Comune> getComuniByProvincia(String codProvincia) throws BEException{
		ArrayList<Comune> ris = new ArrayList<Comune>();
		if (codProvincia !=null && codProvincia.length()>0){
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Comune [] comuni = 
					srv.elencoComuni(codProvincia);
				if (comuni!=null){
					for(it.csi.sicee.siceeorch.dto.siceeorch.Comune currCom:comuni){
						Comune currRis = new Comune();
						currRis.setCod(currCom.getCod());
						currRis.setNome(currCom.getNome());
						ris.add(currRis);
					}
				}
				log.debug("Comuni trovati: " + ris.size());
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			}
		}
		
		return ris;
	}
	
	/**
	 * Gets the stampa dettaglio.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa dettaglio
	 */
	public ArrayList<LabelValue> getDettaglioAce(String numeroCertificato) {
		ArrayList<LabelValue> ret = new ArrayList<LabelValue>();
		try {

			String[] split = numeroCertificato.split(" ");
			
			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];
						
			it.csi.sicee.siceeorch.dto.siceeorch.LabelValue [] labelValueA = 
					srv.getDettaglioAce(numCertificatore, progrCertificato, annoCertificato);
				
			LabelValue currRis = null;
				if (labelValueA!=null){
					
					for (it.csi.sicee.siceeorch.dto.siceeorch.LabelValue labelValue : labelValueA) {
						currRis = new LabelValue();
						currRis.setLabel(labelValue.getLabel());
						currRis.setValue(labelValue.getValue());
						ret.add(currRis);
					}
					
					
				}

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Gets the elenco titoli.
	 *
	 * @return the elenco titoli
	 * @throws BEException the bE exception
	 */
	public List<Titolo> getElencoTitoli() throws BEException{
		ArrayList<Titolo> ris = new ArrayList<Titolo>();		
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Titolo [] titolo = 
					srv.elencoTitoli();
				if (titolo!=null){
					for(it.csi.sicee.siceeorch.dto.siceeorch.Titolo currTit:titolo){
						Titolo currRis = new Titolo();
						currRis.setCod(currTit.getIdTitolo());
						currRis.setNome(currTit.getDescrizione());
						ris.add(currRis);
					}
				}
				return ris;
			} catch (SystemException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			}
	}
	
	/**
	 * Gets the parametro.
	 *
	 * @param code the code
	 * @return the parametro
	 */
	public String getParametro(String code) {
		String value = null;
		try {
			value = srv.getParametro(code);
			
			log.debug("####STAMPO IL PARAMETRO: "+value);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return value;
	}
	
	/**
	 * Find ace.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the ace
	 * @throws BEException the bE exception
	 */
	public Ace findAce(String numeroCertificato)throws BEException{
		try {

			Ace ace = null;
			String[] s = numeroCertificato.split(" ");
			FiltroRicercaAce filtro = new FiltroRicercaAce();
			filtro.setNumero(s[Constants.PK_PROGR]);
			filtro.setAnno(s[Constants.PK_ANNO]);
			filtro.setCertificatore(s[Constants.PK_NUM_CERTIFICATORE]);

			List<Ace> aceList = findAce(filtro);
			
			// Sicuramente ci sara' un solo elemento
			if (aceList != null && aceList.size() == 1)
			{
				ace = aceList.get(0);
			}
			
			return ace;
		} catch (BEException e) {
			throw e;
		}
	}
	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAce(FiltroRicercaAce filtro) throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace ace = 
				srv.findAce(convertTo(filtro));
			if (ace != null) {
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
					ace.setCertificatore(cert.getMatricola());
					ace.setCognome(cert.getCognome());
					ace.setNome(cert.getNome());
				}
				
				GenericUtil.stampa(ace, true, 3);
				
				String uid = srv.findUidRifIndex(ace.getCertificatore(), ace.getNumero(), ace.getAnno(), Constants.ID_PDF_APE_FIRMATO);
				
				log.debug("STAMPO uid: "+uid);
				
				ace.setUid(uid);
				ret.add(convertTo(ace));
			}
			
			
			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAce:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAce:" + e, e);
		}
	}

	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public Integer findAceFiltroCount(FiltroRicercaAce filtro) throws BEException {
		Integer ret = null;
		try {
			
			ret = srv.findAceFiltroCount(this
					.convertTo(filtro), null, false, false);
			
			
			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAceFiltroCount:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAceFiltroCount:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAceFiltroCount:" + e, e);
		}
	}

	/**
	 * Find ace.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceFiltro(
			FiltroRicercaAce filtro)
			throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] aceList = srv.findAceFiltro(this
					.convertTo(filtro), null, false, false);
			if (aceList != null) {
				/*
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv
						.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
				*/
					for (it.csi.sicee.siceeorch.dto.siceeorch.Ace ace : aceList) {
						
						//ace.setCertificatore(cert.getMatricola());
						ret.add(this.convertTo(ace));
					}
					
				//}
				
			}

			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in findAceFiltro:" + e, e);
		}
	}
	
	/**
	 * Find ace sostitutivi.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Ace> findAceSostitutivi(String numeroCertificato) throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			String[] s = numeroCertificato.split(" ");
			FiltroRicercaAce filtro = new FiltroRicercaAce();
			filtro.setNumero(s[Constants.PK_PROGR]);
			filtro.setAnno(s[Constants.PK_ANNO]);
			filtro.setCertificatore(s[Constants.PK_NUM_CERTIFICATORE]);
			
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] ace = 
				srv.findAceSostitutivi(convertTo(filtro));
			if (ace != null) {
//				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv.findCertificatore(filtro.getCertificatore());
//				if (cert != null) {
//					ace.setCertificatore(cert.getMatricola());
//				}

				for (int i = 0; i < ace.length; i++) {
					ret.add(convertTo(ace[i]));	
				}
				
				
				
			}
			
			
			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
	}

	/**
	 * Convert to.
	 *
	 * @param ace the ace
	 * @return the ace
	 */
	private Ace convertTo(it.csi.sicee.siceeorch.dto.siceeorch.Ace ace) {
		Ace ret = new Ace();
		ret.setIndirizzo(Converter.convertToAddress(ace));
		ret.setCodice(ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero());
		ret.setAnno(ace.getAnno());
		ret.setCertificatore(ace.getCertificatore());
		ret.setNumero(ace.getNumero());
		ret.setDataInvio(convertToString(ace.getDataInvio()));
		ret.setUid(ace.getUid());
		ret.setCognome(ace.getCognome());
		ret.setNome(ace.getNome());
		ret.setDataUpload(convertToString(ace.getDataUpload()));
		ret.setFlgInviato("Scarica");
		ret.setFlgRicevuta("Scarica");
		ret.setIdStato(ace.getIdStato());
		ret.setDescStato(ace.getDescStato());
		ret.setDataScadenza(convertToString(ace.getDataScadenza()));
		
		return ret;
	}
	

	/**
	 * Find certificatore.
	 *
	 * @param matricola the matricola
	 * @return the certificatore
	 * @throws BEException the bE exception
	 */
	public Certificatore findCertificatore(String matricola) throws BEException {
		Certificatore ris = new Certificatore();		
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = 
				srv.findCertificatore(matricola);
			if (cert!=null){
				ris = convertTo(cert);
			}
			return ris;
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
		
		
	}
	
	/**
	 * Find elenco certificatore.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Certificatore> findElencoCertificatore(FiltroRicercaCertificatori filtro) throws BEException {
		ArrayList<Certificatore> ris = new ArrayList<Certificatore>();		
		try {
			log.debug("Cognome: " + filtro.getCognome());
			log.debug("Nome: " + filtro.getNome());
			
			
			
			it.csi.sicee.siceeorch.dto.siceeorch.Certificatore [] certRis = 
				srv.findElencoCertificatori(convertTo(filtro));
			
			
			if (certRis != null){
				log.debug("Certificatori trovati: " + certRis.length);
				for(it.csi.sicee.siceeorch.dto.siceeorch.Certificatore curr:certRis){					
					ris.add(convertTo(curr));
				}
			} else {
				log.debug("Certificatori NON trovati!");
			}
			
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
		
		return ris;
	}
	
	/**
	 * Convert to.
	 *
	 * @param filtro the filtro
	 * @return the it.csi.sicee.siceeorch.dto.siceeorch. filtro ricerca ace
	 */
	private it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce convertTo(FiltroRicercaAce filtro) {
		it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce ret = new it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce();
		
		log.debug("convertTo - inizio");
		ret.setAnno(filtro.getAnno());
		ret.setCertificatore(filtro.getCertificatore());
		ret.setNumero(filtro.getNumero());
		
		ret.setCodProv(filtro.getCodProv());
		//ret.setCodComune(filtro.getCodComune());
		
		if (!GenericUtil.isNullOrEmpty(filtro.getCodComune()))
		{
			log.debug("Setto il codComune: "+filtro.getCodComune());
			ret.setCodComune(filtro.getCodComune());
		}
		else
		{
			log.debug("Setto il descComune: "+filtro.getDescComune());

			ret.setDescComune(filtro.getDescComune());
		}
		
		ret.setDescIndirizzo(filtro.getDescIndirizzo());
		ret.setNumCivico(filtro.getNumCivico());
		ret.setSezione(filtro.getSezione());
		ret.setFoglio(filtro.getFoglio());
		ret.setParticella(filtro.getParticella());
		ret.setSubalterno(filtro.getSubalterno());
		ret.setStato(filtro.getStato());
		log.debug("convertTo - fine");
		
		return ret;
	}
	
	
	
	/**
	 * Convert to.
	 *
	 * @param filtro the filtro
	 * @return the it.csi.sicee.siceeorch.dto.siceeorch. filtro ricerca certificatori
	 */
	private it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaCertificatori convertTo(FiltroRicercaCertificatori filtro) {
		it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaCertificatori ret = new it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaCertificatori();
		ret.setCognome(toUpperCase(filtro.getCognome()));
		ret.setComune(filtro.getComune().trim());
		ret.setNome(toUpperCase(filtro.getNome()));
		ret.setProvincia(filtro.getProvincia().trim());
		ret.setRagioneSociale(toUpperCase(filtro.getRagioneSociale()));
		ret.setTitolo(filtro.getTitolo().trim());
		ret.setRegione(filtro.getRegione().trim());
		
		return ret;
	}
	
	/**
	 * Convert to.
	 *
	 * @param cert the cert
	 * @return the certificatore
	 */
	private Certificatore convertTo(it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert) {
		Certificatore ret = new Certificatore();
		
		ret.setCellulare(cert.getCellulare());
		ret.setCivico(cert.getCivico());
		ret.setCognome(cert.getCognome());
		ret.setComune(cert.getComune());
		ret.setEmail(cert.getEmail());
		ret.setMatricola(cert.getMatricola());
		ret.setNome(cert.getNome());
		ret.setProvincia(cert.getProvincia());
		ret.setRagioneSociale(cert.getRagioneSociale());
		ret.setTelefono(cert.getTelefono());
		ret.setTitolo(cert.getTitolo());
		ret.setIndirizzo(cert.getIndirizzo());
		ret.setUidCurriculum(cert.getUidCurriculum());
		ret.setEsameSostenuto(cert.getEsameSostenuto());
		ret.setSitoWeb(cert.getSitoWeb());
		
		return ret;
	}

	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public Documento recuperaDocumento(String uid) {
		Documento doc = null;
		try {
			doc = new Documento();
			doc.setUid(uid);
			doc = srv.ricercaDocumento(doc);
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		
		return doc;
	}
	
	/**
	 * Find notaio.
	 *
	 * @param email the email
	 * @return the it.csi.sicee.siceefree.dto.notaio. notaio
	 */
	public it.csi.sicee.siceefree.dto.notaio.Notaio findNotaio(String email) {
		it.csi.sicee.siceefree.dto.notaio.Notaio not = null;
		try {
			not = convertToNotaio(srv.findNotaio(email));
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return not;
	}

	/**
	 * Convert to notaio.
	 *
	 * @param not the not
	 * @return the it.csi.sicee.siceefree.dto.notaio. notaio
	 */
	private it.csi.sicee.siceefree.dto.notaio.Notaio convertToNotaio(it.csi.sicee.siceeorch.dto.siceeorch.Notaio not) {
		it.csi.sicee.siceefree.dto.notaio.Notaio ret = null;
		
		if (not != null) {
			ret = new it.csi.sicee.siceefree.dto.notaio.Notaio();			
			ret.setCodiceFiscale(not.getCodiceFiscale());
			ret.setCognome(not.getCognome());
			ret.setEmail(not.getEmail());
			ret.setIdNotaio(not.getId());
			ret.setNome(not.getNome());
		}
		
		return ret;
	}
	
	/**
	 * Update invio log.
	 *
	 * @param notaio the notaio
	 * @param ace the ace
	 * @return true, if successful
	 */
	public boolean updateInvioLog(it.csi.sicee.siceefree.dto.notaio.Notaio notaio, Ace ace) {
		try {
			log.debug("ace uid: "+ace.getUid());

			Documento doc = recuperaDocumento(ace.getUid());
			if (doc.getDoc() == null)
				return false;
			
			MailSender sender = new MailSender();
			it.csi.sicee.siceefree.util.Mail email = new it.csi.sicee.siceefree.util.Mail();
			email.setDestinatario(notaio.getEmail());
			
			email.setHost(Constants.MAIL_HOST);
			email.setPort(Constants.MAIL_PORT);
			
			email.setIdEmail(Constants.MAIL_USER);
			email.setPassword(Constants.MAIL_PWD);
			
			email.setMittente(getParametro(Constants.MAIL_MITT));
			
			email.setOggetto(creaOggettoEmail(notaio, ace));

			Protocollazione protocollazione = srv.findProtocollazione(ace.getCertificatore(), ace.getNumero(), ace.getAnno());

			if (protocollazione != null)
			{
				log.debug("Stampo obj.getNumeroProtocollo: "+protocollazione.getNumero());
				log.debug("Stampo obj.getTimestampProtocollo: "+protocollazione.getData());
				log.debug("Stampo obj.getVolume: "+protocollazione.getVolume());
				log.debug("Stampo obj.getTipoDocumentoActa: "+protocollazione.getTipoDoc());
				log.debug("Stampo obj.getMailInviata: "+protocollazione.getMail());
				
//				System.out.println("Stampo obj.getNumeroProtocollo: "+protocollazione.getNumero());
//				System.out.println("Stampo obj.getTimestampProtocollo: "+protocollazione.getData());
//				System.out.println("Stampo obj.getVolume: "+protocollazione.getVolume());
//				System.out.println("Stampo obj.getTipoDocumentoActa: "+protocollazione.getTipoDoc());
//				System.out.println("Stampo obj.getMailInviata: "+protocollazione.getMail());
				
			}
			else
			{
//				System.out.println("L'OGGETTO PROTOCOLLAZIONE E' NULLO!!!!!!!!!");
				log.debug("L'OGGETTO PROTOCOLLAZIONE E' NULLO!!!!!!!!!");
			}
				
			
			GenericUtil.stampa(protocollazione, true, 3);
			
			Integer codImpianto = null;
			List<Documento> docs = new ArrayList<>();
			docs.add(doc);

			try {
				codImpianto = srv.getCodImpiantoByApe(ace.getCertificatore(), ace.getNumero(), ace.getAnno());
				if(codImpianto != null) {
					Impianto[] impianti = srv.findImpiantoByCodice(codImpianto);
					log.debug("Impianti: " + impianti);
					if (impianti != null && impianti.length != 0) {
						log.debug("uid libretto: " + impianti[0].getUidIndexLibretto());
						if (impianti[0].getUidIndexLibretto() != null) {
							Documento doc2 = srv.findLibrettoByUID(impianti[0].getUidIndexLibretto());
							log.debug("DOC2: " + doc2);
							if (doc2 != null)
								docs.add(doc2);
						}
					}
				}
			}catch (Exception e){
				log.error("Impossibile recuperare il libretto impianto");
			}

			email.setHtml(creaHtmlEmail(notaio, ace, protocollazione,codImpianto));
			email.setTesto(creaTestoEmail(notaio, ace, protocollazione,codImpianto));

			byte[] ricevutaInvioByte = srv.getStampaRicevutaInvioAce(ace.getCertificatore(), ace.getNumero(), ace.getAnno());
			
			/*
			File ricevutaInvioFile = new File("ricevuta_trasmissione.pdf");

			OutputStream out;
			//out = new FileOutputStream(ricevutaInvioFile);
			out = new FileOutputStream("ricevuta_trasmissione.pdf");
			out.write(ricevutaInvioByte);

			out.close();
			*/
			
			try
			{
				sender.sendMail(email, docs, ricevutaInvioByte);
			}
			catch (Exception e) {
				// ho ricevuto un'eccezione nell'invio mail
				// provo a mandare la mail con il servizio siceews

				log.error("Errore nell'invio della mail", e);

				boolean isMailInviataService = sendMailService(email, docs, ricevutaInvioByte);
				
				if (!isMailInviataService)
				{
					// E' fallito l'invio mail anche del servizio
					return false;
				}
				
				log.debug("#### SONO DOPO LA MAIL");
			}
			
			//ddd
			
			InvioLog lg = new InvioLog();
			lg.setIdNotaio(notaio.getIdNotaio());
			lg.setAnno(ace.getAnno());			
			lg.setCertificatore("" + Integer.parseInt(ace.getCertificatore().substring(1)));
			lg.setNumero(ace.getNumero());
			
			//GenericUtil.stampa(lg, true, 2);
			
			
			if (srv.updateInvioLog(lg) == 1)
				return false;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			log.debug("#### SONO DOPO LA MAIL (ECCEZIONE)");

			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Crea html email.
	 *
	 * @param not the not
	 * @param ace the ace
	 * @return the string
	 */
	private String creaHtmlEmail(it.csi.sicee.siceefree.dto.notaio.Notaio not, Ace ace, Protocollazione protocollazione,Integer codiceImpianto) {
		String msg = null;
		
		
		try {
			String messaggio = srv.getParametro(Constants.TESTO_MAIL_NOTAIO_HTML);
			
			
			GenericUtil.stampa(ace, true, 2);
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_NOTAIO, not.getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_NOTAIO, not.getCognome());
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE, ace.getCodice());
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, ace.getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, ace.getCognome());
			
			messaggio = messaggio.replaceAll(Constants.PROTOCOLLO, creaTestoProtocollo(protocollazione));

			messaggio = codiceImpianto!=null? messaggio.replaceAll(Constants.CODICE_IMPIANTO,codiceImpianto.toString()):messaggio.replaceAll(Constants.CODICE_IMPIANTO,"-");

			messaggio = messaggio.replaceAll(Constants.DATA_INVIO, ace.getDataInvio());
			messaggio = messaggio.replaceAll(Constants.DATA_TRASMISSIONE, ace.getDataUpload());
			
			
			
			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		
		}
		return msg;
	}
	
	/**
	 * Crea testo email.
	 *
	 * @param not the not
	 * @param ace the ace
	 * @return the string
	 */
	private String creaTestoEmail(it.csi.sicee.siceefree.dto.notaio.Notaio not, Ace ace, Protocollazione protocollazione, Integer codiceImpianto) {
		String msg = null;
		
		
		
		try {
			String messaggio = srv.getParametro(Constants.TESTO_MAIL_NOTAIO_TXT);
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_NOTAIO, not.getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_NOTAIO, not.getCognome());
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE, ace.getCodice());
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, ace.getNome());
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, ace.getCognome());
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO, ace.getDataInvio());
			messaggio = codiceImpianto!=null? messaggio.replaceAll(Constants.CODICE_IMPIANTO,codiceImpianto.toString()):messaggio.replaceAll(Constants.CODICE_IMPIANTO,"-");

			//messaggio = messaggio.replaceAll(Constants.DATA_TRASMISSIONE, ace.getDataUpload());
			
			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		
		}
		return msg;
	}
	
	/**
	 * Crea oggetto email.
	 *
	 * @param not the not
	 * @param ace the ace
	 * @return the string
	 */
	private String creaOggettoEmail(it.csi.sicee.siceefree.dto.notaio.Notaio not, Ace ace) {
		String msg = null;
		
		
		try {
			String messaggio = srv.getParametro(Constants.OGGETTO_MAIL_NOTAIO);
			
			messaggio = messaggio.replaceAll(Constants.CODICE_ACE, ace.getCodice());			
			messaggio = messaggio.replaceAll(Constants.DATA_INVIO, ace.getDataInvio());			
			
			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		
		}
		return msg;
		
	}
	
	private String creaTestoProtocollo(Protocollazione protocollazione) {
		String msg = null;
		
		try {
			if (protocollazione != null)
			{
				StringBuffer messaggio = new StringBuffer("Protocollato da Regione Piemonte in data ");
				
				messaggio.append(Converter.convertToString(protocollazione.getData()));
				messaggio.append(" con numero protocollo ");
				messaggio.append(protocollazione.getNumero());
				
				msg = messaggio.toString();
			}
			else
			{
				msg = "";
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		
		}
		return msg;
		
	}
	
	public boolean sendMailService(it.csi.sicee.siceefree.util.Mail emailVo,
			List<Documento> docs, byte[] ricevutaInvioByte) throws Exception{
		
		log.info("[SOAIntegrationMgr::sendMailService] START");

		boolean isMailInviata = false;
		try {
			log.info("Prima di getWSSicee");
			
//			boolean isAlive = getWSSicee().isAlive();
//
//			log.debug("isAlive: "+isAlive);

			it.csi.sicee.siceews.stubs.Mail mailService = new it.csi.sicee.siceews.stubs.Mail();
			
			mailService.setMittente(emailVo.getMittente());
			mailService.setDestinatario(emailVo.getDestinatario());
			mailService.setDestinatarioCC(emailVo.getDestinatarioCC());
			mailService.setOggetto(emailVo.getOggetto());
			mailService.setHtml(emailVo.getHtml());
			
			
			ArrayList<Allegato> elencoAllegati = new ArrayList<Allegato>();

			if (docs != null)
			{
				for(Documento doc:docs) {
					it.csi.sicee.siceews.stubs.Allegato allegatoApe = new Allegato();
					allegatoApe.setNomeFile(doc.getNome());
					allegatoApe.setContentType("application/pkcs7-mime");
					allegatoApe.setFile(doc.getDoc());
					elencoAllegati.add(allegatoApe);
				}
			}
			
			if (ricevutaInvioByte != null)
			{
				it.csi.sicee.siceews.stubs.Allegato allegatoRicevuta = new Allegato();
				allegatoRicevuta.setNomeFile("ricevuta_trasmissione.pdf");
				allegatoRicevuta.setContentType("application/pdf");
				allegatoRicevuta.setFile(ricevutaInvioByte);
				elencoAllegati.add(allegatoRicevuta);
			}
			
			if (elencoAllegati.size() > 0)
			{
				
				it.csi.sicee.siceews.stubs.Allegato[] elencoAllegatiNew = new it.csi.sicee.siceews.stubs.Allegato[elencoAllegati.size()]; 
				elencoAllegatiNew = elencoAllegati.toArray(elencoAllegatiNew);
				
				mailService.setElencoAllegati(elencoAllegatiNew);
			
			}

			isMailInviata = getWSSicee().invioMail(mailService);

			log.info("Dopo della chiamta SICEEWS");
			
		} catch (Exception e) {
			log.error("[SOAIntegrationMgr::sendMailService] - Errore nell'invio della mail", e);
			throw e;
		}
		finally {
			log.info("[SOAIntegrationMgr::sendMailService] END");
		}
		return isMailInviata;
	}
	
	public void insertLogAccesso(String codiceFiscale, String nome, String cognome, String ruolo) throws BEException {
		try {
			srv.insertLogAccesso(codiceFiscale, nome, cognome, ruolo);
		} catch (SiceesrvException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		}

	}

	public it.csi.sicee.siceeorch.dto.siceeorch.DettaglioGeografico[] getDettaglioGeoportale(String x, String y, String classe) throws CSIException, BEException {
		try {
			return srv.getDettaglioGeografico(x, y, classe);
		} catch (SiceesrvException e) {
			throw new BEException("Errore in getDettaglioGeoportale:" + e, e);
		}
	}
}
