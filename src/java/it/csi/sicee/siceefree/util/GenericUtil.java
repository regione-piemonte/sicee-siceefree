/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceefree.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import it.csi.sicee.siceefree.dto.ace.Ace;


// TODO: Auto-generated Javadoc
/**
 * The Class GenericUtil.
 */
public class GenericUtil {

	/** The Constant BEGIN. */
	static final int BEGIN = 1;

	/** The Constant END. */
	static final int END = 2;

	/** The Constant VALUE. */
	static final int VALUE = 3;

	/** The Constant TEST. */
	static final int TEST = 4;

	/** The Constant SIMPLE. */
	static final int SIMPLE = 5;

	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param testName
	 *            the test name
	 */
	public static void stampa(Object o, boolean useLog4j, int depth,
			String testName) {
		try {
			if (useLog4j) {
				log.debug(testName + " BEGIN");
			} else {
				System.out.println(testName + " BEGIN");
			}
			if (o != null) {
				if (o.getClass().isArray()) {
					Object[] a = (Object[]) o;
					stampa(a, useLog4j, depth);
				} else {
					stampa(o, useLog4j, depth);
				}
			}
			if (useLog4j) {
				log.debug(testName + " END");
			} else {
				System.out.println(testName + " END");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	public static void stampa(Object o, boolean useLog4j, int depth) {

		try {
			if (o == null) {
				print(o, null, useLog4j, depth, BEGIN);
			} else {
				if (o instanceof String) {
					print(o, o, useLog4j, depth, SIMPLE);
				} else {
					print(o, null, useLog4j, depth, BEGIN);
					callGetMethods(o, useLog4j, depth + 1);
					print(o, null, useLog4j, depth, END);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Prints the.
	 * 
	 * @param o
	 *            the o
	 * @param value
	 *            the value
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param type
	 *            the type
	 * @throws Exception
	 *             the exception
	 */
	private static void print(Object o, Object value, boolean useLog4j,
			int depth, int type) throws Exception {

		StringBuffer tab = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			tab.append("\t");
		}
		if (o != null) {
			String className = o.getClass().getName();
			switch (type) {
			case BEGIN:
				tab.append(className);
				tab.append(" BEGIN");
				break;
			case END:
				tab.append(className);
				tab.append(" END");
				break;
			case VALUE:
				tab.append(((Method) o).getName());
				tab.append(" == ");
				tab.append(value);
				break;
			case SIMPLE:
				tab.append(o);
				tab.append(" == ");
				tab.append(value);
				break;
			default:

			}
		} else if (type == TEST) {
			tab.append("");
		} else {
			tab.append("Oggetto nullo!!");
		}

		if (useLog4j) {
			log.debug(tab);
		} else {
			System.out.println(tab);
		}

	}

	/**
	 * Call get methods.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	private static void callGetMethods(Object o, boolean useLog4j, int depth) {
		try {
			Method[] meth = o.getClass().getDeclaredMethods();
			for (int i = 0; i < meth.length; i++) {
				Method thisM = meth[i];
				if (thisM.getName().startsWith("get")) {
					if (!thisM.getName().equals("get")) {
						Object result = thisM.invoke(o, new Object[] {});
						if (result != null && result.getClass().isArray()) {
							Object[] a = (Object[]) result;
							stampa(a, useLog4j, depth);
						} else {
							print(thisM, result, useLog4j, depth, VALUE);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @throws Exception
	 *             the exception
	 */
	public static void stampa(Object[] o, boolean useLog4j, int depth)
			throws Exception {
		String className = o.getClass().getSimpleName();
		for (int i = 0; i < o.length; i++) {
			stampa(o[i], false, depth);
		}

		if (o.length == 0) {
			System.out.println(className + " vuoto");
		}

	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean s) {
		return s == null;
	}

	/**
	 * Checks if is true.
	 * 
	 * @param esameSostenuto
	 *            the esame sostenuto
	 * @return true, if is true
	 */
	public static boolean isTrue(String esameSostenuto) {
		if (esameSostenuto.equalsIgnoreCase("s")) {
			return true;
		}
		return false;
	}

	public static boolean checkValideSixNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{6}"))
				return true;
			else
				return false;
		}

		return false;
	}

	public static boolean checkValideFourNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{4}"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	public static boolean isCertificatoPresente(String idCertificato, ArrayList<Ace> attestatoList) {
		boolean isPresente = false;

		if (idCertificato != null && idCertificato != null) {
			for (Ace ace : attestatoList) {

				if (idCertificato.equals(ace.getCodice())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}

}