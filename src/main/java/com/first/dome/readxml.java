package com.first.dome;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType;
import com.first.utils.xmlUtils;


public class readxml {

	public static void main(String[] args) throws DocumentException {
//		HashMap<String, Locator> ls=xmlUtils.readElementInfo("LoginPage.xml");
//		   ls.get("fantiLink").getElementName();
		//------------------------------------------
		//写一个完整的文件路径
		String xfp=System.getProperty("user.dir")+"/webelementdata/LoginPage.xml";
		
		System.out.println(xfp);
		//使用Map存放数据
		Map<String,Locator> elementinfos=new HashMap<String,Locator>();
			SAXReader saxreader=new SAXReader();
			Document document =saxreader.read(new File(xfp));
			Element root =document.getRootElement();//取得根元素，这个根元素具体是什么不用管，通过它来取得下面的子元素
			List<Element> childList =root.elements("loactor");//取子元素
			for(Element e:childList){
				String elementName=e.attributeValue("name"); //元素名称
				 String locatorinfo=e.attributeValue("value");//元素定位信息
				 int timeOut=Integer.parseInt(e.attributeValue("timeout"));// 等待超时时间
				 ByType byType=getType(e.attributeValue("type"));//识别方法

				 Locator locator=new Locator(elementName,byType,timeOut,locatorinfo);
				String keyName =e.getText();//键名
				elementinfos.put(keyName, locator);//往Map中插入数据
			}
	//System.out.println(elementinfos.get("usernameInputbox").getElementName());//这里getElementName是调用get方法
	}

	private static ByType getType(String value) {
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
		}	
		return byType;	
	}
}
