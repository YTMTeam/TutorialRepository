package com.lexington.mc.logic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaFormatUtil {

   private final static String youtuBe       = "https://youtu.be/";
   private final static String primeYouTube  = "http://www.youtube.com/v/";
   private final static String primeYouTube2 = "http://www.youtube.com/v/";

   public static void main(String[] args) throws MessageException {

      MediaFormatUtil m = new MediaFormatUtil();
      String youtuBe = "https://youtu.be/";
      System.out.println(m.getYouTubeIdOnly("http://www.youtube.com/?feature=player_embedded&v=dQw4w9WgXcQ"));
      System.out.println(m.getYouTubeIdOnly("https://www.youtube.com/watch?v=KZnUr8lcqjo&feature=player_embedded"));
      System.out.println(m.getYouTubeIdOnly("https://youtu.be/KZnUr8lcqjo"));
      String link = "https://youtu.be/KZnUr8lcqjo";

      if (link.startsWith(youtuBe))
         ;
      System.out.println(link.substring(youtuBe.length(), link.length()));

   }

   public static String getYouTubeIdOnly(String link) throws MessageException {

      if (link.length() == 11)
         return link;

      if (link.startsWith(primeYouTube))
         return link.substring(primeYouTube.length(), link.length());

      if (link.startsWith(primeYouTube2))
         return link.substring(primeYouTube2.length(), link.length());

      if (link.startsWith(youtuBe))
         return link.substring(youtuBe.length(), link.length());

      Pattern compiledPattern = Pattern.compile("(?<=v=).*?(?=&|$)", Pattern.CASE_INSENSITIVE);
      Matcher matcher = compiledPattern.matcher(link);
      if (matcher.find()) {
         return matcher.group();
      }
      throw new MessageException("error", MessageException.WARN, "incorrectYoutube");
   }

   //	public static String getYouTubeIdOnly2(String url){
   //	
   //	String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
   //
   //    Pattern compiledPattern = Pattern.compile(pattern);
   //    Matcher matcher = compiledPattern.matcher(url);
   //
   //    if(matcher.find()){
   //        return matcher.group();
   //    }
   //	
   //	return "";
   //	}

}
