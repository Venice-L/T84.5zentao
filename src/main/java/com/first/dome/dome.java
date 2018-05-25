package com.first.dome;

import com.first.utils.PropertiesUtils;

public class dome {
	//properties类封装
	public static void main(String[] args) {
		//创建一个PropertiesUtils对象，并把参数的数据名传入
		PropertiesUtils propertiesUtils=new PropertiesUtils("local.properties");
		//使用PropertiesUtils提取我们需要的配置信息
		String url=propertiesUtils.getPropertieValue("url");
		System.out.println(url);
	//   WebDriver driver=DriverFactory.getChromeDriver();
	//   driver.get("https://www.baidu.com");
    //    String path=System.getProperty("user.dir");
     //   System.out.println(path+"\\Driver");
	}

}
