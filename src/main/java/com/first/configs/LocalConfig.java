package com.first.configs;

import com.first.utils.PropertiesUtils;

//properties类封装
public class LocalConfig {
	//将dome类再次封装
    static PropertiesUtils propertiesUtils=new PropertiesUtils("local.properties");//读取配置文件
    public static final String URL=propertiesUtils.getPropertieValue("url");//读取url
   //webdriver类封装
    public static final String//获取驱动
    chromeDriverPath=propertiesUtils.getPropertieValue("chromeDriverPath");
    public static final String fireFoxDriver=propertiesUtils.getPropertieValue("fireFoxDriver");
    public static final String ieFoxDriver=propertiesUtils.getPropertieValue("ieFoxDriver");
    public static final String SCRRNSHORTPATH=propertiesUtils.getPropertieValue("shotPath");
}
