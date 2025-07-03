package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop = null;
	private static ThreadLocal<String> browserType = new ThreadLocal<String>();
	//private static String browserType = null;

	public static void setBrowserType(String browser) {
		browserType.set(browser);
		//browserType = browser;
	}

	public static String getBrowserType() {
		return browserType.get();
		//return browserType;
	}
	public static String getProperty(String key) {

		if (prop == null)
			intializeProperties();
		return prop.getProperty(key);

	}

	public static Properties intializeProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/Config/Config.properties");
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String baseUrl()
    {    	
         String BaseURL=prop.getProperty("baseURL");
         if (BaseURL != null)
            return BaseURL;
         else
             throw new RuntimeException("URL not specified in the Config.properties file");
    }
	
	public static String loginUrl()
    {    	
         String loginUrl=prop.getProperty("loginURL");
         if (loginUrl != null)
            return loginUrl;
         else
             throw new RuntimeException("URL not specified in the Config.properties file");
    }

	// Email
    public static String loginEmail()
    {    	
    	 String LoginEmail = prop.getProperty("email");
    	 if (LoginEmail != null)
		    return LoginEmail;
    	 else
    		 throw new RuntimeException("Email not specified in the Config.properties file");
    }
    
	// Invalid Email
    public static String invalidLoginEmail()
    {    	
    	 String invalidEmail = prop.getProperty("invalidEmail");
    	 if (invalidEmail != null)
		    return invalidEmail;
    	 else
    		 throw new RuntimeException("Invalid Email not specified in the Config.properties file");
    }
    // Password
    public static String password()
    {    	
    	 String loginPassword=prop.getProperty("password");
    	 if (loginPassword != null)
		    return loginPassword;
    	 else
    		 throw new RuntimeException("Password not specified in the Config.properties file");
    }
    
    public static String homeUrl()
    {    	
         String homeUrl=prop.getProperty("homeURL");
         if (homeUrl != null)
            return homeUrl;
         else
             throw new RuntimeException("URL not specified in the Config.properties file");
    }
    
    public static String newEmail()
    {    	
         String newEmail=prop.getProperty("newEmail");
         if (newEmail != null)
            return newEmail;
         else
             throw new RuntimeException("new email not specified in the Config.properties file");
    }
    
    // Fullname
    public static String OnboardingFullname()
    {    	
    	 String OnboardingFullname=prop.getProperty("OnboardingFullname");
    	 if (OnboardingFullname != null)
		    return OnboardingFullname;
    	 else
    		 throw new RuntimeException("Onboarding fullname not specified in the Config.properties file");
    }
    
    // NewUsername
    public static String OnboardingUsername()
    {    	
    	 String OnboardingUsername=prop.getProperty("OnboardingUsername");
    	 if (OnboardingUsername != null)
		    return OnboardingUsername;
    	 else
    		 throw new RuntimeException("Onboarding Username not specified in the Config.properties file");
    }
    
    // NewPassword
    public static String OnboardingPassword()
    {    	
    	 String OnboardingPassword=prop.getProperty("OnboardingPassword");
    	 if (OnboardingPassword != null)
		    return OnboardingPassword;
    	 else
    		 throw new RuntimeException("Onboarding Password not specified in the Config.properties file");
    }

	public static String uploadBloodReportURL() {
		String bloodReportUrl=prop.getProperty("uploadBloodReportURL");
   	 if (bloodReportUrl != null)
		    return bloodReportUrl;
   	 else
   		 throw new RuntimeException("New Password not specified in the Config.properties file");
	}
	
	public static String onboardingURL() {
		String onboardingURL=prop.getProperty("onboardingURL");
   	 if (onboardingURL != null)
		    return onboardingURL;
   	 else
   		 throw new RuntimeException("New Password not specified in the Config.properties file");
	}

	
}
