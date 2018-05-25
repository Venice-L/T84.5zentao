package com.first.uiframework;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.first.configs.LocalConfig;
import com.first.utils.Log;
//Webdriver封装
public class DriverFactory {
  private static WebDriver driver;
  static Runtime runtime=Runtime.getRuntime();
  private static Log log =new Log(DriverFactory.class);
  
//1.chrome的驱动
  public static WebDriver getChromeDriver(){
	  //1.1如果用例异常，怎么关闭之前的浏览器
	  try {//如果打开了多个chrome页面，先关闭之前可能出错的浏览器
		runtime.exec("taskkill/F/IM chrome.exe");
		log.info("杀死chrome浏览器进程成功");
	} catch (IOException e) {
		log.error("杀死进程出现异常");
	}
	  //1.2驱动位置路径问题
	  String DriverPath=System.getProperty("user.dir")+LocalConfig.chromeDriverPath;
	  System.setProperty("webdriver.chrome.driver", DriverPath);
	  
	  //1.3去掉启动时候的黄条提示框
	  ChromeOptions options=new ChromeOptions();
	  DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	  capabilities.setCapability("chrome.switches", 
			             Arrays.asList("--start-maximized"));
	  options.addArguments("--test-type","--start-maximized");
	  
	  driver=new ChromeDriver(options);
	return driver;
	  
  }
}
