package com.lexington.mc.webview.jasper.util;

import java.awt.image.BufferedImage;

public class ImageLink {
   private BufferedImage link;
   private int    order;

   public ImageLink(BufferedImage link, int order) {
      super();
      this.link = link;
      this.order = order;
   }

   public BufferedImage getLink() {
      return link;
   }

   public void setLink(BufferedImage link) {
      this.link = link;
   }

   public int getOrder() {
      return order;
   }

   public void setOrder(int order) {
      this.order = order;
   }

}
