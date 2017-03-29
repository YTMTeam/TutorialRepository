package com.lexington.mc.model.util;

import java.io.Serializable;
import java.math.BigDecimal;

// @ManagedBean(name = "codeTypes")
// @SessionScoped
public class UtilCodeTypes implements Serializable {
   /**
    * 
    */
   private static final long       serialVersionUID         = 1L;
   public UserClassRole            UserClassRole            = new UserClassRole();
 	public UserType UserType = new UserType();
   public UserStatus               UserStatus               = new UserStatus();
   public AddressType              AddressType              = new AddressType();
   public QuizInstanceStatus       QuizInstanceStatus       = new QuizInstanceStatus();
   public ClassStatus              ClassStatus              = new ClassStatus();
   public CourseStatus             CourseStatus             = new CourseStatus();
   public QuizDefinitionStatus     QuizDefinitionStatus     = new QuizDefinitionStatus();
   public OrganizationStatus       OrganizationStatus       = new OrganizationStatus();
   public OrganizationCategoryCode OrganizationCategoryCode = new OrganizationCategoryCode();
   public Gender                   Gender                   = new Gender();
   public UserCourseRole           UserCourseRole           = new UserCourseRole();
   public AdressStatus             AdressStatus             = new AdressStatus();

   public UserPoolRoles            UserPoolRoles            = new UserPoolRoles();
   public UserQuizRoles            UserQuizRoles            = new UserQuizRoles();
   public QuestionDifficulty       QuestionDifficulty       = new QuestionDifficulty();
   public RoleCodes                RoleCodes                = new RoleCodes();

   public FunctionCode             FunctionCode             = new FunctionCode();
   public MustChangePwd            MustChangePwd            = new MustChangePwd();
   public UserActionCodes          userActionCodes          = new UserActionCodes();

   public DurationType             DurationType             = new DurationType();
   public LookType                 LookType                 = new LookType();
   public ReportType               ReportType               = new ReportType();
   public ResolveType              ResolveType              = new ResolveType();
   public TrueFalseQuestionType    TrueFalseQuestionType    = new TrueFalseQuestionType();
   public YesNoIndicator           YesNoIndicator           = new YesNoIndicator();

   public ResolveType getResolveType() {
      return ResolveType;
   }

   public ResultsDisplayCode          ResultsDisplayCode          = new ResultsDisplayCode();
   public CreateType                  CreateType                  = new CreateType();
   public QuestionType                QuestionType                = new QuestionType();
   public QuestionAssistanceType      QuestionAssistanceType      = new QuestionAssistanceType();
   public QuizDefinitionLogicalStatus QuizDefinitionLogicalStatus = new QuizDefinitionLogicalStatus();
   public QuestionFrequencyFactor     QuestionFrequencyFactor     = new QuestionFrequencyFactor();
   public RandomQuestionOrder         RandomQuestionOrder         = new RandomQuestionOrder();
   public RandomAnswerOrder           RandomAnswerOrder           = new RandomAnswerOrder();
   public PublicIndicator             PublicIndicator             = new PublicIndicator();

   public ExamType                    ExamType                    = new ExamType();
   public NetworkAccessCode           NetworkAccessCode           = new NetworkAccessCode();

   public LessonStatus                LessonStatus                = new LessonStatus();

   public LiteratureType              LiteratureType              = new LiteratureType();

   public UserSkillLevel              UserSkillLevel              = new UserSkillLevel();
   public NotifType                   NotifType                   = new NotifType();
   public GeneratedParmArgumentType   GenParmArgumentType         = new GeneratedParmArgumentType();
   public GeneratedParmResultType     GenParmResultType           = new GeneratedParmResultType();

   
   public PingTestType                PingTestType                =new  PingTestType();
   
   public AccountType				  AccountType 				  =new AccountType();
   public MonitorStatus               MonitorStatus               =new MonitorStatus();
   public MonitorType                 MonitorType               =new MonitorType();
   
   
   public class AccountType implements Serializable {
	      private static final long serialVersionUID = 1L;
	      public Codes              Codes            = new Codes();

	      public Codes getCodes() {
	         return Codes;
	      }

	      public class Codes implements Serializable {
	         public final String       BANK_USER 		= "WABANKUSER";
	         public final String       FAMILY_USER        = "WADRTPUSER";
	      } 
   }
   
   public class MonitorStatus implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();
      
      public Codes getCodes() {
         return Codes;
      }
      
      public class Codes implements Serializable {
         public final String       ACTIVE 		= "ACTIVE";
         public final String       PASSED       = "PASSED";
      } 
   }
   
   public class MonitorType implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();
      
      public Codes getCodes() {
         return Codes;
      }
      
      public class Codes implements Serializable {
         public final String       INTERNAL 	  = "INTERNAL";
         public final String       EXTERNAL       = "EXTERNAL";
      } 
   }
   public class PingTestType implements Serializable {
	      private static final long serialVersionUID = 1L;
	      public Codes              Codes            = new Codes();
	      public final String       codeTypeId       = "PING";

	      public Codes getCodes() {
	         return Codes;
	      }

	      public class Codes implements Serializable {
	         private static final long serialVersionUID        = 1L;
	         public final String       PING_TEST 		= "PING_TEST";
	         public final String       KILL_TEST        = "KILL_TEST";
			public String getPING_TEST() {
				return PING_TEST;
			}
			public String getKILL_TEST() {
				return KILL_TEST;
			}
 

	       

	        

	         
	      }
 
	   }
   
   
   
   
   public PingTestType getPingTestType() {
	return PingTestType;
}



public UserSkillLevel getUserSkillLevel() {
      return UserSkillLevel;
   }

   public NotifType getNotifType() {
      return NotifType;
   }

   public class NotifType implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();
      public final String       codeTypeId       = "NOTIF";

      public Codes getCodes() {
         return Codes;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID        = 1L;
         public final String       NOTIF_UNRESOLVED_REPORT = "NOTIFUNRES";
         public final String       NOTIF_START_QUIZ        = "NOTIFQUIZR";
         public final String       NOTIF_SHOW_REPORT       = "NOTIFSHOWR";
         public final String       NOTIF_REGISTER_REQUEST  = "NOTIFREGRQ";
         public final String       NOTIF_CONTINUE_QUIZ        = "NOTIFQUIZC";

         public String getNOTIF_UNRESOLVED_REPORT() {
            return NOTIF_UNRESOLVED_REPORT;
         }

         public String getNOTIF_START_QUIZ() {
            return NOTIF_START_QUIZ;
         }

         public String getNOTIF_SHOW_REPORT() {
            return NOTIF_SHOW_REPORT;
         }

         public String getNOTIF_REGISTER_REQUEST() {
            return NOTIF_REGISTER_REQUEST;
         }

		public String getNOTIF_CONTINUE_QUIZ() {
			return NOTIF_CONTINUE_QUIZ;
		}

         
      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals(Codes.NOTIF_UNRESOLVED_REPORT))
            return UtilProperites.getMessageProperty(local, "unresolvedReport");
         if (role.equals(Codes.NOTIF_START_QUIZ))
            return UtilProperites.getMessageProperty(local, "quizRequest");
         if (role.equals(Codes.NOTIF_SHOW_REPORT))
            return UtilProperites.getMessageProperty(local, "showReport");
         if (role.equals(Codes.NOTIF_REGISTER_REQUEST))
            return UtilProperites.getMessageProperty(local, "registerRequest");
         if (role.equals(Codes.NOTIF_CONTINUE_QUIZ))
             return UtilProperites.getMessageProperty(local, "continueQuiz");
         return role;
      }

   }

   public class UserSkillLevel implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();
      public final String       codeTypeId       = "CRLEV";

      public Codes getCodes() {
         return Codes;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID         = 1L;
         public final String       BASIC_SKILL_LEVEL        = "CRLEVLBASC";
         public final String       INTERMEDIATE_SKILL_LEVEL = "CRLEVLINTM";
         public final String       ADVANCED_SKILL_LEVEL     = "CRLEVLADVN";

         public String getBASIC_SKILL_LEVEL() {
            return BASIC_SKILL_LEVEL;
         }

         public String getINTERMEDIATE_SKILL_LEVEL() {
            return INTERMEDIATE_SKILL_LEVEL;
         }

         public String getADVANCED_SKILL_LEVEL() {
            return ADVANCED_SKILL_LEVEL;
         }

      }

      public String getCodeDescFromScore(String local, BigDecimal role) {
         double highBasic = new Double(UtilProperites.getSettingsProperty("highBasic"));
         double highIntermediate = new Double(UtilProperites.getSettingsProperty("highIntermediate"));
         if (role == null)
            return "";

         if (role.doubleValue() <= highBasic) {
            return UtilProperites.getMessageProperty(local, "basic");

         } else if (role.doubleValue() <= highIntermediate) {
            return UtilProperites.getMessageProperty(local, "intermediate");

         } else {
            return UtilProperites.getMessageProperty(local, "advanced");

         }
      }

      public String getCodeDesc(String local, String role) {
         //			double highBasic=new Double(UtilProperites.getSettingsProperty("highBasic"));
         //			double highIntermediate=new Double(UtilProperites.getSettingsProperty("highIntermediate"));
         if (role == null)
            return "";

         if (role.equals("CRLEVLBASC"))
            return UtilProperites.getMessageProperty(local, "basic");
         if (role.equals("CRLEVLINTM"))
            return UtilProperites.getMessageProperty(local, "intermediate");
         if (role.equals("CRLEVLADVN"))
            return UtilProperites.getMessageProperty(local, "advanced");
         return role;
      }

      public String getCodeByValue(BigDecimal score) {
         double highBasic = new Double(UtilProperites.getSettingsProperty("highBasic"));
         double highIntermediate = new Double(UtilProperites.getSettingsProperty("highIntermediate"));

         if (score.doubleValue() <= highBasic) {
            return "CRLEVLBASC";
         } else if (score.doubleValue() <= highIntermediate) {
            return "CRLEVLINTM";

         } else {
            return "CRLEVLADVN";

         }
      }

   }

   public RandomQuestionOrder getRandomQuestionOrder() {
      return RandomQuestionOrder;
   }

   public RandomAnswerOrder getRandomAnswerOrder() {
      return RandomAnswerOrder;
   }

   public class RandomQuestionOrder implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       YES              = "Y";
         public final String       NO               = "N";

         public String getYES() {
            return YES;
         }

         public String getNO() {
            return NO;
         }

      }

   }

   public class RandomAnswerOrder implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       YES              = "Y";
         public final String       NO               = "N";

         public String getYES() {
            return YES;
         }

         public String getNO() {
            return NO;
         }

      }

   }

   public class PublicIndicator implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("Y"))
            return UtilProperites.getMessageProperty(local, "publicWord");
         if (role.equals("N"))
            return UtilProperites.getMessageProperty(local, "privateWord");
         return role;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       YES              = "Y";
         public final String       NO               = "N";

         public String getYES() {
            return YES;
         }

         public String getNO() {
            return NO;
         }

      }

   }

   public class YesNoIndicator implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("Y"))
            return UtilProperites.getMessageProperty(local, "yes");
         if (role.equals("N"))
            return UtilProperites.getMessageProperty(local, "no");
         return role;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       YES              = "Y";
         public final String       NO               = "N";

         public String getYES() {
            return YES;
         }

         public String getNO() {
            return NO;
         }

      }

   }

   public class MustChangePwd implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       YES              = "Y";
         public final String       NO               = "N";

         public String getYES() {
            return YES;
         }

         public String getNO() {
            return NO;
         }

      }

   }

   public class UserClassRole implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UCR";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       MANAGER          = "CLM";
         public final String       USER             = "CLU";

         public String getMANAGER() {
            return MANAGER;
         }

         public String getUSER() {
            return USER;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("CLM"))
            return UtilProperites.getMessageProperty(local, "manager");
         if (role.equals("CLU"))
            return UtilProperites.getMessageProperty(local, "user");
         return role;
      }
   }

   /** not used anymore. Not to be deleted.
   public class UserType implements Serializable
   {
   public Codes Codes = new Codes();

   public Codes getCodes()
   {
   	return Codes;
   }

   public final String codeTypeId = "UST";

   public class Codes implements Serializable
   {
   	public final String PROFESSOR = "PRO";
   	public final String STUDENT = "STU";
   	public final String ADMINISTRATOR = "ADS";

   	public String getPROFESSOR()
   	{
   		return PROFESSOR;
   	}

   	public String getSTUDENT()
   	{
   		return STUDENT;
   	}

   	public String getADMINISTRATOR()
   	{
   		return ADMINISTRATOR;
   	}

   }

   public String getCodeDesc(String local, String role)
   {
   	if (role == null)
   		return "";
   	if (role.equals("PRO"))
   		return UtilProperites.getMessageProperty(local, "professor");
   	if (role.equals("STU"))
   		return UtilProperites.getMessageProperty(local, "student");
   	if (role.equals("ADS") || role.equals("ADM"))
   		return UtilProperites.getMessageProperty(local, "administrator");
   	return role;

   }

   public String getRole(String role)
   {
   	if (role.equals("PRO"))
   		return "PRF";
   	if (role.equals("STU"))
   		return "STU";
   	if (role.equals("ADS"))
   		return "ADM";
   	return null;
   }
   }

    **/

   public class UserType implements Serializable {

	      private static final long serialVersionUID = 1L;

	      public Codes              Codes            = new Codes();

	      public Codes getCodes() {
	         return Codes;
	      }

	      public final String codeTypeId = "BCT";

	      public class Codes implements Serializable {
	         private static final long serialVersionUID = 1L;

	         public final String       USER        = "WADRTPUSER";
	         public final String       BANK        = "WADRTPBANK";
			public String getUSER() {
				return USER;
			}
			public String getBANK() {
				return BANK;
			}
 
			 
	        

	      }
	      public String getCodeDesc(String local, String role) {
		         if (role == null)
		            return "";
		         if (role.equals("WADRTPUSER"))
		            return UtilProperites.getMessageProperty(local, "user");
		         if (role.equals("WADRTPBANK"))
		            return UtilProperites.getMessageProperty(local, "bank");
				return role;
		  }
	   }
   
   
   public class UserStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "USS";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;

         public final String       ACTIVE           = "ACT";
         public final String       SUSPENDED        = "SUS";
         public final String       LOCKED           = "LOC";
         public final String       DELETED          = "DEL";
         public final String       PENDING          = "PEN";

         public String getACTIVE() {
            return ACTIVE;
         }

         public String getSUSPENDED() {
            return SUSPENDED;
         }

         public String getLOCKED() {
            return LOCKED;
         }

         public String getDELETED() {
            return DELETED;
         }

         public String getPENDING() {
            return PENDING;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("ACT"))
            return UtilProperites.getMessageProperty(local, "active");
         if (role.equals("SUS"))
            return UtilProperites.getMessageProperty(local, "suspended");
         if (role.equals("LOC"))
            return UtilProperites.getMessageProperty(local, "locked");
         if (role.equals("DEL"))
            return UtilProperites.getMessageProperty(local, "deleted");
         if (role.equals("PEN"))
            return UtilProperites.getMessageProperty(local, "pending");
         return role;
      }
   }

   public class AddressType implements Serializable {
      /**
       * 
       */
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "ADT";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final char         PERSONAL         = 'P';
         // public final char SHIPPING='S';
         public final char         BUISNESS         = 'B';

         public char getPERSONAL() {
            return PERSONAL;
         }

         public char getBUISNESS() {
            return BUISNESS;
         }

      }

      public String getCodeDesc(String local, char role) {
         if (role == 'P')
            return UtilProperites.getMessageProperty(local, "personalAdr");
         // if(role=='S')return "Shipping";
         if (role == 'B')
            return UtilProperites.getMessageProperty(local, "businessAdr");
         return " ";

      }
   }

   public class QuizInstanceStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QST";

      public class Codes implements Serializable {

         private static final long serialVersionUID        = 1L;

         public final String       DELETED                 = "QDL";
         public final String       SUSPENDED               = "QSS";
         public final String       ATTEMPTED_WITH_REPORT   = "ATR";
         public final String       ATTEMPTED_NO_REPORT     = "ATN";
         //	public final String EXPIRED = "EXP";
         public final String       NOT_ATTEMPTED           = "NAT";
         public final String       NOT_ATTEMPTED_IN_LESSON = "NAL";

         public String getDELETED() {
            return DELETED;
         }

         public String getSUSPENDED() {
            return SUSPENDED;
         }

         public String getATTEMPTED_WITH_REPORT() {
            return ATTEMPTED_WITH_REPORT;
         }

         public String getATTEMPTED_NO_REPORT() {
            return ATTEMPTED_NO_REPORT;
         }

         //			public String getEXPIRED()
         //			{
         //				return EXPIRED;
         //			}

         public String getNOT_ATTEMPTED() {
            return NOT_ATTEMPTED;
         }

         public String getNOT_ATTEMPTED_IN_LESSON() {
            return NOT_ATTEMPTED_IN_LESSON;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("NAT"))
            return UtilProperites.getMessageProperty(local, "notAttemted");
         if (role.equals("ATN"))
            return UtilProperites.getMessageProperty(local, "attemptedNoReport");
         if (role.equals("ATR"))
            return UtilProperites.getMessageProperty(local, "attemptedReport");
         if (role.equals("QDL"))
            return UtilProperites.getMessageProperty(local, "deleted");
         if (role.equals("QSS"))
            return UtilProperites.getMessageProperty(local, "suspended");
         if (role.equals("NAL"))
            return UtilProperites.getMessageProperty(local, "notAttemted");
         //			if (role.equals("EXP"))
         //				return UtilProperites.getMessageProperty(local, "expired");

         return role;
      }
   }

   public class ClassStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "CST";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       ACTIVE           = "ATV";
         public final String       INACTIVE         = "INV";
         public final String       DELETED          = "DLT";

         public String getACTIVE() {
            return ACTIVE;
         }

         public String getINACTIVE() {
            return INACTIVE;
         }

         public String getDELETED() {
            return DELETED;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role.equals("ATV"))
            return UtilProperites.getMessageProperty(local, "activeFem");
         if (role.equals("INV"))
            return UtilProperites.getMessageProperty(local, "inactiveFem");
         if (role.equals("DLT"))
            return UtilProperites.getMessageProperty(local, "deletedFem");

         return role;
      }
   }

   public class CourseStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "COS";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         // TODO: izmeniti u i prosirenoj verziji
         public final String       ACTIVE           = "ACE";
         public final String       INACTIVE         = "INA";
         public final String       DELETED          = "DLE";

         public String getACTIVE() {
            return ACTIVE;
         }

         public String getINACTIVE() {
            return INACTIVE;
         }

         public String getDELETED() {
            return DELETED;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role.equals("ACE"))
            return UtilProperites.getMessageProperty(local, "active");
         if (role.equals("INA"))
            return UtilProperites.getMessageProperty(local, "inactive");
         if (role.equals("DLE"))
            return UtilProperites.getMessageProperty(local, "deleted");

         return role;
      }
   }

   public class QuizDefinitionStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QDS";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       ACTIVE           = "QAC";
         public final String       SUSPENDED        = "QSU";
         public final String       WAITING          = "QWA";
         public final String       DELETED          = "QDE"; // logicaly deleted from system

         public String getACTIVE() {
            return ACTIVE;
         }

         public String getSUSPENDED() {
            return SUSPENDED;
         }

         public String getWAITING() {
            return WAITING;
         }

         public String getDELETED() {
            return DELETED;
         }

      }

      public String getCodeDesc(String local, String status) {
         if (status.equals("QAC"))
            return UtilProperites.getMessageProperty(local, "active");
         if (status.equals("QSU"))
            return UtilProperites.getMessageProperty(local, "suspended");
         if (status.equals("QWA"))
            return UtilProperites.getMessageProperty(local, "waiting");
         if (status.equals("QDE"))
            return UtilProperites.getMessageProperty(local, "deleted");
         return status;
      }
   }

   public class QuizDefinitionLogicalStatus implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QLS";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       SCHEDULED        = "SCHEDULED";
         public final String       EXPIRED          = "EXPIRED";
         public final String       SUSPENDED        = "SUSPENDED";
         public final String       WAITING          = "WAITING";
         public final String       DELETED          = "DELETED";  // logicaly deleted from system
         public final String       RUNNING          = "RUNNING";

         public String getSCHEDULED() {
            return SCHEDULED;
         }

         public String getEXPIRED() {
            return EXPIRED;
         }

         public String getRUNNING() {
            return RUNNING;
         }

         public String getSUSPENDED() {
            return SUSPENDED;
         }

         public String getWAITING() {
            return WAITING;
         }

         public String getDELETED() {
            return DELETED;
         }

      }

      public String getCodeDesc(String local, String status) {
         if (status.equals("RUNNING"))
            return UtilProperites.getMessageProperty(local, "running");
         if (status.equals("SCHEDULED"))
            return UtilProperites.getMessageProperty(local, "scheduled");
         if (status.equals("SUSPENDED"))
            return UtilProperites.getMessageProperty(local, "suspended");
         if (status.equals("WAITING"))
            return UtilProperites.getMessageProperty(local, "notScheduled");
         if (status.equals("DELETED"))
            return UtilProperites.getMessageProperty(local, "deleted");
         if (status.equals("EXPIRED"))
            return UtilProperites.getMessageProperty(local, "expired");
         return status;
      }
   }

   public class OrganizationStatus implements Serializable {
      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "OST";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       ACTIVE           = "AVE";
         public final String       SUSPENDED        = "SPD";
         public final String       LOCKED           = "LCK";
         public final String       DELETED          = "DLD";

         public String getACTIVE() {
            return ACTIVE;
         }

         public String getSUSPENDED() {
            return SUSPENDED;
         }

         public String getLOCKED() {
            return LOCKED;
         }

         public String getDELETED() {
            return DELETED;
         }

      }
   }

   public class OrganizationCategoryCode implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "OCC";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;
         public final String       EDUCATION        = "EDU";
         public final String       BUSSINES         = "BUS";
         public final String       POLITICS         = "POL";
         public final String       OTHER            = "OTH";

         public String getEDUCATION() {
            return EDUCATION;
         }

         public String getBUSSINES() {
            return BUSSINES;
         }

         public String getPOLITICS() {
            return POLITICS;
         }

         public String getOTHER() {
            return OTHER;
         }

      }
   }

   public class Gender implements Serializable {
      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "GEN";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       MALE             = "M";
         public final String       FEMALE           = "F";

         public String getMALE() {
            return MALE;
         }

         public String getFEMALE() {
            return FEMALE;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == "M")
            return UtilProperites.getMessageProperty(local, "male");
         if (role == "F")
            return UtilProperites.getMessageProperty(local, "female");

         return role;
      }
   }

   public class UserCourseRole implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UOR";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       MANAGER          = "COM";

         public final String       USER             = "COU";

         public String getMANAGER() {
            return MANAGER;
         }

         public String getUSER() {
            return USER;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null)
            return "";
         if (role.equals("COM"))
            return UtilProperites.getMessageProperty(local, "manager");
         if (role.equals("COU"))
            return UtilProperites.getMessageProperty(local, "user");

         return role;

      }
   }

   public class AdressStatus implements Serializable { // Describes if certain quiz status is assigned
      // to student

      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "AST";

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;

         public final String       PRIMARY          = "APR";
         public final String       ALTERNATE        = "AAL";
         public final String       OLD              = "AOL";

         public String getPRIMARY() {
            return PRIMARY;
         }

         public String getALTERNATE() {
            return ALTERNATE;
         }

         public String getOLD() {
            return OLD;
         }

      }
   }

   public class UserPoolRoles implements Serializable { // Describes if certain quiz status is assigned
      // to student

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UPR";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       USER             = "POU";
         public final String       MANAGER          = "POM";

         public String getUSER() {
            return USER;
         }

         public String getMANAGER() {
            return MANAGER;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null || role.isEmpty() || role.equals("None"))
            return "";
         if (role.substring(0, 3).equals("POU"))
            return UtilProperites.getMessageProperty(local, "user");
         if (role.substring(0, 3).equals("POM"))
            return UtilProperites.getMessageProperty(local, "manager");
         return role;
      }

      public boolean isAdministrator(String role) {
         if (role.substring(0, 3).equals("ADM"))
            return true;
         return false;
      }

      public boolean isUser(String role) {
         if (role.substring(0, 3).equals("USR"))
            return true;
         return false;
      }

   }

   public class UserQuizRoles implements Serializable { // Describes if certain quiz status is assigned
      // to student

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UQR";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       MANAGER          = "QMN";

         public String getMANAGER() {
            return MANAGER;
         }

      }

      public String getCodeDesc(String local, String role) {
         if (role == null || role.isEmpty() || role.equals("None"))
            return "";

         if (role.substring(0, 3).equals("QMN"))
            return UtilProperites.getMessageProperty(local, "manager");
         return role;
      }

      public boolean isManager(String role) {
         if (role.substring(0, 3).equals("QMN"))
            return true;
         return false;
      }

   }

   public class QuestionDifficulty implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QDF";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       EASY             = "DEA";
         public final String       MEDIUM           = "DME";
         public final String       HARD             = "DHA";

         public String getEASY() {
            return EASY;
         }

         public String getMEDIUM() {
            return MEDIUM;
         }

         public String getHARD() {
            return HARD;
         }

      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("DEA"))
            return UtilProperites.getMessageProperty(local, "easy");
         if (code.equals("DME"))
            return UtilProperites.getMessageProperty(local, "medium");
         if (code.equals("DHA"))
            return UtilProperites.getMessageProperty(local, "hard");
         return code;
      }
   }

   public UserQuizRoles getUserQuizRoles() {
      return UserQuizRoles;
   }

   public class ResolveType implements Serializable {
      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "RST";

      public class Codes implements Serializable {

         private static final long serialVersionUID  = 1L;

         public final String       SYSTEM_RESOLVE    = "QRY";
         public final String       PROFESSOR_RESOLVE = "QRN";

         public String getSYSTEM_RESOLVE() {
            return SYSTEM_RESOLVE;
         }

         public String getPROFESSOR_RESOLVE() {
            return PROFESSOR_RESOLVE;
         }

      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("QRY"))
            return UtilProperites.getMessageProperty(local, "systemResolve");
         if (code.equals("QRN"))
            return UtilProperites.getMessageProperty(local, "profResolve");

         return code;
      }
   }

   public class DurationType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "DUT";

      public class Codes implements Serializable {

         private static final long serialVersionUID      = 1L;

         public final String       UNLIMITED             = "UNL";
         public final String       DURATION_PER_QUESTION = "DQS";
         public final String       DURATION_PER_QUIZ     = "DQZ";

         public String getUNLIMITED() {
            return UNLIMITED;
         }

         public String getDURATION_PER_QUESTION() {
            return DURATION_PER_QUESTION;
         }

         public String getDURATION_PER_QUIZ() {
            return DURATION_PER_QUIZ;
         }

      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("UNL"))
            return UtilProperites.getMessageProperty(local, "unlimited");
         if (code.equals("DQS"))
            return UtilProperites.getMessageProperty(local, "durPerQuestion");
         if (code.equals("DQZ"))
            return UtilProperites.getMessageProperty(local, "durPerQuiz");

         return code;
      }
   }

   public class LookType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "LOT";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       ALL_ON_PAGE      = "AOP";
         public final String       ONE_PER_PAGE     = "OPP";

         public String getALL_ON_PAGE() {
            return ALL_ON_PAGE;
         }

         public String getONE_PER_PAGE() {
            return ONE_PER_PAGE;
         }

      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("AOP"))
            return UtilProperites.getMessageProperty(local, "allOnPage");
         if (code.equals("OPP"))
            return UtilProperites.getMessageProperty(local, "questionPerPage");

         return code;
      }
   }

   public class ReportType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "RTP";

      public class Codes implements Serializable {

         private static final long serialVersionUID   = 1L;

         public final String       ON_PROF_APPROVAL   = "OPA";
         public final String       IMM_AFTER_QUIZ     = "IMM";
         public final String       IMM_AFTER_QUESTION = "IQT";

         public String getON_PROF_APPROVAL() {
            return ON_PROF_APPROVAL;
         }

         public String getIMM_AFTER_QUIZ() {
            return IMM_AFTER_QUIZ;
         }

         public String getIMM_AFTER_QUESTION() {
            return IMM_AFTER_QUESTION;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("OPA"))
            return UtilProperites.getMessageProperty(local, "onProfApproval");
         if (code.equals("IMM"))
            return UtilProperites.getMessageProperty(local, "onQuizFinished");
         if (code.equals("IQT"))
            return UtilProperites.getMessageProperty(local, "afterEveryQuestion");
         return code;
      }
   }

   public class ResultsDisplayCode implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "RDC";

      public class Codes implements Serializable {

         private static final long serialVersionUID  = 1L;

         public final String       GRADE_AND_PREVIEW = "FUL";
         public final String       GRADE_ONLY        = "GRA";

         public String getGRADE_AND_PREVIEW() {
            return GRADE_AND_PREVIEW;
         }

         public String getGRADE_ONLY() {
            return GRADE_ONLY;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("FUL"))
            return UtilProperites.getMessageProperty(local, "gradeAndResults");
         if (code.equals("GRA"))
            return UtilProperites.getMessageProperty(local, "gradeOnly");

         return code;
      }
   }

   public class CreateType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "CRT";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       GENERATED        = "GEN";
         public final String       MANUAL           = "MAN";

         public String getGENERATED() {
            return GENERATED;
         }

         public String getMANUAL() {
            return MANUAL;
         }

      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("GEN"))
            return UtilProperites.getMessageProperty(local, "generated");
         if (code.equals("MAN"))
            return UtilProperites.getMessageProperty(local, "manualyCreated");

         return code;
      }
   }

   public class UserQuizRole implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UQR";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       MANAGER          = "QMN";
      }

      public String getCodeDesc(String local, String code) {

         if (code == null)
            return "";
         if (code.equals("QMN"))
            return UtilProperites.getMessageProperty(local, "manager");

         return code;
      }
   }

   public class QuestionType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QUT";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       SINGLE_CHOICE    = "SNC";
         public final String       MULTI_CHOICE     = "MLC";
         public final String       TRUE_FALSE       = "TFC";
         public final String       ESSAY            = "ESY";
         public final String       ORDERING         = "ORD";
         public final String       FILL_BLANKS      = "FBL";
         public final String       MACHING          = "MCH";
         public final String       OPEN             = "OPQ";

         public String getSINGLE_CHOICE() {
            return SINGLE_CHOICE;
         }

         public String getMULTI_CHOICE() {
            return MULTI_CHOICE;
         }

         public String getTRUE_FALSE() {
            return TRUE_FALSE;
         }

         public String getESSAY() {
            return ESSAY;
         }

         public String getORDERING() {
            return ORDERING;
         }

         public String getMACHING() {
            return MACHING;
         }

         public String getOPEN() {
            return OPEN;
         }

         public String getFILL_BLANKS() {
            return FILL_BLANKS;
         }
      }

      public String getCodeDesc(String local, String role) {
         if (role.equals("SNC"))
            return UtilProperites.getMessageProperty(local, "singleChoice");
         if (role.equals("MLC"))
            return UtilProperites.getMessageProperty(local, "multipleChoice");
         if (role.equals("TFC"))
            return UtilProperites.getMessageProperty(local, "trueFalse");
         if (role.equals("ESY"))
            return UtilProperites.getMessageProperty(local, "essay");
         if (role.equals("ORD"))
            return UtilProperites.getMessageProperty(local, "ordering");
         if (role.equals("FBL"))
            return UtilProperites.getMessageProperty(local, "fillBlanks");
         if (role.equals("MCH"))
            return UtilProperites.getMessageProperty(local, "matching");
         if (role.equals("OPQ"))
            return UtilProperites.getMessageProperty(local, "open");

         return role;
      }
   }

   public class QuestionAssistanceType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "QASIS";

      public class Codes implements Serializable {

         private static final long serialVersionUID       = 1L;

         public final String       SECOND_TRY             = "QASSISTSEC";
         public final String       LEARNING_FEEDBACK      = "QASSISTLFB";
         public final String       ADDITIONAL_TIME        = "QASSISTADT";
         public final String       MINUS_ONE_WRONG_ANSWER = "QASSISTMWA";

         public String getSECOND_TRY() {
            return SECOND_TRY;
         }

         public String getLEARNING_FEEDBACK() {
            return LEARNING_FEEDBACK;
         }

         public String getADDITIONAL_TIME() {
            return ADDITIONAL_TIME;
         }

         public String getMINUS_ONE_WRONG_ANSWER() {
            return MINUS_ONE_WRONG_ANSWER;
         }

         public String getCodeDesc(String local, String role) {
            if (role.equals(SECOND_TRY))
               return UtilProperites.getMessageProperty(local, "questionAssistanceSecondTry");
            if (role.equals(LEARNING_FEEDBACK))
               return UtilProperites.getMessageProperty(local, "questionAssistanceLearningFeedback");
            if (role.equals(ADDITIONAL_TIME))
               return UtilProperites.getMessageProperty(local, "questionAssistanceAdditionalTime");
            if (role.equals(MINUS_ONE_WRONG_ANSWER))
               return UtilProperites.getMessageProperty(local, "questionAssistanceMinusOneWrongAnswer");

            return role;
         }
      }
   }

   public class RoleCodes implements Serializable {

      private static final long serialVersionUID = 1L;

      public final String       PROFESSOR        = "PRF";
      public final String       STUDENT          = "STU";
      public final String       ADMINISTRATOR    = "ADM";

      public String getPROFESSOR() {
         return PROFESSOR;
      }

      public String getSTUDENT() {
         return STUDENT;
      }

      public String getADMINISTRATOR() {
         return ADMINISTRATOR;
      }

      public String getCodeDesc(String local, String role) {
         // if(role==null)return "Member";
         if (role.equals("PRF"))
            return UtilProperites.getMessageProperty(local, "professor");
         if (role.equals("STU"))
            return UtilProperites.getMessageProperty(local, "student");
         if (role.equals("ADM"))
            return UtilProperites.getMessageProperty(local, "administrator");

         return role;

      }

      public String getType(String role) {
         if (role.equals("PRF"))
            return "PRO";
         if (role.equals("STU"))
            return "STU";
         if (role.equals("ADM"))
            return "ADS";
         return null;
      }
      // public final String SECRETARY="SEC"; //II faza
      // public final String GUEST="GUE";//II faza
   }

   public class QuestionFrequencyFactor implements Serializable {

      private static final long serialVersionUID = 1L;

      public final int          NEVER            = 0;
      public final int          RARELY           = 30;
      public final int          NORMAL           = 50;
      public final int          OFTEN            = 70;
      public final int          ALWAYS           = 100;

      public int getNEVER() {
         return NEVER;
      }

      public int getRARELY() {
         return RARELY;
      }

      public int getNORMAL() {
         return NORMAL;
      }

      public int getOFTEN() {
         return OFTEN;
      }

      public int getALWAYS() {
         return ALWAYS;
      }

      public String getCodeDesc(String local, int code) {
         if (code <= NEVER) {
            return UtilProperites.getMessageProperty(local, "never");
         }

         if (code <= RARELY) {
            return UtilProperites.getMessageProperty(local, "rarely");
         }

         if (code <= NORMAL) {
            return UtilProperites.getMessageProperty(local, "normal");
         }

         if (code < ALWAYS) {
            return UtilProperites.getMessageProperty(local, "often");
         }

         return UtilProperites.getMessageProperty(local, "always");
      }

   }

   public class FunctionCode implements Serializable { // II faza

      private static final long serialVersionUID            = 1L;

      public final String       LOG_IN                      = "LGN";
      public final String       CREATE_QUIZ                 = "CRQ";
      public final String       TAKE_QUIZ                   = "TAQ";
      public final String       CREATE_USER                 = "CRU";
      public final String       CHANGE_PASSWORD             = "CHP";
      public final String       CHANGE_OWN_PERSONAL_DATA    = "CPD";
      public final String       CHANGE_OTHERS_PERSONAL_DATA = "COD";
      public final String       CREATE_CLASS                = "CCL";
      public final String       EDIT_CLASS                  = "EDC";
      public final String       CREATE_COURSE               = "CRC";
      public final String       EDIT_COURSE                 = "EDE";
      public final String       CREATE_ROLE                 = "CRR";
      public final String       EDIT_ROLE                   = "EDR";
      public final String       GRANT_ROLE                  = "GRR";
   }

   public class UserActionCodes implements Serializable {

      private static final long serialVersionUID = 1L;
      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "UAC";

      public class Codes implements Serializable {

         private static final long serialVersionUID               = 1L;
         public final String       LOAD_QUIZ_FROM_EXCEL           = "QLE";

         public final String       SAVE_QUIZ_FROM_EXCEL           = "SQE";

         public final String       LOAD_POOL_QUESTIONS_FROM_EXCEL = "LPQ";

         public final String       SAVE_POOL_QUESTIONS_FROM_EXCEL = "SPQ";

         public final String       LOAD_USERS_DATA_FROM_EXCEL     = "LUD";

         public final String       SAVE_USERS_DATA_FROM_EXCEL     = "SUD";

         public String getLOAD_QUIZ_FROM_EXCEL() {
            return LOAD_QUIZ_FROM_EXCEL;
         }

         public String getSAVE_QUIZ_FROM_EXCEL() {
            return SAVE_QUIZ_FROM_EXCEL;
         }

         public String getLOAD_POOL_QUESTIONS_FROM_EXCEL() {
            return LOAD_POOL_QUESTIONS_FROM_EXCEL;
         }

         public String getSAVE_POOL_QUESTIONS_FROM_EXCEL() {
            return SAVE_POOL_QUESTIONS_FROM_EXCEL;
         }

         public String getLOAD_USERS_DATA_FROM_EXCEL() {
            return LOAD_USERS_DATA_FROM_EXCEL;
         }

         public String getSAVE_USERS_DATA_FROM_EXCEL() {
            return SAVE_USERS_DATA_FROM_EXCEL;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("QLE"))
            return UtilProperites.getMessageProperty(local, "loadQuizFromExcel");
         if (code.equals("QLE"))
            return UtilProperites.getMessageProperty(local, "saveQuizFromExcel");
         if (code.equals("LPQ"))
            return UtilProperites.getMessageProperty(local, "loadPoolQuestionFromExcel");
         if (code.equals("SPQ"))
            return UtilProperites.getMessageProperty(local, "savePoolQuestionFromExcel");
         if (code.equals("LUD"))
            return UtilProperites.getMessageProperty(local, "loadUsersDataFromExcel");
         if (code.equals("SUD"))
            return UtilProperites.getMessageProperty(local, "saveUsersDataFromExcel");

         return code;
      }
   }

   public class NetworkAccessCode {

      public final String codeTypeId = "NAC";
      public Codes        Codes      = new Codes();

      public class Codes implements Serializable {
         private static final long serialVersionUID = 1L;

         public final String       INTERNAL_NETWORK = "INO";
         public final String       OPEN_ACCESS      = "OPN";

         public String getINTERNAL_NETWORK() {
            return INTERNAL_NETWORK;
         }

         public String getOPEN_ACCESS() {
            return OPEN_ACCESS;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("INO"))
            return UtilProperites.getMessageProperty(local, "internalNetwork");
         if (code.equals("OPN"))
            return UtilProperites.getMessageProperty(local, "openAccess");
         return code;
      }

      public Codes getCodes() {
         return Codes;
      }

   }

   public class ExamType {

      public final String codeTypeId = "EXT";
      public Codes        Codes      = new Codes();

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;
         public final String       OFFICIAL_EXAM    = "OEX";
         public final String       COLLOQUIM        = "CLQ";
         public final String       PRACTICE         = "PTC";

         public String getOFFICIAL_EXAM() {
            return OFFICIAL_EXAM;
         }

         public String getCOLLOQUIM() {
            return COLLOQUIM;
         }

         public String getPRACTICE() {
            return PRACTICE;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("OEX"))
            return UtilProperites.getMessageProperty(local, "examTest");
         if (code.equals("CLQ"))
            return UtilProperites.getMessageProperty(local, "colTest");
         if (code.equals("PTC"))
            return UtilProperites.getMessageProperty(local, "praTest");
         return code;
      }

      public Codes getCodes() {
         return Codes;
      }

   }

   public class LessonStatus {

      public final String codeTypeId = "LSTAT";
      public Codes        Codes      = new Codes();

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;
         public final String       UNPUBLISHED      = "LESTAUNPUB";
         public final String       PUBLISHED        = "LESTAPUBLS";
         public final String       ARCHIVED         = "LESTAARCHI";

         public String getUNPUBLISHED() {
            return UNPUBLISHED;
         }

         public String getPUBLISHED() {
            return PUBLISHED;
         }

         public String getARCHIVED() {
            return ARCHIVED;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("LESTAUNPUB"))
            return UtilProperites.getMessageProperty(local, "unpublished");
         if (code.equals("LESTAPUBLS"))
            return UtilProperites.getMessageProperty(local, "published");
         if (code.equals("LESTAARCHI"))
            return UtilProperites.getMessageProperty(local, "archived");
         return code;
      }

      public Codes getCodes() {
         return Codes;
      }

   }

   public class LiteratureType {

      public final String codeTypeId = "LTYPE";
      public Codes        Codes      = new Codes();

      public class Codes implements Serializable {

         private static final long serialVersionUID   = 1L;
         public final String       VIDEO_LITERATURE   = "LTYPEVIDEO";
         public final String       AUDIO_LITERATURE   = "LTYPEAUDIO";
         public final String       PDF_LITERATURE     = "LTYPEPDFFR";
         public final String       GDOCS_LITERATURE   = "LTYPEGDOCS";
         public final String       ARCHIVE_LITERATURE = "LTYPEARCHI";
         public final String       YOUTUBE_LITERATURE = "LTYPEYTUBE";
         public final String       HLINK_LITERATURE   = "LTYPEHLINK";
         public final String       PROC_LITERATURE    = "LTYPEPROC";
         public final String       IMAG_LITERATURE    = "LTYPEIMAG";

         public String getVIDEO_LITERATURE() {
            return VIDEO_LITERATURE;
         }

         public String getAUDIO_LITERATURE() {
            return AUDIO_LITERATURE;
         }

         public String getPDF_LITERATURE() {
            return PDF_LITERATURE;
         }

         public String getGDOCS_LITERATURE() {
            return GDOCS_LITERATURE;
         }

         public String getARCHIVE_LITERATURE() {
            return ARCHIVE_LITERATURE;
         }

         public String getYOUTUBE_LITERATURE() {
            return YOUTUBE_LITERATURE;
         }

         public String getHLINK_LITERATURE() {
            return HLINK_LITERATURE;
         }

         public String getPROC_LITERATURE() {
            return PROC_LITERATURE;
         }

         public String getIMAG_LITERATURE() {
            return IMAG_LITERATURE;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("LTYPEVIDEO"))
            return UtilProperites.getMessageProperty(local, "video");
         if (code.equals("LTYPEAUDIO"))
            return UtilProperites.getMessageProperty(local, "audio");
         if (code.equals("LTYPEPDFFR"))
            return UtilProperites.getMessageProperty(local, "pdf");
         if (code.equals("LTYPEGDOCS"))
            return UtilProperites.getMessageProperty(local, "googleDocs");
         if (code.equals("LTYPEARCHI"))
            return UtilProperites.getMessageProperty(local, "archive");
         if (code.equals("LTYPEYTUBE"))
            return UtilProperites.getMessageProperty(local, "youtube");
         if (code.equals("LTYPEHLINK"))
            return UtilProperites.getMessageProperty(local, "hyperlink");
         if (code.equals("LTYPEPROC"))
            return UtilProperites.getMessageProperty(local, "problemProcessor");
         if (code.equals("LTYPEIMAG"))
            return UtilProperites.getMessageProperty(local, "picture");
         return code;
      }

      public Codes getCodes() {
         return Codes;
      }

   }

   public class TrueFalseQuestionType {
      public final String codeTypeId = "QTF";
      public Codes        Codes      = new Codes();

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;
         private final String      TRUE_ANSWER      = "TRU";
         private final String      FALSE_ANSWER     = "FLS";

         public String getTRUE_ANSWER() {
            return TRUE_ANSWER;
         }

         public String getFALSE_ANSWER() {
            return FALSE_ANSWER;
         }

      }

      public String getCodeDesc(String local, String code) {
         if (code == null)
            return "";
         if (code.equals("TRU"))
            return UtilProperites.getMessageProperty(local, "True");
         if (code.equals("FLS"))
            return UtilProperites.getMessageProperty(local, "False");
         return code;
      }

      public Codes getCodes() {
         return Codes;
      }
   }
   
   public class GeneratedParmArgumentType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "GENPARMARG";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       DECIMAL_ARG      = "GENPARGTDA";
         public final String       NUMBER_ARG       = "GENPARGTNA";
         public final String       TEXT_ARG         = "GENPARGTTA";

         public String getDECIMAL_ARG() {
            return DECIMAL_ARG;
         }

         public String getNUMBER_ARG() {
            return NUMBER_ARG;
         }

         public String getTEXT_ARG() {
            return TEXT_ARG;
         }

         public String getCodeDesc(String local, String code) {
            if (code.equals(DECIMAL_ARG))
               return UtilProperites.getMessageProperty(local, "questionGenParmDecimalArgument");
            if (code.equals(NUMBER_ARG))
               return UtilProperites.getMessageProperty(local, "questionGenParmNumberArgument");
            if (code.equals(TEXT_ARG))
               return UtilProperites.getMessageProperty(local, "questionGenParmTextArgument");

            return code;
         }
      }
   }
   
   public class GeneratedParmResultType implements Serializable {

      private static final long serialVersionUID = 1L;

      public Codes              Codes            = new Codes();

      public Codes getCodes() {
         return Codes;
      }

      public final String codeTypeId = "GENPARMRTY";

      public class Codes implements Serializable {

         private static final long serialVersionUID = 1L;

         public final String       DECIMAR_RES      = "GPARMRESDR";
         public final String       NUMBER_RES       = "GPARMRESNR";
         public final String       TEXT_RES         = "GPARMRESTR";

         public String getDECIMAR_RES() {
            return DECIMAR_RES;
         }

         public String getNUMBER_RES() {
            return NUMBER_RES;
         }

         public String getTEXT_RES() {
            return TEXT_RES;
         }

         public String getCodeDesc(String local, String code) {
            if (code.equals(DECIMAR_RES))
               return UtilProperites.getMessageProperty(local, "questionGenParmDecimalResult");
            if (code.equals(NUMBER_RES))
               return UtilProperites.getMessageProperty(local, "questionGenParmNumberResult");
            if (code.equals(TEXT_RES))
               return UtilProperites.getMessageProperty(local, "questionGenParmTextResult");

            return code;
         }
      }
   }

   public UserClassRole getUserClassRole() {
      return UserClassRole;
   }

   //	public UserType getUserType()
   //	{
   //		return UserType;
   //	}

   public UserStatus getUserStatus() {
      return UserStatus;
   }

   public AddressType getAddressType() {
      return AddressType;
   }

   public QuizInstanceStatus getQuizInstanceStatus() {
      return QuizInstanceStatus;
   }

   public ClassStatus getClassStatus() {
      return ClassStatus;
   }

   public CourseStatus getCourseStatus() {
      return CourseStatus;
   }

   public QuizDefinitionStatus getQuizDefinitionStatus() {
      return QuizDefinitionStatus;
   }

   public OrganizationCategoryCode getOrganizationCategoryCode() {
      return OrganizationCategoryCode;
   }

   public Gender getGender() {
      return Gender;
   }

   public UserCourseRole getUserCourseRole() {
      return UserCourseRole;
   }

   public AdressStatus getAdressStatus() {
      return AdressStatus;
   }

   public UserPoolRoles getUserPoolRoles() {
      return UserPoolRoles;
   }

   public QuestionDifficulty getQuestionDifficulty() {
      return QuestionDifficulty;
   }

   public RoleCodes getRoleCodes() {
      return RoleCodes;
   }

   public FunctionCode getFunctionCode() {
      return FunctionCode;
   }

   public DurationType getDurationType() {
      return DurationType;
   }

   public LookType getLookType() {
      return LookType;
   }

   public ReportType getReportType() {
      return ReportType;
   }

   public ResultsDisplayCode getResultsDisplayCode() {
      return ResultsDisplayCode;
   }

   public CreateType getCreateType() {
      return CreateType;
   }

   public QuestionType getQuestionType() {
      return QuestionType;
   }

   public QuestionAssistanceType getQuestionAssistanceType() {
      return QuestionAssistanceType;
   }

   public void setQuestionType(QuestionType questionType) {
      QuestionType = questionType;
   }

   public QuizDefinitionLogicalStatus getQuizDefinitionLogicalStatus() {
      return QuizDefinitionLogicalStatus;
   }

   public PublicIndicator getPublicIndicator() {
      return PublicIndicator;
   }

   public QuestionFrequencyFactor getQuestionFrequencyFactor() {
      return QuestionFrequencyFactor;
   }

   public ExamType getExamType() {
      return ExamType;
   }

   public NetworkAccessCode getNetworkAccessCode() {
      return NetworkAccessCode;
   }

   public TrueFalseQuestionType getTrueFalseQuestionType() {
      return TrueFalseQuestionType;
   }

   public LessonStatus getLessonStatus() {
      return LessonStatus;
   }

   public YesNoIndicator getYesNoIndicator() {
      return YesNoIndicator;
   }

   public LiteratureType getLiteratureType() {
      return LiteratureType;
   }
   
   public GeneratedParmArgumentType getGenParmArgumentType() {
      return GenParmArgumentType;
   }
   
   public GeneratedParmResultType getGenParmResultType() {
      return GenParmResultType;
   }



public UserType getUserType() {
	return UserType;
}
   
}
