package pageUIs.user;

public class RegisterPageUI {
    public static final String GENDER_RADIO_BUTTON = "xpath=//input[@id='gender-male']";
    public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "xpath=//input[@id='LastName']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String NEWSLETTER_CHECKBOX = "xpath=//input[@id='Newsletter']";
    public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
    public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";


    public static final String FIRSTNAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
    public static final String LASTNAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
    public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";
    public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
    public static final String CONFRIM_PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
    public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
    public static final String EXISTING_EMAIL_MESSAGE = "xpath=//div[contains(@class,'message-error')]//li";


}
