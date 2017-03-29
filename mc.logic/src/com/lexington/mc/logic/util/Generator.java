package com.lexington.mc.logic.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class Generator {
   public static void main(String[] args) {
      Generator g = new Generator();
      for (int i = 0; i < 100; i++) {

         System.out.println(g.generateCaptcha());

      }

   }

   /**
    * generate not encrypted password (big letter, small letter, number, sign)
    * @return
    */
   public String generatePass() {
      RandomStringUtils random = new RandomStringUtils();
      String pass = random.random(5, 65, 91, true, false)
                    + random.random(5, 48, 58, false, true)
                    + random.random(2, 35, 39, false, false)
                    + random.random(5, 97, 123, true, false);
      pass = shuffle(pass);
      return pass;
   }

   private String shuffle(String input) {
      List<Character> characters = new ArrayList<Character>();
      for (char c : input.toCharArray()) {
         characters.add(c);
      }
      StringBuilder output = new StringBuilder(input.length());
      while (characters.size() != 0) {
         int randPicker = (int) (Math.random() * characters.size());
         output.append(characters.remove(randPicker));
      }
      return output.toString();
   }

   //generate random encrypted password
   public String generateEncPass() {
      String notEncPass = generatePass();
      BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
      return passwordEncryptor.encryptPassword(notEncPass);

   }

   //encrypt password
   public String encryptPassword(String notEncPass) {
      BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
      return passwordEncryptor.encryptPassword(notEncPass);

   }
   
   
   public String generateCaptcha(){
	   RandomStringUtils random = new RandomStringUtils();
	      String pass = random.random(3, 65, 91, true, false)
	    		  + random.random(2, 48, 58, false, true);
	      pass = shuffle(pass);
	      return pass;
	   
   }
}
