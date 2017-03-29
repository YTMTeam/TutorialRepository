package com.lexington.mc.model.util;

public class UtilPermissions {
   //public static final String TYPE_GENERAL="GEN";
//   public static final String TYPE_PROFILES        = "PRO";
   public static final String TYPE_USERS           = "USE";
   public static final String TYPE_COURSES_CLASSES = "CCC";
   public static final String TYPE_POOLS           = "PPP";
   public static final String TYPE_QUIZZES         = "QQQ";
   //public static final String TYPE_REPORTS="RRR";
   public static final String TYPE_QUIZ_CATEGORIES = "CAT";
   public static final String TYPE_GRADINGS        = "GGG";

//   public ProfilesGroup profilesGroup = new ProfilesGroup();
   public UserGroup     userGroup     = new UserGroup();
   public CourseGroup   courseGroup   = new CourseGroup();
   public PoolsGroup    poolsGroup    = new PoolsGroup();
   public QuizzesGroup  quizzesGroup  = new QuizzesGroup();
   //public  ReportsGroup reportsGroup= new ReportsGroup();
   public GradingsGroup gradingsGroup = new GradingsGroup();
   public CategoryGroup categoryGroup = new CategoryGroup();

//   public class ProfilesGroup {
//    
//      
//      
//      
//   }

   public class UserGroup {
	   public static final String PERM_VIEW_PROFILES_PAGE    = "VPP";
      public static final String PERM_VIEW_OTHERS_INFO       = "VOP";
      public static final String PERM_CHANGE_OWN_INFO        = "CPD";
      public static final String PERM_CHANGE_OTHERS_INFO     = "COD";
      public static final String PERM_CHANGE_OWN_PASSWORD    = "CHP";
      public static final String PERM_CHANGE_OTHERS_PASSWORD = "COP";

      public String getPermViewProfilesPage(){
    	  return PERM_VIEW_PROFILES_PAGE;
      }
      //		public static final String PERM_VIEW_OTHERS_QUIZ_COLLECTION="VQC";
      public String getPermViewOthersInfo() {
         return PERM_VIEW_OTHERS_INFO;
      }

      //		public  String getPermViewOthersQuizCollection() {
      //			return PERM_VIEW_OTHERS_QUIZ_COLLECTION;
      //		}
      public String getPermChangeOwnInfo() {
         return PERM_CHANGE_OWN_INFO;
      }

      public String getPermChangeOthersInfo() {
         return PERM_CHANGE_OTHERS_INFO;
      }

      public String getPermChangeOwnPassword() {
         return PERM_CHANGE_OWN_PASSWORD;
      }

      public String getPermChangeOthersPassword() {
         return PERM_CHANGE_OTHERS_PASSWORD;
      }

      /**added from profiles group **/
      
      
      public static final String PERM_SEE_PROFILES_PAGE        = "SPP";
      public static final String PERM_SEE_ALL_USERS            = "SAU";
      public static final String PERM_CHANGE_GROUP_USER_STATUS = "CGU";
      public static final String PERM_EXPORT_USERS_TO_PDF      = "EUP";
      public static final String PERM_SEE_DELETED_USERS        = "SDU";
      public static final String PERM_MANAGE_REG_REQUESTS      = "MRR";
      public static final String PERM_CREATE_NEW_USER          = "CRU";
      public static final String PERM_LOG_IN                   = "LGN";
      public static final String PERM_MANAGE_ROLE              = "CRR";

      public static final String PERM_GRANT_ROLES = "GRR";
      public static final String PERM_MANAGE_SUBSCRIPTIONS     = "MSC";

      public static final String PERM_MANAGE_SYSTEM_SETTINGS     = "MSS";
      
      public String getPermLogIn() {
         return PERM_LOG_IN;
      }

      public String getPermManageRole() {
         return PERM_MANAGE_ROLE;
      }

      public String getPermGrantRoles() {
         return PERM_GRANT_ROLES;
      }

      public String getPermSeeDeletedUsers() {
         return PERM_SEE_DELETED_USERS;
      }

      public String getPermSeeProfilesPage() {
         return PERM_SEE_PROFILES_PAGE;
      }

      public String getPermSeeAllUsers() {
         return PERM_SEE_ALL_USERS;
      }

      public String getPermChangeGroupUserStatus() {
         return PERM_CHANGE_GROUP_USER_STATUS;
      }

      public String getPermExportUsersToPdf() {
         return PERM_EXPORT_USERS_TO_PDF;
      }

      public String getPermManageRegRequests() {
         return PERM_MANAGE_REG_REQUESTS;
      }

      public String getPermCreateNewUser() {
         return PERM_CREATE_NEW_USER;
      }

	public  String getPermManageSubscriptions() {
		return PERM_MANAGE_SUBSCRIPTIONS;
	}

	public String getPermManageSystemSettings() {
		return PERM_MANAGE_SYSTEM_SETTINGS;
	}

      
      
      
   }

   public class CourseGroup {
      public static final String PERM_VIEW_COURSES_PAGE                = "VCC";
      public static final String PERM_VIEW_DELETED_COURSES_AND_CLASSES = "SDE";
      //		public static final String PERM_VIEW_DELETED_CLASSES="SDC";
      public static final String PERM_VIEW_ALL_TREE                    = "VCT";
      public static final String PERM_CREATE_COURSE_OR_CLASS           = "CCO";
      public static final String PERM_MANAGE_ANY_COURSE_OR_CLASS       = "MCC";

      public String getPermViewCoursesPage() {
         return PERM_VIEW_COURSES_PAGE;
      }

      public String getPermViewDeletedCoursesAndClasses() {
         return PERM_VIEW_DELETED_COURSES_AND_CLASSES;
      }

      public String getPermViewAllTree() {
         return PERM_VIEW_ALL_TREE;
      }

      public String getPermCreateCourseOrClass() {
         return PERM_CREATE_COURSE_OR_CLASS;
      }

      public String getPermManageAnyCourseOrClass() {
         return PERM_MANAGE_ANY_COURSE_OR_CLASS;
      }

   }

   public class PoolsGroup {
      public static final String PERM_VIEW_POOLS_PAGE = "VPP";
      public static final String PERM_CREATE_POOL     = "CPO";
      public static final String PERM_MANAGE_ANY_POOL = "MAP";

      public String getPermViewPoolsPage() {
         return PERM_VIEW_POOLS_PAGE;
      }

      public String getPermCreatePool() {
         return PERM_CREATE_POOL;
      }

      public String getPermManageAnyPool() {
         return PERM_MANAGE_ANY_POOL;
      }

   }

   public class QuizzesGroup {
      public static final String PERM_VIEW_QUIZZES_PAGE           = "VQP";
      public static final String PERM_CREATE_TEST                 = "CRQ";
      public static final String PERM_CREATE_OFFICIAL_TEST        = "COQ";
      public static final String PERM_SEND_QUIZ_TO_OTHER_USERS    = "SQO";
      public static final String PERM_MANAGE_ANY_QUIZ             = "MAQ";
      public static final String PERM_VIEW_BASIC_INFO_OF_NON_DELETED     = "SBQ";
      public static final String PERM_VIEW_DELETED_QUIZZES        = "SDQ";
      public static final String PERM_SAVE_QUIZ_TEMPLATE          = "SQT";
      public static final String PERM_SET_QUIZ_TEMPLATE_TO_PUBLIC = "SQP";
      public static final String PERM_MANAGE_ANY_QUIZ_TEMPLATE    = "MQT";

      public static final String PERM_VIEW_REPORTS_PAGE        = "VRP";
      public static final String PERM_VIEW_ANY_COMPLETE_REPORT = "VCR";
      public static final String PERM_VIEW_ANY_BASIC_REPORT    = "VBR";
      public static final String PERM_MANAGE_ANY_REPORT        = "MAR";

      public String getPermViewReportsPage() {
         return PERM_VIEW_REPORTS_PAGE;
      }

      public String getPermViewAnyCompleteReport() {
         return PERM_VIEW_ANY_COMPLETE_REPORT;
      }

      public String getPermViewAnyBasicReport() {
         return PERM_VIEW_ANY_BASIC_REPORT;
      }

      public String getPermManageAnyReport() {
         return PERM_MANAGE_ANY_REPORT;
      }

      public String getPermViewQuizzesPage() {
         return PERM_VIEW_QUIZZES_PAGE;
      }

      public String getPermCreateTest() {
         return PERM_CREATE_TEST;
      }

      public String getPermCreateOfficialTest() {
         return PERM_CREATE_OFFICIAL_TEST;
      }

      public String getPermSendQuizToOtherUsers() {
         return PERM_SEND_QUIZ_TO_OTHER_USERS;
      }

      public String getPermManageAnyQuiz() {
         return PERM_MANAGE_ANY_QUIZ;
      }

      public String getPermViewBasicInfoNonDeleted() {
         return PERM_VIEW_BASIC_INFO_OF_NON_DELETED;
      }

      public String getPermViewDeletedQuizzes() {
         return PERM_VIEW_DELETED_QUIZZES;
      }

      public String getPermSaveQuizTemplate() {
         return PERM_SAVE_QUIZ_TEMPLATE;
      }

      public String getPermSetQuizTemplateToPublic() {
         return PERM_SET_QUIZ_TEMPLATE_TO_PUBLIC;
      }

      public String getPermManageAnyQuizTemplate() {
         return PERM_MANAGE_ANY_QUIZ_TEMPLATE;
      }

   }

   public class GradingsGroup {
      public static final String PERM_VIEW_GRADINGS_PAGE = "VGP";
      public static final String PERM_CREATE_GRADING     = "CGG";
      public static final String PERM_SET_PUBLIC_GRADING = "SGP";
      public static final String PERM_MANAGE_ANY_GRADING = "MAG";

      public String getPermViewGradingsPage() {
         return PERM_VIEW_GRADINGS_PAGE;
      }

      public String getPermCreateGrading() {
         return PERM_CREATE_GRADING;
      }

      public String getPermSetPublicGrading() {
         return PERM_SET_PUBLIC_GRADING;
      }

      public String getPermManageAnyGrading() {
         return PERM_MANAGE_ANY_GRADING;
      }

   }

   public class CategoryGroup {
      public static final String PERM_CREATE_QUIZ_CATEGORY     = "CQC";
      public static final String PERM_MANAGE_ANY_QUIZ_CATEGORY = "MQC";

      public String getPermCreateQuizCategory() {
         return PERM_CREATE_QUIZ_CATEGORY;
      }

      public String getPermManageAnyQuizCategory() {
         return PERM_MANAGE_ANY_QUIZ_CATEGORY;
      }

   }

//   public String getTypeProfiles() {
//      return TYPE_PROFILES;
//   }

   public String getTypeUsers() {
      return TYPE_USERS;
   }

   public String getTypeCoursesClasses() {
      return TYPE_COURSES_CLASSES;
   }

   public String getTypePools() {
      return TYPE_POOLS;
   }

   public String getTypeQuizzes() {
      return TYPE_QUIZZES;
   }

   //	public String getTypeReports() {
   //		return TYPE_REPORTS;
   //	}
   public String getTypeQuizCategories() {
      return TYPE_QUIZ_CATEGORIES;
   }

   public String getTypeGradings() {
      return TYPE_GRADINGS;
   }

//   public ProfilesGroup getProfilesGroup() {
//      return profilesGroup;
//   }

   public UserGroup getUserGroup() {
      return userGroup;
   }

   public CourseGroup getCourseGroup() {
      return courseGroup;
   }

   public PoolsGroup getPoolsGroup() {
      return poolsGroup;
   }

   public QuizzesGroup getQuizzesGroup() {
      return quizzesGroup;
   }

   //	public ReportsGroup getReportsGroup() {
   //		return reportsGroup;
   //	}
   public GradingsGroup getGradingsGroup() {
      return gradingsGroup;
   }

   public CategoryGroup getCategoryGroup() {
      return categoryGroup;
   }

}
