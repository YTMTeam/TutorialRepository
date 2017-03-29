package com.lexington.mc.webview.beans;
// package com.mallocinc.ytm.webview.beans;
// import java.io.Serializable;
// import java.util.ArrayList;
//
// import javax.faces.application.FacesMessage;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.ViewScoped;
//
// import org.apache.log4j.Logger;
//
// import com.mallocinc.ytm.database.generated.to.UsersTo;
// import com.mallocinc.ytm.model.user.UserProfile;
// import com.mallocinc.ytm.model.util.MessageException;
// import com.mallocinc.ytm.webview.util.FacesUtil;
//
//
// @ViewScoped
// @ManagedBean(name = "test")
// public class TestBean implements Serializable
// {
// final static Logger log = Logger.getLogger(TestBean.class.getName());
// private ArrayList<UsersTo> selectUsers;
// private ArrayList<UsersTo> testUsers=new ArrayList<UsersTo>();
// private UserProfile userProfile;
//
// public TestBean() {
// selectUsers = new ArrayList<UsersTo>();
// userProfile = new UserProfile();
// UsersTo a=new UsersTo();
// a.setUSERNAME("Pera");
// UsersTo b=new UsersTo();
// b.setUSERNAME("Mika");
// UsersTo c=new UsersTo();
// c.setUSERNAME("Zika");
// UsersTo d=new UsersTo();
// d.setUSERNAME("Lola");
// UsersTo e=new UsersTo();
// e.setUSERNAME("Zika");
// UsersTo k=new UsersTo();
// k.setUSERNAME("Mima");
// UsersTo u=new UsersTo();
// u.setUSERNAME("Jova");
// testUsers.add(a);
// testUsers.add(b);
// testUsers.add(c);
// testUsers.add(d);
// testUsers.add(e);
// testUsers.add(k);
// testUsers.add(u);
// // try {
// // selectUsers = userProfile.retriveUsers();
// // } catch (ErrorMessageException ex) {
// // FacesUtil.throwMessage(null, FacesMessage.SEVERITY_ERROR,
// ex.getMessage());
// // log.error("Error: Could not retrieve users!",ex);
// // }
// // FacesUtil.throwMessage("student", FacesMessage.SEVERITY_INFO, "student");
// // System.out.println(FacesUtil.getMessage("student"));
// }
//
// public ArrayList<UsersTo> getSelectUsers() {
// return selectUsers;
// }
//
// public void setSelectUsers(ArrayList<UsersTo> selectUsers) {
// this.selectUsers = selectUsers;
// }
//
// public ArrayList<UsersTo> getTestUsers() {
// return testUsers;
// }
//
// public void setTestUsers(ArrayList<UsersTo> testUsers) {
// this.testUsers = testUsers;
// }
//
//}
