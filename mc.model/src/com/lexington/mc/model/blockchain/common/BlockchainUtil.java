package com.lexington.mc.model.blockchain.common;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class BlockchainUtil {
		
	/**
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static RpcParameters getRpcParameters(String file) {
		String method = "getRpcParameters";
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(RpcParameters.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RpcParameters rpcParameters = (RpcParameters) jaxbUnmarshaller
					.unmarshal(new File(file));
			return rpcParameters;
		} catch (JAXBException e) {
			return null;		}
	}
	}
