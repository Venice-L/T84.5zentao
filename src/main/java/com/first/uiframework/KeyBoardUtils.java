package com.first.uiframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
//键盘事件操作封装
public class KeyBoardUtils {
    private Actions action;
    public KeyBoardUtils(WebDriver dr){
    	action=new Actions(dr);
    }
    //ctrl+A;ctrl+v
    //向下的按键
    public void pressDown(int times){
    	Robot robot;
    	try {
			robot =new Robot();
			for(int i=0;i<times;i++){
	    		robot.keyPress(KeyEvent.VK_DOWN);
					Thread.sleep(1000);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	}
    }
   
