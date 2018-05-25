package com.first.utils;
//读取Url
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//properties类封装
public class PropertiesUtils {
    private static Properties properties=null;
    private static String propertiesFileName=null;
    //构造函数
    public PropertiesUtils(String path){
    	this.propertiesFileName=path;
    }
    //提取值的方法
    public static String getPropertieValue(String keyName){
    	properties=new Properties();
    	InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream("com/first/configs/"+propertiesFileName);
    	String value=null;
    	try {
			properties.load(in);
			value=properties.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
    	
    }
}
