package it.csi.sicee.siceefree.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "siceefree";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/
	// Add here your constants

	/** The rb. */
	private static java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("/META-INF/siceefree");

	/** The mail host. */
	public static String MAIL_HOST = rb.getString("mail.host");

	/** The mail port. */
	public static String MAIL_PORT = rb.getString("mail.port");

	/** The mail mitt. */
	public static String MAIL_MITT = "MITTENTE_EMAIL_NOTAIO";

	/** The siceews tenant username. */
	public static final String WS_SICEEWS_URL = rb.getString("siceefree.siceews.url");

	/** The Constant CARRIAGE_RETURN. */
	public static final String CARRIAGE_RETURN = "@cr@";

	/** The Constant NOME_NOTAIO. */
	public static final String NOME_NOTAIO = "@nome.notaio@";

	/** The Constant COGNOME_NOTAIO. */
	public static final String COGNOME_NOTAIO = "@cognome.notaio@";

	/** The Constant CODICE_ACE. */
	public static final String CODICE_ACE = "@codice.ace@";

	/** The Constant NOME_CERTIFICATORE. */
	public static final String NOME_CERTIFICATORE = "@nome.certificatore@";

	/** The Constant COGNOME_CERTIFICATORE. */
	public static final String COGNOME_CERTIFICATORE = "@cognome.certificatore@";

	/** The Constant PROTOCOLLAZIONE. */
	public static final String PROTOCOLLO = "@protocollo@";

	/** The Constant DATA_INVIO. */
	public static final String DATA_INVIO = "@data.invio@";

	/** The Constant DATA_TRASMISSIONE. */
	public static final String DATA_TRASMISSIONE = "@data.trasmissione@";

	/** The Constant TESTO_MAIL_NOTAIO_HTML. */
	public static final String TESTO_MAIL_NOTAIO_HTML = "TESTO_MAIL_NOTAIO_HTML";

	/** The Constant TESTO_MAIL_NOTAIO_TXT. */
	public static final String TESTO_MAIL_NOTAIO_TXT = "TESTO_MAIL_NOTAIO_TXT";

	/** The Constant OGGETTO_MAIL_NOTAIO. */
	public static final String OGGETTO_MAIL_NOTAIO = "OGGETTO_MAIL_NOTAIO";

	/** The Constant SICEEFREE. */
	public static final String SICEEFREE = "SICEEFREE";

	/** The Constant INVIATO. */
	public static final int INVIATO = 3;

	/** The Constant ANNULLATO. */
	public static final int ANNULLATO = 4;

	/** The Constant ANNULLATO. */
	public static final int ANNULLATO_BO = 8;

	// E' un codice convenzionale non inserito sul DB, mi serve per creare la query
	/** The Constant INVIATO_ANNULLATO. */
	public static final int INVIATO_ANNULLATO = 99;

	/** The numero max ace free. */
	public static String NUMERO_MAX_ACE_FREE = "NUMERO_MAX_ACE_FREE";

	/** The Constant PK_PROGR. */
	public static final int PK_PROGR = 2;

	/** The Constant PK_ANNO. */
	public static final int PK_ANNO = 0;

	/** The Constant PK_NUM_CERTIFICATORE. */
	public static final int PK_NUM_CERTIFICATORE = 1;

	public static final Integer ID_PDF_APE_CONSOLIDATO = 1;
	public static final Integer ID_PDF_APE_FIRMATO = 2;
	public static final Integer ID_PDF_INDICATORE_APE = 3;

	public static final String RUOLO_NOTAIO_LOG_ACCESSO = "SICEEFREE-NOTAIO";
	/*PROTECTED REGION END*/
}
