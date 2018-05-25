package com.first.uiframework;

public class Locator {
  //枚举类型，元素定位方法使用
	public enum ByType{
		xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName
	}
	private String elementName;  //元素名称
	private String locatorinfo;  //元素定位信息
	private int timeOut;  //等待超时时间
	private ByType byType;//识别方法
	
	public Locator(String name ,ByType byType,int waitSec,String element){
		this.elementName=name;
		this.byType=byType;
		this.timeOut=waitSec;
		this.locatorinfo=element;
	}
	
	public String getElementName(){
		return elementName;
	}

	public String getLocatorinfo() {
		return locatorinfo;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public ByType getByType() {
		return byType;
	}
	
}
