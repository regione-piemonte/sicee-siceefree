
package it.csi.sicee.siceefree.presentation.siceefree.action;

/**
 * Eccezione rilanciatain caso di errori durante l'esecuzione della
 * catena di comandi.
 *
 */
public class CommandExecutionException extends Exception {
	public CommandExecutionException(String msg, Throwable nested) {
		super(msg, nested);
	}

	public CommandExecutionException(String msg) {
		super(msg);
	}
};
