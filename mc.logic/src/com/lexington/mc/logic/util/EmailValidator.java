package com.lexington.mc.logic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class EmailValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}


	public List<String> divideAndValidateEmails(String emails) throws MessageException{
		List<String> items = new ArrayList<String>(Arrays.asList(emails.split("\\s*,\\s*")));
		for(String email : items){
			if(!validate(email))
				throw new MessageException("error", MessageException.ERROR,"eEmail");
		}
		return items;
	}

	public String prepareEmailBatch(String emails) throws MessageException{
		List<String> items=divideAndValidateEmails(emails);		
		return getBatchEmails(items);

	}


	public String getBatchEmails(List<String> items){
		String batchSet="";
		boolean first=true;
		for(String e: items){
			e="'"+e+"'";
			if(!first)
				batchSet+=", ";
			else{
				first=false;
			}
			batchSet+=e;
		}
		return batchSet;

	}
 
}
