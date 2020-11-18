/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceefree.business.facade;

import it.csi.sicee.siceefree.business.BEException;
import it.csi.sicee.siceefree.util.Constants;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseMgr.
 */
public class BaseMgr {
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");

	/** The Constant ONE_YEAR_MILLIS. */
	public static final long ONE_YEAR_MILLIS = 1000*60*60*24*365; 
		

	/**
	 * Adds the one year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected static String addOneYear(String base) throws BEException{
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.YEAR, 1);
		java.util.Date dt_after = cal_base.getTime();
		return convertToString(dt_after);
	}
	
	/**
	 * Adds the ten year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected String addTenYear(String base) throws BEException{
		if (base != null && !base.equals("")) {
			java.util.Date dt_base = convertToDate(base);
			Calendar cal_base = Calendar.getInstance();
			cal_base.setTime(dt_base);
			cal_base.add(Calendar.YEAR, 10);
			java.util.Date dt_after = cal_base.getTime();
			return convertToString(dt_after);
		} else {
			return null;
		}
	}
	
	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(java.util.Date dt) {
		if(dt != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(dt);
		}
		else
			return null;
	}

	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(String s) throws BEException {
		if(s != null && s.length()>0){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "+s, e);
			}
		}
		else
			return null;
	}
	
	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Boolean i) {
		if (i==null)
			return null;
		else {
			if (i)
				return "S";
			else
				return "N";
		}
			
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Integer i) {
		if (i==null)
			return null;
		else
			return Integer.toString(i); 
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Long i) {
		if (i==null)
			return null;
		else
			return Long.toString(i); 
	}
	
	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Double i) {
		if (i==null)
			return null;
		else
			return parseNumberFive(i); 
	}

	/**
	 * Convert to integer.
	 *
	 * @param s the s
	 * @return the integer
	 */
	public static Integer convertToInteger(String s) {
		if (s==null || s.length()==0)
			return null;
		else {
			try {
				return new Integer(Integer.parseInt(s)); 
			} catch (Exception e) {
				return null;
			} 
		}
	}
	
	/**
	 * Convert to double.
	 *
	 * @param s the s
	 * @return the double
	 */
	public Double convertToDouble(String s) {
		if (s==null || s.length()==0)
			return null;
		else {
			try {				
				return new Double(Double.parseDouble(s.replaceAll(",", "."))); 
			} catch (Exception e) {
				log.debug("Stringa da convertire in Double: " + s);
				return null;
			} 
		}
	}

	/**
	 * Convert to long.
	 *
	 * @param s the s
	 * @return the long
	 */
	public Long convertToLong(String s) {
		if (s==null || s.length()==0)
			return null;
		else
			try {
				return new Long(Long.parseLong(s)); 
			} catch (Exception e) {
				return null;
			} 
	}
	
	/**
	 * Convert to boolean.
	 *
	 * @param s the s
	 * @return the boolean
	 */
	public Boolean convertToBoolean(String s) {
		if (s==null || s.length()==0)
			return null;
		else
			try {
				if (s.equalsIgnoreCase("s"))
					return true;
				else
					return false;
			} catch (Exception e) {
				return null;
			} 
	}

	/**
	 * Instantiates a new base mgr.
	 */
	public BaseMgr() {
		super();
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	protected static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	protected boolean isNullOrEmpty(Double s) {
		return s == null;
	}
	
	/**
	 * Check valide number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[+]?\\d*$"))
				return true;
			else return false;
		}
		
		return false;
	}
	
	/**
	 * Check valide email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValideEmail(String email) {
		if (!isNullOrEmpty(email)) {
			if (email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*"))
				return true;
			else return false;
		}
		
		return false;
	}
	
	/**
	 * Check valide date.
	 *
	 * @param date the date
	 * @return true, if successful
	 */
	public static boolean checkValideDate(String date) {
		if (!isNullOrEmpty(date)) {
			if (date.matches("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$"))
				return true;
			else return false;
		}
		
		return false;
	}
	
	/**
	 * Check valide double with five decimal numbers.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideDoubleWithFiveDecimalNumbers(String num) {
		log.debug("Numero da validare: " + num);
		if (!isNullOrEmpty(num)) {
			if (num.matches("^(?=.*[0-9].*$)\\d{0,10}(?:\\,\\d{0,5})?$")) {
				log.debug("validato: " + num);
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	/**
	 * Parses the number for print.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberForPrint(Double d) {
		String str = "";
		DecimalFormat df = new DecimalFormat("############.##");
		if (d != null) {
			str = df.format(d);
		}
		
		return str;
	}
	
	/**
	 * Parses the number five for print.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberFiveForPrint(String d) {
		String str = "";
		Double num = convertToDouble(d);
		DecimalFormat df = new DecimalFormat("############.######");
		if (d != null) {
			str = df.format(num);
		}
		
		return str;
	}
	
	/**
	 * Parses the number five.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberFive(Double d) {
		String str = "";		
		DecimalFormat df = new DecimalFormat("############.######");
		if (d != null) {
			str = df.format(d);
		}
		
		return str;
	}
	
	/**
	 * To upper case.
	 *
	 * @param str the str
	 * @return the string
	 */
	protected String toUpperCase(String str) {
		return (str== null) ? null : str.toUpperCase().trim();
	}

}