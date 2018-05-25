package com.first.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.first.uiframework.DriverFactory;
import com.first.utils.AssertUtils;

public class NewTest {
	WebDriver driver;
	AssertUtils assertUtils=null;
	@BeforeTest
	public void setUp(){
		try{
	    int[] i={1,2,3,4,5};
	    int b=i[8];   //初始化异常   //监控代码
		}catch(Exception e){
			Assert.fail("error:初始化报错，不执行后面的代码");//绝对报错
		}
	}
	@BeforeMethod
	public void setup(){
		try{
		assertUtils=new AssertUtils();
		driver =DriverFactory.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail("初始化报错，不执行后面的代码！");
		}
	}
  @Test
  public void f() {
	 //    int[] i={1,2,3,4,5};
	 //    int b=i[8];   //执行业务代码中异常
	  Assert.assertEquals(2, 1);  //断言异常
  }
  @Test
  public void f2(){
	  Assert.assertEquals(1,1);
  }
  @AfterTest()
  public void testDome(){
	  int[] i={1,2,3,4,5};
	  int b=i[8]; //测试后期清理过程中异常
  }
  @AfterMethod()  //@AfterMethod中有异常，影响后面的测试用例的执行
  public void tearDome(){
	  int[] i={1,2,3,4,5};
	  int b=i[8];  //测试后期清理过程中异常
  };
  
}
