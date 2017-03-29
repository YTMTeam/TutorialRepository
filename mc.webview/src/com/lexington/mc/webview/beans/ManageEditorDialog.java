package com.lexington.mc.webview.beans;

import java.io.Serializable;

public class ManageEditorDialog implements Serializable {
   /**
    * Eclipse generated serial ID
    */
   private static final long serialVersionUID = -9011931724922793462L;

   private String editorValue;
   private int    answerIndex;
   private int    answerType;
   private int    assistanceIndex;

   public String getEditorValue() {
      return editorValue;
   }

   public void setEditorValue(String editorValue) {
      this.editorValue = editorValue;
   }

   public int getAnswerIndex() {
      return answerIndex;
   }

   public void setAnswerIndex(int answerIndex) {
      this.answerIndex = answerIndex;
   }

   public int getAnswerType() {
      return answerType;
   }

   public void setAnswerType(int answerType) {
      this.answerType = answerType;
   }

   public int getAssistanceIndex() {
      return assistanceIndex;
   }

   public void setAssistanceIndex(int assistanceIndex) {
      this.assistanceIndex = assistanceIndex;
   }
}
