package com.first.pages.productpages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.first.configs.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;
import com.first.uiframework.MouseUtils;
import com.first.utils.xmlUtils;

public class LoginPage extends BasePage {
	//1.元素
    private Alert alert;
   //2.构造方法 
	public LoginPage(WebDriver dr)  {
		super(dr);
		openWeb(LocalConfig.URL);
		driver.get(LocalConfig.URL);
	}
	//单操作,只做动作不做业务
	   Locator usernameInputbox =getLocator("usernameInputbox"); 
	   Locator passwordInputbox =getLocator("passwordInputbox");
	   Locator loginButton =getLocator("loginButton");
	
	   public void inputUserName(String name){
		 input(usernameInputbox,name);  
	   }

	   public void inputPassWord(String password){
		 input(passwordInputbox,password);  
	   }
	   
	   public void clickLoginButton(){
		   click(loginButton);
	   }   
//------------------------------------------------------------------
//	   public MainPage loginOperate(String name,String password){
//		input(usernameInputbox,name);
//		input(passwordInputbox,password);
//		click(loginButton);
//		wait(3);
//		return new MainPage(driver);
//	}
//	   public String loginFailOperate(String name,String password){
//		   wait(3);
//		   input(usernameInputbox,name);
//		   input(passwordInputbox,password);
//		   click(loginButton);
//		   wait(3);
//		   String value=getAlertText();
//		   System.out.println(value);
//		   alertsAccept();
//		return value;
//	   }
//	public void aaa(){
//		MouseUtils mouse =new MouseUtils(driver);
//		mouse.doubleClick(findElement(loginButton));
//	}
//	public void bbb(){
//		mouse.doubleClick(findElement(loginButton));
//	}
}
//改造前
//public class LoginPage {
//	//1.元素
//      private WebDriver driver;
//      private WebElement usernameInputBox;
//      private WebElement passwordInputBox;
//      private WebElement loginButton;
//     //2.构造方法 
//      public LoginPage(WebDriver dr){
//    	  this.driver=dr;
//    	  //driver.get("http:192.168.0.106/zentao");
//    	  driver.get(LocalConfig.URL);//properties类封装改造后
//    	  usernameInputBox=driver.findElement(By.cssSelector("input#account"));
//    	  passwordInputBox=driver.findElement(By.cssSelector("input[name='password']"));
//    	  loginButton=driver.findElement(By.cssSelector("button#submit"));
//      }
//      
//	 public WebDriver getDriver(){
//		return driver; 
//	 }
//	 //4.登录成功
//	 public MainPage loginOperate(String name,String password) throws Exception{
// 		 usernameInputBox.sendKeys(name);
// 		 passwordInputBox.sendKeys(password);
// 		loginButton.click();
// 		wait(3);
//		return new MainPage(getDriver());
// 	 }
//	 //登录失败的方法，如果登录失败，返回提示消息
//	 public String loginFailOperate(String name,String password) throws Exception{
//		 usernameInputBox.sendKeys(name);
//		 passwordInputBox.sendKeys(password);
//		 loginButton.click();
//		 wait(3);
//		 //创建一个提示窗口对象
//		 Alert alert=driver.switchTo().alert();
//		 String value=alert.getText();
//		 System.out.println(value);
//		 //提示框上点确认
//		 alert.accept();
//		return value;
//		 
//	 }
//	 public void wait(int s){
//		 try {
//			Thread.sleep(s*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	 }
//	
//}