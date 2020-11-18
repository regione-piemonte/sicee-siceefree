/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceefree.business;

import it.csi.csi.pfh.FHResult;
import it.csi.csi.pfh.FunctHandler;
import it.csi.csi.util.Param;
import it.csi.csi.wrapper.CSIException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;




/**
 * The Class TavtCache.
 */
public class TavtCache implements FunctHandler {
	
	/** The cache. */
	static Map<SiceeorchCallKey, SiceeorchCallValue> cache = new HashMap<SiceeorchCallKey, SiceeorchCallValue>();

	/** The Constant TTL. */
	static final long TTL = 8 * 60 * 60 * 1000; // TTL = 1h

	/* (non-Javadoc)
	 * @see it.csi.csi.pfh.FunctHandler#doOnInvokeSynch(java.lang.String, it.csi.csi.util.Param[], it.csi.csi.pfh.FHResult, java.util.Hashtable, boolean)
	 */
	public FHResult doOnInvokeSynch(String methodName, Param[] params,
			FHResult prevres, Hashtable bag, boolean inPreChain)
			throws CSIException {
		if (mustCache(methodName)) {

			SiceeorchCallKey call = new SiceeorchCallKey(methodName, params);
			if (inPreChain) {
				SiceeorchCallValue cachedResult = cache.get(call);
				if (cachedResult != null) {
					// System.out.println("PDCache: found result for " + call);
					if ((System.currentTimeMillis() - cachedResult.birthTime) < TTL) {
						prevres.setResult(cachedResult.result);
						prevres.setSkipInvoke(true);
					} else
						cache.remove(call);
				}
				// else continue and call PA...
			}

			else { // post chain
				if (prevres.getException() == null) {
					// metti in cache il risultato
					// System.out.println("PDCache: caching result for " +
					// call);
					SiceeorchCallValue newVal = new SiceeorchCallValue(
							System.currentTimeMillis(), prevres.getResult());
					cache.put(call, newVal);
				}
			}
		}
		return prevres;
	}
	
	/**
	 * Must cache.
	 *
	 * @param methodName the method name
	 * @return true, if successful
	 */
	private boolean mustCache(String methodName) {
		if ("elencoComuni".equals(methodName)
				|| "elencoProvince".equals(methodName)
				|| "elencoRegioni".equals(methodName))
			return true;
		else
			return false;

	}
	
	/**
	 * The Class SiceeorchCallValue.
	 */
	class SiceeorchCallValue {
		
		/** The birth time. */
		public long birthTime;
		
		/** The result. */
		public Param result;

		/**
		 * Instantiates a new siceeorch call value.
		 *
		 * @param bt the bt
		 * @param p the p
		 */
		public SiceeorchCallValue(long bt, Param p) {
			birthTime = bt;
			result = p;
		}
	}

	/**
	 * The Class SiceeorchCallKey.
	 */
	class SiceeorchCallKey {
		
		/** The params key. */
		public String paramsKey;

		/**
		 * Instantiates a new siceeorch call key.
		 *
		 * @param methodName the method name
		 * @param params the params
		 */
		public SiceeorchCallKey(String methodName, Param[] params) {
			paramsKey += methodName;
			if (params != null && params.length > 0) {
				paramsKey += ":";
				String id = (String) (params[0].getValue());
				paramsKey += id;
			}
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SiceeorchCallKey) {
				SiceeorchCallKey other = (SiceeorchCallKey) obj;
				return paramsKey.equals(other.paramsKey);
			} else
				return false;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {

			return paramsKey.hashCode();
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return paramsKey;
		}

	}

}
