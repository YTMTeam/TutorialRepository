package com.lexington.mc.webview.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
   public static String getFileExt(String input) {
      /*
        Regex: (?<=\\.).*$
        1.)     (?<=\\.)    means       lookbehind excluding "." and add
        2.)     .*          means       every character until
        3.)     $           meabs       end of string
       */
      String regex = "(?<=\\.).*$";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(input);
      String output = "";
      if (matcher.find()) {
         output = matcher.group();
      }
      return output;
   }
}
