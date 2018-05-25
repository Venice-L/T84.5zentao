package com.first.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//鼠标事件操作封装
public class MouseUtils {
    private  WebDriver driver;
    private Actions action;
    
    public MouseUtils(WebDriver dr){
    	//this.driver=dr;
    	action =new Actions(dr);
    }
    //双击、点击、拖动、悬停
    //鼠标右击
    public void rightClick(WebElement e){
    	//Actions action=new Actions(driver);
    	action.contextClick(e).perform();
    	
    }
    //鼠标双击
    public void doubleClick(WebElement e){
    	action.doubleClick(e).perform();
    }
}
