package com.lexington.mc.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;
 
@FacesValidator("emailListValidator")
public class ValidateEmailList implements Validator{

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public ValidateEmailList() {
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

	
	
	 @Override
	   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		divideAndValidateEmails((String) value);

	   }
	

	public List<String> divideAndValidateEmails(String emails){
		List<String> items = new ArrayList<String>(Arrays.asList(emails.split("\\s*,\\s*")));
		for(String email : items){
			if(!validate(email)){
				  FacesMessage message = new FacesMessage(FacesUtil.getMessage("eEmail"));
	         message.setSeverity(FacesMessage.SEVERITY_ERROR);
	         throw new ValidatorException(message);
			}
		}
		return items;
	}

	public String prepareEmailBatch(String emails){
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
