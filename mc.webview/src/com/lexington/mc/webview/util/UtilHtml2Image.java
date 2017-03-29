package com.lexington.mc.webview.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Entities.EscapeMode;
import org.w3c.dom.Document;
import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.swing.NaiveUserAgent;
import org.xml.sax.InputSource;

import com.lexington.mc.webview.jasper.util.ImageLink;

public class UtilHtml2Image extends NaiveUserAgent {
   public String prepareHtml(String plainHtml) {
      plainHtml = "<div style=\"width:400px;\">" + plainHtml + "</div>";
      String imgReady = "";
      for (int i = 0; i < plainHtml.length(); i++) {
         char c = plainHtml.charAt(i);
         if (c == '"') {
            imgReady += "\\";
         }
         imgReady += c;
      }
      System.out.println(imgReady);

      return imgReady;
   }

   public String prepareHtmlWithSoap(String plainHtml) {
      org.jsoup.nodes.Document doms = Jsoup.parseBodyFragment(plainHtml);
      doms.outputSettings().escapeMode(EscapeMode.xhtml); // avoid transformin the characters '<' and '>' as its html characters codes like &gt; and &lt;
      return doms.toString();
   }

   public Document createDocumentFromXMLString(String xml) throws Exception {
      DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
      fac.setNamespaceAware(false);
      fac.setValidating(false);
      fac.setFeature("http://xml.org/sax/features/namespaces", false);
      fac.setFeature("http://xml.org/sax/features/validation", false);
      fac.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
      fac.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
      DocumentBuilder builder = fac.newDocumentBuilder();
      InputSource is = new InputSource(new StringReader(xml));
      return builder.parse(is);
   }

   public BufferedImage createImage(String plainHtml) {
      //	System.out.println("Before soap:"+ plainHtml);
      String soapReady = prepareHtmlWithSoap(plainHtml);
      //	System.out.println("After soap:"+ soapReady);
      Document flyDoc = null;
      try {
         flyDoc = createDocumentFromXMLString(soapReady);
      } catch (Exception e) {
         e.printStackTrace();
      }
      //		System.out.println("After doc:"+ flyDoc.toString());
      Java2DRenderer renderer = new Java2DRenderer(flyDoc, 900, -1);
      return renderer.getImage();
      //renderer.getSharedContext().setUserAgentCallback(new YourURLResolverNaiveUserAgentCallback());

   }

   //<img alt="" src="http://www.primefaces.org/showcase-labs/images/logo.png" style="height:90px; width:380px" />
   public String removeImageLinks(String html, ArrayList<ImageLink> imageLinks) {
      System.out.println("Html before removing images: " + html);
      String imageLink = "";
      String withoutImg = "";
      int order = 1;
      boolean linkend = false;
      for (int i = 0; i < html.length(); i++) {
         String tmp = "";
         char c = html.charAt(i);
         if (c == '<') {
            tmp += c;//add <
            c = html.charAt(++i);
            tmp += c;//add next
            if (c == 'i' && i < html.length()) { //next was i
               c = html.charAt(++i);
               tmp += c; //add next
               if (c == 'm' && i < html.length()) { //next was m
                  c = html.charAt(++i);
                  tmp += c; //add next
                  if (c == 'g' && i < html.length()) { //next was g
                     tmp = "";//we have found the tag
                     i++;
                     while (i < html.length()) {
                        c = html.charAt(++i);
                        if (c == 's' && i < html.length()) {
                           c = html.charAt(++i);
                           if (c == 'r' && i < html.length()) {
                              c = html.charAt(++i);

                              if (c == 'c' && i < html.length()) {
                                 c = html.charAt(++i);
                                 if (c == '=' && i < html.length()) {
                                    c = html.charAt(++i);
                                    if (c == '"' && i < html.length()) {
                                       //imageLink+=c;
                                       c = html.charAt(++i);
                                       while (c != '"' && i < html.length()) {
                                          imageLink += c;

                                          c = html.charAt(++i);
                                       }
                                       //imageLink+=c;
                                       System.out.println(imageLink);
                                       BufferedImage img = getImageFromUrl(imageLink);
                                	   if (img != null) {
                                		   imageLinks.add(new ImageLink(img, ++order));
									   }
                                       withoutImg += "<b> " + FacesUtil.getMessage("picture") + " " + order + ". </b>";
                                       imageLink = "";
                                       linkend = true;
                                    }
                                 }
                              }
                           }
                        }
                        if (c == '/' && i < html.length()) {
                           c = html.charAt(++i);
                           if (c == '>' && i < html.length()) {

                              break; //image end

                           }
                        }

                     }
                  }
               }
            }

         }
         if (!linkend) {
            if (tmp != "")
               withoutImg += tmp;
            else
               withoutImg += c;
         }
         linkend = false;
      }
      html = withoutImg;
      System.out.println("Html after removing images: " + html);
      return html;
   }

	private BufferedImage getImageFromUrl(String url) {
		HttpURLConnection con;
		try {
			con = (HttpURLConnection) new URL(url).openConnection();
			con.addRequestProperty("User-Agent", 
					"Mozilla/5.0 (compatible; Windows NT 6.3; MSIE 6.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36");
			return ImageIO.read(con.getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
   
   //	public static BufferedImage getBufferedImage(String plainHtml){
   //		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
   //		imageGenerator.loadHtml(prepareHtml(plainHtml));
   //		return imageGenerator.getBufferedImage();
   //		
   //	}

   //	@Override
   //	public void res
   //	
}
