package com.first.uiframework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

//页面操作封装
public class BasePage extends WebElementUtils {
    public BasePage(WebDriver dr){
    	super(dr);
    }
	//1.获取网页源代码，js弹出窗 frame
    public String getPageSource(){
    	wait(3);
		return driver.getPageSource();
    }
    //2.提示框确定
    public void alertsAccept(){
    Alert alter=driver.switchTo().alert();
    alter.accept();
    }
    //3.提示框取消
    public void alertsdismiss(){
    	Alert alert=driver.switchTo().alert();
    	alert.dismiss();
    }
    //4.获取提示框里面的文本信息
    public String getAlertText(){
    	Alert alert=driver.switchTo().alert();
		return alert.getText();
    }
    //5.向提示框中输入数据
    public void inputAlert(String value){
    	Alert alert=driver.switchTo().alert();
    	alert.sendKeys(value);
    }
}
