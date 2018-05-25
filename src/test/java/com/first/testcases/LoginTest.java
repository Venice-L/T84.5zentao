package com.first.testcases;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.first.actions.LoginOperate;
import com.first.pages.productpages.LoginPage;
import com.first.pages.productpages.MainPage;
import com.first.uiframework.DriverFactory;
import com.first.utils.AssertUtils;
import com.first.utils.ExeclUtils;
import com.first.utils.TestCase;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils=null;//改造
	@BeforeMethod
	public void setup() throws Exception{
		assertUtils=new AssertUtils();
		System.setProperty("webdriver.chrome.driver","D:\\Google\\Chrome\\Application\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver= DriverFactory.getChromeDriver();//日志：杀死浏览器进程
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	//登录成功
  @Test
  public void loginTest01() throws Exception {
//	  LoginPage lp=new LoginPage(driver); //改装前
//	  MainPage mp=lp.loginOperate("admin", "Lv931704912");
	  List<TestCase> testcases =ExeclUtils.getUITestData("UITestData.xlsx");//从excel中获取
	  HashMap<String,String> testdata =(HashMap<String, String>) testcases.get(0).getTestdata();
	 LoginOperate.setDriver(driver);
	 String value=LoginOperate.getLoginName(testdata.get("username"), testdata.get("password"));
//	  MainPage mp=LoginOperate.LoginSuess("admin", "Lv931704912");
//	  String value=mp.getLoginUsername();
	 Assert.assertEquals(testcases.get(0).getExpectedResult(),true,"登录测试失败");
  }
//登录失败，同理
  @Test
  public void loginTest02() throws Exception {
	  LoginPage lp=new LoginPage(driver);
	 //String value=lp.loginFailOperate("admin", "lv931704912");
	  String value=LoginOperate.getLoginName("admin", "lv931704912");
	  assertUtils.checkStringContains(value, "登录失败","登录测试失败");//将断言封装后
  }
  @AfterMethod()
  public void tearDowm() throws Exception{
	  Thread.sleep(3000);
	  driver.quit();
  }
  
}
