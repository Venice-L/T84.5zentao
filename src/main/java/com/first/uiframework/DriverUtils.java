package com.first.uiframework;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.first.configs.LocalConfig;
import com.first.utils.Log;
//webdriver操作封装
public class DriverUtils {
	protected WebDriver driver;//webDriver操作封装改造
	protected static MouseUtils mouse;//鼠标封装改造
	protected static KeyBoardUtils keyBoard;//键盘封装改造
	protected static Log log =new Log(DriverUtils.class);
	
	public DriverUtils(WebDriver dr){
		 driver=dr;
		 mouse=new MouseUtils(dr);
		 keyBoard=new KeyBoardUtils(dr);
	}
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址");
	}
	public void back(){
		driver.navigate().forward();
		log.info("返回上一页");
	}
	public void wait(int s){
		try {
			Thread.sleep(s*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getTitle(){
		return driver.getTitle();		
	}
    public String getCurrentUrl(){
		return getCurrentUrl();	
    }
    public void takeScreenShot(String...pngName){
    	String fileName;
    	String filePath =LocalConfig.SCRRNSHORTPATH;
    	File file =new File(filePath);
    	if(!file.exists()){
    		file.mkdir();
    	}
    	if(pngName.length ==0){
    		fileName ="shotImage";
    	}else{
    		fileName = pngName[0];
    	}//截图
    	SimpleDateFormat sf =new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    	Calendar cal= Calendar.getInstance();
    	Date date = cal.getTime();
    	String dateStr =sf.format(date);
    	String path= "\\"+filePath+"\\"+fileName+"_"+dateStr+".png";
    	takeScreenShot(driver,path);
    }
	private void takeScreenShot(WebDriver drivername, String path) {
		String currentPath =System.getProperty("user.dir");//get current work
		File scrFile =((TakesScreenshot)drivername).getScreenshotAs(OutputType.FILE);
	    File picFile=new File(currentPath+path);
	    try{
	    FileUtils.copyFile(scrFile,picFile);
	    log.info("截图成功，图片保存路径为："+currentPath+path);
	    }catch(Exception e){ 
	      log.error("截图失败");
	    }
	    log.screenShotLog("截图："+scrFile,picFile);
	}
}
