package com.lexington.mc.webview.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.lexington.mc.logic.providers.BlockchainUtilProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.lexington.mc.model.blockchain.common.BlockchainErrorMessages;
import com.lexington.mc.model.entities.EntityUser;
import com.lexington.mc.model.singletons.datasource.UserEntityDatasource;
import com.lexington.mc.webview.controllers.FamilyController;
import com.lexington.mc.webview.datatable.impl.AccountDatatable;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.AccountTo;


@SessionScoped
@ManagedBean(name = "user")
public class ManageUser implements Serializable {

   final static Logger log = Logger.getLogger(ManageUser.class.getName());
   private boolean redirectedFromFilter= false; //this flag is used if a user is redirected from filter page not to be redirected again. So it is always checked before any other init redirect.
   private boolean loggedIn;
   StringBuffer originalUrl;
   private TimeZone timeZone;
   private int timeZoneOffset;
   private String  ipAddress;
   private EntityUser curUser;
   private FamilyController family=new FamilyController();
   //creds

   private String bankName="";
   private String privateKey="";

   private String username;

   private static final long serialVersionUID = 776018841281588265L;
   private ManageGlobalSearch globalSearch=new ManageGlobalSearch();
   private BlockchainUtilProvider blockchainProvider = new BlockchainUtilProvider();

   private final int VIEW_USERS=4;
   private final int VIEW_UX=1;
   private final int VIEW_TXS=2;
   private final int VIEW_BLOCKS=3;
   private final int VIEW_NODES=5;
   private final int VIEW_FAMILY=6;
   private final int VIEW_TRADES=7;
   private final int VIEW_INDEX=0;

   private int oneButtonSwitchValue=VIEW_NODES;

   private String A="";

   public String getA() {
      return A;
   }

   public void setA(String a) {
      A = a;
   }


   public void init() {

      String msg = (String) FacesUtil.getUserInfoMessage();
      if (msg != null) {
         FacesUtil.throwInfo(msg);
      }	
      ManageUser user = (ManageUser) FacesUtil.getSessionMapValue("user");
      String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
      if (!viewId.startsWith("/pages/"))
         if (user != null)
            if (user.isLoggedIn()) {
               FacesUtil.redirect(viewId);
            }



   }


   private void resetData() {
      //TODO RESET DATA ABOUT THE USER

      loggedIn = false;
   }


   public String login() throws NoSuchProviderException {
      retreiveIpAddress();
      createTimeZone();
      log.info("Starting login procedure.");

      curUser = new UserEntityDatasource().getUserByUsernameForLogin(username);

      if(curUser==null){
         log.info("Couldn't login.");
         FacesUtil.throwWarning("invalidUsername");
         loggedIn = false;
         resetData();
         return "";
      }

      try {	       
         loggedIn = blockchainProvider.checkLoginCredentials(curUser, privateKey);
      } catch(MessageException e) {
         if(!e.getMessage().contains(BlockchainErrorMessages.Streams.UNSPENT_OUTPUTS)) {
            FacesUtil.throwMessage(e);
            loggedIn = false;
            resetData();
            return "";
         } else {
            //unspent outputs bug from multichain, will allow this key
            loggedIn = true;
         }
      }

      if(loggedIn == false) {
         FacesUtil.throwError("privateKeyError");
         resetData();
         return "";
      }

      FacesUtil.setSessionMapValue("privateKey", privateKey);


      log.info("Redirecting to user homepage...");

      if(originalUrl!=null){
         String outcome= originalUrl.toString();
         originalUrl= null;
         outcome=outcome.substring(outcome.lastIndexOf("/") + 1);
         outcome=outcome.replace(".xhtml", "");
         outcome=checkNavigation(outcome);

         //FacesUtil.redirect("pages/"+out+"?faces-redirect=true");
         return "pages/"+ outcome;

      }
      else
         return "pages/home?faces-redirect=true";
      // return "pages/profiles?faces-redirect=true";
   }
   
   public String loginWithEncryptionKey() throws NoSuchProviderException {
      retreiveIpAddress();
      createTimeZone();
      log.info("Starting login procedure.");
      
      curUser = new UserEntityDatasource().getUserByUsernameForLogin(username);
      
      //In this case privateKey = encryptionKey
      String encryptionKey = privateKey;
      
      if(curUser==null){
         log.info("Couldn't login.");
         FacesUtil.throwWarning("invalidUsername");
         loggedIn = false;
         resetData();
         return "";
      }
      String privateKeyFromStream = null;
      try {	       
         privateKeyFromStream = blockchainProvider.checkLoginCredentialsUsingEncryption(curUser, encryptionKey);
      } catch(MessageException e) {
            FacesUtil.throwMessage(e);
            loggedIn = false;
            resetData();
            return "";
      }
      
      loggedIn = privateKeyFromStream != null;
      
      if(loggedIn == false) {
         FacesUtil.throwError("encryptionKeyError");
         resetData();
         return "";
      }
      
      FacesUtil.setSessionMapValue("privateKey", privateKeyFromStream);
      
      
      log.info("Redirecting to user homepage...");
      
      if(originalUrl!=null){
         String outcome= originalUrl.toString();
         originalUrl= null;
         outcome=outcome.substring(outcome.lastIndexOf("/") + 1);
         outcome=outcome.replace(".xhtml", "");
         outcome=checkNavigation(outcome);
         
         //FacesUtil.redirect("pages/"+out+"?faces-redirect=true");
         return "pages/"+ outcome;
         
      }
      else
         return "pages/home?faces-redirect=true";
      // return "pages/profiles?faces-redirect=true";
   }


   private String checkNavigation(String o) {
      //		if(o.startsWith("courseclass?") || o.startsWith("grading?") || o.startsWith("lesson?") || o.startsWith("personal_report?") || o.startsWith("pools?") || o.startsWith("preferences?") || o.startsWith("profile?") || o.startsWith("profiles?") || o.startsWith("quiz_collection?") || o.startsWith("quiz_wizard?") || o.startsWith("quizzes?") || o.startsWith("reports?")|| o.startsWith("take_quiz?"))
      //			return o;
      //		else
      return "index?faces-redirect=true";
   }
   public void onItemSelect(SelectEvent event) throws IOException {




      AccountTo user = (AccountTo) event.getObject();
      if(user==null){
         FacesUtil.throwError("somethingWentWrong");
         return;
      }


      //TODO redirect to account page with this ID

      FacesContext.getCurrentInstance().getExternalContext()
      .redirect("account.xhtml?faces-redirect=true&accountId=" + user.getACCOUNT_ID()); 

      if(oneButtonSwitchValue!= VIEW_FAMILY && oneButtonSwitchValue != VIEW_TRADES){
         oneButtonSwitchValue=VIEW_FAMILY;

      }

      if(oneButtonSwitchValue == VIEW_FAMILY){
         //			 family.setCurFamilyMember(curUser);


      }


   }




   public int getOneButtonSwitchValue() {
      return oneButtonSwitchValue;
   }
   public void setOneButtonSwitchValue(int oneButtonSwitchValue) {
      this.oneButtonSwitchValue = oneButtonSwitchValue;
   }


   public boolean isIndexPage(){
      return oneButtonSwitchValue == 0;

   }

   public boolean isUsersPage(){
      return oneButtonSwitchValue == VIEW_USERS;

   }

   public boolean isTxsPage(){
      return oneButtonSwitchValue == VIEW_TXS;

   }

   public boolean isBlocksPage(){
      return oneButtonSwitchValue == VIEW_BLOCKS;

   }


   public boolean isUxPage(){
      return oneButtonSwitchValue == VIEW_UX;

   }


   public boolean isNodesPage(){
      return oneButtonSwitchValue == VIEW_NODES;

   }


   public boolean isFamilyPage(){
      return oneButtonSwitchValue == VIEW_FAMILY;

   }


   public boolean isTradesPage(){
      return oneButtonSwitchValue == VIEW_TRADES;

   }



   public int getVIEW_USERS() {
      return VIEW_USERS;
   }
   public int getVIEW_UX() {
      return VIEW_UX;
   }
   public int getVIEW_TXS() {
      return VIEW_TXS;
   }
   public int getVIEW_BLOCKS() {
      return VIEW_BLOCKS;
   }





   /**
    * Dummy Data
    */
   CartesianChartModel model = new CartesianChartModel();
   public void ChartBean(){


      ChartSeries sales = new ChartSeries();
      sales.setLabel("Sales");
      sales.set("2004", 1000);
      sales.set("2005", 1170);
      sales.set("2006", 660);
      sales.set("2007", 1030);

      ChartSeries expenses = new ChartSeries();
      expenses.setLabel("Expenses");
      expenses.set("2004", 400);
      expenses.set("2005", 460);
      expenses.set("2006", 1120);
      expenses.set("2007", 540);
      model.addSeries(sales);
      model.addSeries(expenses);
   }


   public CartesianChartModel getModel() {
      return model;
   }
   public int getVIEW_NODES() {
      return VIEW_NODES;
   }
   public ManageGlobalSearch getGlobalSearch() {
      return globalSearch;
   }
   public void setGlobalSearch(ManageGlobalSearch globalSearch) {
      this.globalSearch = globalSearch;
   }

   //	public FamilyController getFamily() {
   //		return family;
   //	}
   //
   //	public void setFamily(FamilyController family) {
   //		this.family = family;
   //	}
   //
   //	public int getVIEW_FAMILY() {
   //		return VIEW_FAMILY;
   //	}

   public int getVIEW_TRADES() {
      return VIEW_TRADES;
   }

   //	public TradesController getTrades() {
   //		return trades;
   //	}
   // 
   //	public void setTrades(TradesController trades) {
   //		this.trades = trades;
   //	}
   //
   //	public EntityAccount getCurUser() {
   //		return curUser;
   //	}
   //
   //	public void setCurUser(EntityAccount curUser) {
   //		this.curUser = curUser;
   //	}


   public String translateDirection(String direction){
      if(direction==null)
         return "";
      if(direction.equals(BlockchainConstants.DirectionStatus.BUY))
         return FacesUtil.getMessage("buy");
      if(direction.equals(BlockchainConstants.DirectionStatus.SELL))
         return FacesUtil.getMessage("sell");
      return "";

   }

   public String translateTradeStatus(String tradeStatus){
      if(tradeStatus==null)
         return "";
      if(tradeStatus.equals(BlockchainConstants.StockStatusConstants.CANCELED))
         return FacesUtil.getMessage("canceled");
      if(tradeStatus.equals(BlockchainConstants.StockStatusConstants.FILLED))
         return FacesUtil.getMessage("executed");
      if(tradeStatus.equals(BlockchainConstants.StockStatusConstants.PARTIALLY_FILLED))
         return FacesUtil.getMessage("partiallyFilled");
      return "";

   }


   public void retreiveIpAddress() {
      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      ipAddress = request.getHeader("X-FORWARDED-FOR");
      if (ipAddress == null) {
         ipAddress = request.getRemoteAddr();
      }

      log.info("Client IP address is: " + ipAddress);
   }
   private void createTimeZone() {
      String sign="";
      if(timeZoneOffset<0)
         sign="+";
      else
         sign="-";
      int hours=Math.abs(timeZoneOffset/60);

      int mins=timeZoneOffset%60;

      String sHours="";
      String sMins="";

      if (hours < 10)
         sHours = "0" + hours;
      else
         sHours = "" + hours;
      if (mins < 10)
         sMins = "0" + mins;
      else
         sMins = "" + mins;

      timeZone=TimeZone.getTimeZone("GMT"+sign+sHours+":"+sMins);
      //  timeZone=TimeZone.getTimeZone("GMT+02:00");
      System.out.println(timeZone);
   }


   public String logout() {
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "/login?faces-redirect=true";
   } 


   public boolean isRedirectedFromFilter() {
      return redirectedFromFilter;
   }

   public void setRedirectedFromFilter(boolean redirectedFromFilter) {
      this.redirectedFromFilter = redirectedFromFilter;
   }
   public boolean isLoggedIn() {
      return loggedIn;
   }

   public void setLoggedIn(boolean loggedIn) {
      this.loggedIn = loggedIn;
   }

   public StringBuffer getOriginalUrl() {
      return originalUrl;
   }

   public void setOriginalUrl(StringBuffer originalUrl) {
      this.originalUrl = originalUrl;
   }

   public String getBankName() {
      return bankName;
   }

   public void setBankName(String bankName) {
      this.bankName = bankName;
   }

   public String getPrivateKey() {
      return privateKey;
   }

   public void setPrivateKey(String privateKey) {
      this.privateKey = privateKey;
   }

   public TimeZone getTimeZone() {
      return timeZone;
   }

   public void setTimeZone(TimeZone timeZone) {
      this.timeZone = timeZone;
   }

   public int getTimeZoneOffset() {
      return timeZoneOffset;
   }

   public void setTimeZoneOffset(int timeZoneOffset) {
      this.timeZoneOffset = timeZoneOffset;
   }

   public int getVIEW_FAMILY() {
      return VIEW_FAMILY;
   }

   public int getVIEW_INDEX() {
      return VIEW_INDEX;
   }


   public FamilyController getFamily() {
      return family;
   }

   public void setFamily(FamilyController family) {
      this.family = family;
   }

   public EntityUser getCurUser() {
      return curUser;
   }

   public void setCurUser(EntityUser curUser) {
      this.curUser = curUser;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }


   private AccountDatatable accounts=new AccountDatatable();

   public AccountDatatable getAccounts() {
      return accounts;
   }

   public void setAccounts(AccountDatatable accounts) {
      this.accounts = accounts;
   }


}
