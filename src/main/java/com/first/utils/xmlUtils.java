package com.first.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType;

public class xmlUtils {
	
	public static HashMap<String,Locator> readElementInfo(String filepath) throws
	DocumentException{
	//	String xmlFilePath=System.getProperty("user.dir")+"/webelementdata/LoginPage.xml";
	//	System.out.println(xmlFilePath);
		
		//目标提取xml里面的数据，存入一个MAP
		Map<String,Locator> elementsinfos=new HashMap<String,Locator>();
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(filepath));
		
		//提取根节点
		Element root = document.getRootElement();
		List<Element> childList = root.elements("locator");
		//把List里面的数据存放到map
		for(Element e:childList){
			 String elementName=e.attributeValue("name"); //元素名称
			 String locatorinfo=e.attributeValue("value");//元素定位信息
			 int timeOut=Integer.parseInt(e.attributeValue("timeout"));// 等待超时时间
			 ByType byType=getType(e.attributeValue("type"));//识别方法
           
			 Locator locator=new Locator(elementName,byType,timeOut,locatorinfo);//键值
			 String keyName=e.getText(); //键名
			 
			 elementsinfos.put(keyName, locator);//往Map中插入数据
		}
		return (HashMap<String, Locator>) elementsinfos;
				
	}
	
	//将字符串转换为枚举类型
		public static ByType getType(String value){
			ByType byType=null; 
			switch(value){
			case "css":
				byType=ByType.cssSelector;
				break;
			case "xpath":
				byType=ByType.xpath;
				break;
			case "id":
				byType=ByType.id;
				break;
			case "linkText":
				byType=ByType.linkText;
				break;
			case "name":
				byType=ByType.name;
				break;
			case "className":
				byType=ByType.className;
				break;
			case "partialLinkText":
				byType=ByType.partialLinkText;
				break;
			case "tagName":
				byType=ByType.tagName;
				break;
				default:
					System.out.println("识别方法不存在，请检查！！！");
			}	
			return byType;	
		}
}