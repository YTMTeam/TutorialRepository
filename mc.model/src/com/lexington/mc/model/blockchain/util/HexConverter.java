package com.lexington.mc.model.blockchain.util;


import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;




public class HexConverter {
	
	public String convertFromHex(String hexString) { 
		try {
			byte[] bytes = Hex.decodeHex(hexString.toCharArray());
			return (new String(bytes, "UTF-8"));
		} catch(UnsupportedEncodingException | DecoderException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertToHex(String normalString) {
		byte[] myBytes;
		try {
			myBytes = normalString.getBytes("UTF-8");
			return DatatypeConverter.printHexBinary(myBytes);	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
