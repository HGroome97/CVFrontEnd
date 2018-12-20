package com.qa.util;

public class Constants {
	//API ENDPOINTS
	public static final String LOGIN_API_URL_BASE = "http://localhost:8081/users";
	public static final String LOGIN_API_URL_CREATE = "/createUser";

	//REQUEST TYPES
	public static final String POST_REQUEST = "POST";
	
	//ROLES
	public static final String TRAINING_MANAGER_ROLE = "ROLE_TRAINING_MANAGER";
	public static final String TRAINING_MANAGER_HAS_ROLE = "hasRole('ROLE_TRAINING_MANAGER')";
	public static final String TRAINER_ROLE = "ROLE_TRAINER";
	public static final String TRAINER_HAS_ROLE = "hasRole('ROLE_TRAINER')";
	public static final String TRAINEE_ROLE = "ROLE_TRAINEE";
	public static final String TRAINEE_HAS_ROLE = "hasRole('ROLE_TRAINEE')";
	
	//URL ENDPOINTS
	public static final String LOGIN_URL = "/login";
	public static final String LOGIN_ERROR_URL = "/login?error=true";
	
	public static final String REGISTER_URL = "/register";
	public static final String HOMEPAGE_URL = "/homepage";
   
	public static final String TRAININGMANAGER_ADMINPAGE_URL = "/trainingmanager/adminpage";
	public static final String TRAININGMANAGER_CV_URL = "/trainingmanager/CV";
	public static final String TRAININGMANAGER_TRAINEES_EDITTRAINEES_URL = "/trainingmanager/trainees/edittrainees";
	public static final String TRAININGMANAGER_TRAINEES_ADDTRAINEES_URL = "/trainingmanager/trainees/addtrainees";
	public static final String TRAININGMANAGER_TRAINEES_VIEWTRAINEES_URL = "/trainingmanager/trainees/viewtrainees";
	public static final String TRAININGMANAGER_TRAINERS_EDITTRAINERS_URL = "/trainingmanager/trainers/edittrainers";
	public static final String TRAININGMANAGER_TRAINERS_ADDTRAINERS_URL = "/trainingmanager/trainers/addtrainers";
	public static final String TRAININGMANAGER_TRAINERS_VIEWTRAINERS_URL = "/trainingmanager/trainers/viewtrainers";
    
	public static final String TRAINER_CV_URL = "/trainer/CV";
	public static final String TRAINER_VIEWTRAINEES_URL = "/trainer/viewtrainees";
	public static final String TRAINER_TRAINERPAGE_URL = "/trainer/trainerpage";
    
	public static final String TRAINEE_ACCOUNT_URL = "/trainee/account";
	public static final String TRAINEE_CV_ADDCVS_URL = "/trainee/CV/addcvs";  
	public static final String TRAINEE_CV_VIEWCVS_URL = "/trainee/CV/viewcvs";
    
	public static final String ACCESS_DENIED_URL = "/accessDenied";
	
	public static final String TRAININGMANAGER_ACCESS_URL ="/trainingmanager/**";
	public static final String TRAINER_ACCESS_URL = "/trainer/**";
	public static final String TRAINEE_ACCESS_URL = "/trainee/**";
	
	
	//LOGIN FUNCTIONS
	public static final String PERFORM_LOGIN = "/perform_login";
	public static final String PERFORM_LOGOUT = "/perform_logout";
	
	//JDBC
	public static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/userbd";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "password";
	
	
	
}
