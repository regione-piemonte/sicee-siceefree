/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/**
 * 
 */
package it.csi.sicee.siceefree.util;

import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * The Class MailSender.
 * 
 * @author 70140
 */
public class MailSender implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3596869004264743871L;

	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");

	/**
	 * Send mail.
	 * 
	 * @param emailVo
	 *            the email vo
	 * @param doc
	 *            the doc
	 * @param ricevutaInvio
	 *            the ricevuta invio
	 * @throws Exception
	 *             the exception
	 */
	public void sendMail(it.csi.sicee.siceefree.util.Mail emailVo,
			List<Documento> docs, byte[] ricevutaInvioByte) throws Exception {
		log.debug("[MailSender::sendMail] BEGIN");
		// GenericUtil.stampaVO(emailVO);
		// Create a mail session
		
		File allegato = null;
		File ricevuta = null;
		
		try {
			java.util.Properties props = new java.util.Properties();
//			props.put("mail.smtp.host", emailVo.getHost());
//			props.put("mail.smtp.port", emailVo.getPort());
//			props.put("mail.debug", "true"); // Aggiunto per verifica problema della Mail

			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", emailVo.getHost());
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", emailVo.getPort());
			props.put("mail.smtp.starttls.enable", "true");

			//create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailVo.getIdEmail(), emailVo.getPassword());
				}
			};
			
			Session session=Session.getInstance(props,auth);
			
//			Session session = Session.getDefaultInstance(props, null);
			//Session session = Session.getInstance(props, null);

			// Construct the message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(emailVo.getMittente()));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					emailVo.getDestinatario()));
			if (StringUtils.isNotEmpty(emailVo.getDestinatarioCC())) {
				msg.setRecipient(Message.RecipientType.CC, new InternetAddress(
						emailVo.getDestinatarioCC()));
			}
			msg.setSubject(emailVo.getOggetto());
			MimeMultipart mp = new MimeMultipart();

			MimeBodyPart html = new MimeBodyPart();
			html.setText(emailVo.getTesto());
			html.setContent(emailVo.getHtml(), "text/html");

			// create and fill the second message part
			if (docs != null) {
				// JIRA SICEE-515
				for(Documento doc:docs) {
					MimeBodyPart attachmentPart = new MimeBodyPart();
					log.debug("DOCS SISE: "+docs.size());
					if(doc.getDoc()!=null && doc.getNome()!=null) {
						allegato = createFileWithData(doc);
						FileDataSource fileDataSource = new FileDataSource(allegato) {
							@Override
							public String getContentType() {
								return "application/pkcs7-mime";
							}
						};
						attachmentPart.setDataHandler(new DataHandler(fileDataSource));
						attachmentPart.setFileName(doc.getNome());
						mp.addBodyPart(attachmentPart);
					}
				}
			}
			// create the Multipart and its parts to it

			// create and fill the second message part
			if (ricevutaInvioByte != null) {
				MimeBodyPart attachmentPart = new MimeBodyPart();
//				JIRA SICEE-515
				ricevuta = createFileWithData("ricevuta_trasmissione.pdf", ricevutaInvioByte);
				
				FileDataSource fileDataSource = new FileDataSource(ricevuta) {
					@Override
					public String getContentType() {
						return "application/pdf";
					}
				};
				attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				attachmentPart.setFileName("ricevuta_trasmissione.pdf");
				mp.addBodyPart(attachmentPart);
			}
			// create the Multipart and its parts to it

			// mp.addBodyPart(text);
			mp.addBodyPart(html);

			
			// add the Multipart to the message
			msg.setContent(mp);

			// 18/06/19 SICEE 10.0.0
			// Codice inserito per (cercare di) risolvere il problema dell'invio mail - inizio
			gestisciMimeTypes();
			// Codice inserito per (cercare di) risolvere il problema dell'invio mail - fine

			/*
			// PROVA - Beppe - inizio
			
			log.debug("[MailSender::sendMail] - stampo il ContextClassLoader - prima: "+Thread.currentThread().getContextClassLoader());
			Thread.currentThread().setContextClassLoader(null);
			
			log.debug("[MailSender::sendMail] - stampo il ContextClassLoader - dopo: "+Thread.currentThread().getContextClassLoader());
			
			log.debug("[MailSender::sendMail] - stampo il javax.mail.Message.class.getClassLoader: "+javax.mail.Message.class.getClassLoader());

			log.debug("[MailSender::sendMail] - stampo il this.getClass().getClassLoader(): "+this.getClass().getClassLoader());
			
			// PROVA - Beppe - fine
			*/
			
			// Aggiunto questo comando per risolvere il problema di invio mail
			
			log.info("[MailSender::sendMail] - stampo il ContextClassLoader - NEW: "+Thread.currentThread().getContextClassLoader());
			if (Thread.currentThread().getContextClassLoader() == null)
			{
				log.info("[MailSender::sendMail] - stampo il this.getClass().getClassLoader(): "+this.getClass().getClassLoader());

				Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
				
				log.info("[MailSender::sendMail] - stampo il ContextClassLoader - dopo: "+Thread.currentThread().getContextClassLoader());
			}
			// Send the message
			Transport.send(msg);
			
		} catch (Exception e) {
			log.error("Errore nell'invio della mail", e);
			throw e;
		} finally {
//			JIRA SICEE-515
			if (allegato != null && allegato.exists()) {
				boolean isDelete = allegato.delete();
				
				if (log.isDebugEnabled()) {					
					log.debug("[MailSender::sendMail] "+allegato+": file.delete(): "+isDelete);
				}
			}
			
			if (ricevuta != null && ricevuta.exists()) {
				boolean isDelete = ricevuta.delete();
				
				if (log.isDebugEnabled()) {					
					log.debug("[MailSender::sendMail] "+ricevuta+": file.delete(): "+isDelete);
				}
			}
			
			log.debug("[MailSender::sendMail] END");
		}

	}
	
	private static File createFileWithData(String nome, byte[] doc) throws IOException
	{
		int pos = nome.lastIndexOf(".");
		File file = File.createTempFile(nome, nome.substring(pos));
//		file.deleteOnExit();
		OutputStream src = new FileOutputStream(file);
		src.write(doc);
		src.close();
		return file;
	}
	
	/**
	 * Creates the file with data.
	 * 
	 * @param doc
	 *            the doc
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private File createFileWithData(Documento doc) throws IOException {

		return createFileWithData(doc.getNome(), doc.getDoc());
//		int pos = doc.getNome().lastIndexOf(".");
//		File file = File.createTempFile(doc.getNome(),
//				doc.getNome().substring(pos));
//		file.deleteOnExit();
//		OutputStream src = new FileOutputStream(file);
//		src.write(doc.getDoc());
//		src.close();
//		return file;
	}
	
	private static void gestisciMimeTypes()
	{
	    MailcapCommandMap mc = (MailcapCommandMap) CommandMap
	            .getDefaultCommandMap();

	    boolean isTextHtml = false;
	    boolean isTextXml = false;
	    boolean isTextPlain = false;
	    boolean isMultipartAll = false;
	    boolean isMessageRfc822 = false;

	    
	    String[] mimeTypes = mc.getMimeTypes();
	    log.debug("###########################");
	    log.debug("STAMPO I MIMETYPES - INIZIO");
	    log.debug("STAMPO I MIMETYPE array: "+mimeTypes);
	    
	    for (String mimeType : mimeTypes) {
			log.debug("STAMPO IL MIMETYPE (prima): *"+mimeType+"*");

			if (mimeType.equals("text/html"))
			{
				isTextHtml = true;
			}
			
			if (mimeType.equals("text/xml"))
			{
				isTextXml= true;
			}
			
			if (mimeType.equals("text/plain"))
			{
				isTextPlain = true;
			}
			
			if (mimeType.equals("multipart/*"))
			{
				isMultipartAll = true;
			}

			if (mimeType.equals("message/rfc822"))
			{
				isMessageRfc822 = true;
			}
			
	    }

	    if (!isTextHtml)
	    {
			log.info("MIMETYPE NON PRESENTE: text/html - l'aggiungo");
		    mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		}
	    
	    if (!isTextXml)
	    {
			log.info("MIMETYPE NON PRESENTE: text/xml - l'aggiungo");
		    mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		}
	    
	    if (!isTextPlain)
	    {
			log.info("MIMETYPE NON PRESENTE: text/plain - l'aggiungo");
		    mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		}
	    
	    if (!isMultipartAll)
	    {
			log.info("MIMETYPE NON PRESENTE: multipart/* - l'aggiungo");
		    mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		}
	    
	    if (!isMessageRfc822)
	    {
			log.info("MIMETYPE NON PRESENTE: message/rfc822 - l'aggiungo");
		    mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		}
	    
	    if (!isTextHtml || !isTextXml || !isTextPlain || !isMultipartAll || !isMessageRfc822)
	    {
	    	log.info("MANCA QUALCHE MIMETYPE");

	    	CommandMap.setDefaultCommandMap(mc);

	    	log.info("STAMPO I MIMETYPES - DOPO SETTAGGIO");

	    	String[] mimeTypesNew = mc.getMimeTypes();

	    	for (String mimeType : mimeTypesNew) {
	    		log.info("STAMPO IL MIMETYPE (dopo): *"+mimeType+"*");

	    	}
	    }
	    else
	    {
	    	log.info("TUTTI I MIMETYPE SONO PRESENTI");
	    }
	    
	    log.debug("STAMPO I MIMETYPES - FINE");
	    log.debug("###########################");
	}
	
	

	

}
