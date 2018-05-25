package com.first.dome;

import java.util.Map;

import org.dom4j.DocumentException;

import com.first.uiframework.Locator;
import com.first.utils.xmlUtils;

public class readxmlTest {

	public static void main(String[] args) throws DocumentException {
		Map<String,Locator> els =xmlUtils.readElementInfo("F:\\filexml\\LoginPage.xml");
		for(String key:els.keySet()){
			System.out.print("控件名称："+els.get(key).getElementName());
			System.out.print("，识别方法："+els.get(key).getByType());
			System.out.print("，等待时间："+els.get(key).getLocatorinfo());
			System.out.println("，识别数据："+els.get(key).getTimeOut());
		}

	}

}
