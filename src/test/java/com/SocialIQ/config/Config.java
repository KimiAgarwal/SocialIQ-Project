package com.SocialIQ.config;

import java.util.Random;

public class Config
{
	public static String CollaboratorEmail = "iqteam@pepsi.com";
	public static String UserListAdminUserFirstName = "Test";
	public static String UserListAdminUserLastName = "User";
	public static String UserListUserName = "testuser@pepsi.com";

	public static String FreeTrialPage_URL ="http://app.siq.qa2.intelligrape.net/company/freeTrialCreate";

	public static String Login_URL ="http://app.siq.qa2.intelligrape.net";

	public static String ResetPassword_URL ="http://app.siq.qa2.intelligrape.net/resetPassword/resetPassword?token=3e4509d0e318449392d64d9edcfb1f3b";

	public static String emailId = "kimiagarwal@gmail.com";
	
	public static String testmailid = "testusersocialiq@gmail.com";
	
	public static String testmailidpassword = "intelligrape";
	
	public static String offerCode = "Do-Not-Delete";
	
	public static String firstName = "Test";
	
	public static String lastName = "User";
	
	public static String companyName = "IG";
	
	public static String AdminExecutiveUserName = "raj@pepsi.com";
	
	public static String AdminExecutivePassword = "test";
	
	public static String GenerateUniqueEmailId(String emailId)
	{
		String randomString = generateARandomString();	
		return (randomString + emailId) ;
	}

	public static String generateARandomString()
	{
		String characters = "12345abcde";	
		Random random = new Random();

		char[] text = new char[2];
		for (int i = 0; i < 2; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }

		String randomString = new String(text);
		
		return randomString;
	}	
}
