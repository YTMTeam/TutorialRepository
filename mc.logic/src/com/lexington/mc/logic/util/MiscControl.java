package com.lexington.mc.logic.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class MiscControl {

   public static void main(String args[]) {
      List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal("100.12"), new BigDecimal("100.44"), new BigDecimal("100.50"),
            new BigDecimal("100.75"));
      for (final BigDecimal bd : bigDecimals) {
         System.out.println(roundDoubleToCloserLong(bd.doubleValue()));
      }
      System.out.println(new BigDecimal("100.12").longValue());
      System.out.println(new BigDecimal("100.51").longValue());

   }

   /**
    * 
    * @param input
    * @param delimiter
    * @return
    */
   public static List<String> getDivideStringToArray(String input, String delimiter) {
      List<String> res = Arrays.asList(input.split("\\s*" + delimiter + "\\s*"));
      return res;

   }

   public static String doubleTwoDecFormat(double number) {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(2);
      return df.format(number);

   }

   public static String doubleOneDecFormat(double number) {
      DecimalFormat df = new DecimalFormat();
      df.setMaximumFractionDigits(1);
      return df.format(number);

   }

   public static long roundDoubleToCloserLong(double d) {
      double dAbs = Math.abs(d);
      long i = (long) dAbs;
      double result = dAbs - (double) i;
      if (result < 0.5) {
         return d < 0 ? -i : i;
      } else {
         return d < 0 ? -(i + 1) : i + 1;
      }
   }

   /**
    * 100.4->100
    * 100.5->101
    * 100.6->101
    * @param input
    * @return
    */
   public static BigDecimal roundBigDecToCloserInt(BigDecimal input) {
      return input.setScale(0, RoundingMode.HALF_UP);
      //	    return input.round(
      //	        new MathContext(
      //	            input.toBigInteger().toString().length(),
      //	            RoundingMode.HALF_UP
      //	        )
      //	    );
   }

   public static String getPlainText(String html) {
      if (html == null)
         return null;
      return Jsoup.clean(html, Whitelist.simpleText());
   }

   public static String getPlainTextAndStrip(String html) {
      if (html == null)
         return null;
      String qText = getPlainText(html);
      qText = qText.replaceAll("&" + "nbsp;", "");
      qText = qText.replaceAll(String.valueOf((char) 160), "").trim();
      return qText;
   }

   public static boolean isPlainTextEmpty(String html) {
      if (html == null)
         return true;
      String qText = getPlainText(html);
      qText = qText.replaceAll("&" + "nbsp;", "");
      qText = qText.replaceAll(String.valueOf((char) 160), "").trim();
      return qText.equals("");
   }

   /**
    * divides two big decimals, and return big decimal with two decimal digits. Avoid exception
    * @param dividor
    * @param divisor
    * @return
    */
   public static BigDecimal divideBigDec(BigDecimal dividor, BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO))
         return BigDecimal.ZERO;
      double result = dividor.doubleValue() / divisor.doubleValue();
      BigDecimal res = new BigDecimal(result);
      res = res.setScale(2, BigDecimal.ROUND_HALF_UP);
      return res;
   }

   /**
      * <p>Gets the substring before the last occurrence of a separator.
      * The separator is not returned.</p>
      *
      * <p>A <code>null</code> string input will return <code>null</code>.
      * An empty ("") string input will return the empty string.
      * An empty or <code>null</code> separator will return the input string.</p>
      *
      * <pre>
      * StringUtils.substringBeforeLast(null, *)      = null
      * StringUtils.substringBeforeLast("", *)        = ""
      * StringUtils.substringBeforeLast("abcba", "b") = "abc"
      * StringUtils.substringBeforeLast("abc", "c")   = "ab"
      * StringUtils.substringBeforeLast("a", "a")     = ""
      * StringUtils.substringBeforeLast("a", "z")     = "a"
      * StringUtils.substringBeforeLast("a", null)    = "a"
      * StringUtils.substringBeforeLast("a", "")      = "a"
      * </pre>
      *
      * @param str  the String to get a substring from, may be null
      * @param separator  the String to search for, may be null
      * @return the substring before the last occurrence of the separator,
      *  <code>null</code> if null String input
      * @since 2.0
      */
   public static String substringBeforeLast(String str, String separator) {
      if (isEmpty(str) || isEmpty(separator)) {
         return str;
      }
      int pos = str.lastIndexOf(separator);
      if (pos == -1) {
         return str;
      }
      return str.substring(0, pos);
   }

   // Empty checks
   //-----------------------------------------------------------------------
   /**
    * <p>Checks if a String is empty ("") or null.</p>
    *
    * <pre>
    * StringUtils.isEmpty(null)      = true
    * StringUtils.isEmpty("")        = true
    * StringUtils.isEmpty(" ")       = false
    * StringUtils.isEmpty("bob")     = false
    * StringUtils.isEmpty("  bob  ") = false
    * </pre>
    *
    * <p>NOTE: This method changed in Lang version 2.0.
    * It no longer trims the String.
    * That functionality is available in isBlank().</p>
    *
    * @param str  the String to check, may be null
    * @return <code>true</code> if the String is empty or null
    */
   public static boolean isEmpty(String str) {
      return str == null || str.length() == 0;
   }

   
   
   
   public static boolean nullSafeStringComparator(final String one, final String two) {
	   

	    if (one == null && two == null) {
	        return true;
	    }
	    
	    if(one == null || two == null)
	    	return false;

	    return one.equals(two);
	}
   
}
