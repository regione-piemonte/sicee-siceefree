/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceefree.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Converter.
 */
public class Converter {

	/** The Constant logger. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);
	
	/**
	 * Convert to address.
	 *
	 * @param ace the ace
	 * @return the string
	 */
	public static final String convertToAddress(
			it.csi.sicee.siceeorch.dto.siceeorch.Ace ace) {
		if (!GenericUtil.isNullOrEmpty(ace.getCivico())) {
			return ace.getIndirizzo() + ", " + ace.getCivico() + " - "
					+ ace.getComune() + " - (" + ace.getProvincia() + ")";
		}

		return ace.getIndirizzo() + " - " + ace.getComune() + " - ("
				+ ace.getProvincia() + ")";
	}
	
	
	
	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
			return sdf.format(dt);
		} else
			return null;
	}
	
	/**
	 * Convert to integer.
	 *
	 * @param st the st
	 * @return the integer
	 */
	public static Integer convertToInteger(String st) {
		if (!GenericUtil.isNullOrEmpty(st)) {
			
			log.debug("### DEVO CONVERTIRE: "+Integer.getInteger(st));
			return Integer.parseInt(st);
		} else
			return null;
	}
	
	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 */
	public static java.util.Date convertToDate(String s) {
		if (s != null && s.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				log.error("Errore", e);
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the boxed to primitive.
	 *
	 * @param boxed the boxed
	 * @return the boxed to primitive
	 */
	private static Class<?> getBoxedToPrimitive(Class<?> boxed)
	{
	  if (boxed.equals(java.lang.Boolean.class))
	  {
	   return boolean.class;
	  }
	  else
	  {
	    if (boxed.equals(java.lang.Byte.class))
	    {
	      return byte.class;
	    }
	    else
	    {
	      if (boxed.equals(java.lang.Character.class))
	      {
	        return char.class;
	      }
	      else
	      {
	        if (boxed.equals(java.lang.Double.class))
	        {
	         return double.class;
	        }
	        else
	        {
	          if (boxed.equals(java.lang.Float.class))
	          {
	            return float.class;
	          }
	          else
	          {
	            if (boxed.equals(java.lang.Integer.class))
	            {
	              return int.class;
	            }
	            else
	            {
	              if (boxed.equals(java.lang.Long.class))
	              {
	            	  return long.class;
	              }
	              else
	              {
	                if (boxed.equals(java.lang.Short.class))
	                {
	                	 return short.class;
	                } else
		              {
		                if (boxed.equals(java.sql.Timestamp.class))
		                {
		                	 return java.lang.String.class;
		                } else
			              {
			                if (boxed.equals(java.sql.Date.class))
			                {
			                	 return java.lang.String.class;
			                } else
			              {
				                if (boxed.equals(java.util.Date.class))
				                {
				                	 return java.lang.String.class;
				                }
				              }
			              }
		              }
	              }
	            }
	          }
	        }
	      }
	    }
	  }
	  return null;
	}
	

}
