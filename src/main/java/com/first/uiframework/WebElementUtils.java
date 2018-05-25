package com.first.uiframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.first.uiframework.Locator.ByType;
import com.first.utils.xmlUtils;



//元素操作封装
public class WebElementUtils extends DriverUtils {
	protected HashMap<String,Locator> locatorMap;//用例存放从xml读取到的数据
	 protected String path;   //xml文件路径+文件名                                        
	//1.构造方法
	public WebElementUtils(WebDriver dr){
		super(dr);
		        try {//处理每个page页面读取自己的xml文件
		        	path=System.getProperty("user.dir")+"/webelementdata/" 
						+this.getClass().getSimpleName()+".xml"; 
		        	locatorMap=xmlUtils.readElementInfo(path);
				} catch (Exception e) {
					e.printStackTrace();
				}                 
	}
   //封装点击、输入、查找元素、获取元素属性、获取元素文本
	//2.获取元素：使用识别方式和值
	//public WebElement getElement(String by,String locatorValue){
	public WebElement getElement(Locator locator){/**改造后**/
		WebElement el=null;
		ByType type=locator.getByType();/**改造后**/
		String locatorValue=locator.getLocatorinfo();
		try{
		switch(type){
		case id:
			el=driver.findElement(By.id(locatorValue));
			break;
		case name:
			el=driver.findElement(By.name(locatorValue));
			break;
		case xpath:
			el=driver.findElement(By.xpath(locatorValue));
			break;
		case cssSelector:
			el=driver.findElement(By.cssSelector(locatorValue));
			break;
		case className:
			el=driver.findElement(By.className(locatorValue));
		    break;
		case linkText:
			el=driver.findElement(By.linkText(locatorValue));
			break;
		case partialLinkText:
		    el=driver.findElement(By.partialLinkText(locatorValue));
		    break;
		case tagName:
			el=driver.findElement(By.tagName(locatorValue));
			break;
		default:
			System.out.println("元素未识别到！");
			break;
	}	
		}catch(Exception e){
			log.error("元素："+locator.getElementName()+"识别异常");
			takeScreenShot("findElementErrorImage");//截图		
			Assert.fail("查找元素异常，退出当前测试用例");//直接断言失败
		}
		return el;	
  }
	//3.查找元素：显式等待查找元素
	//public WebElement findElement(final String by,final String locatorValue){
	public WebElement findElement(final Locator locator){
		WebDriverWait wait=new WebDriverWait(driver,locator.getTimeOut());
		WebElement el=wait.until(new ExpectedCondition<WebElement>(){
			@Override
			public WebElement apply(WebDriver d){
				return getElement(locator);
			}
		});
		return el;	
	}
	//4.封装元素点击操作
	public void click(Locator locator){
		WebElement e=findElement(locator);
		e.click();
		log.info("点击元素 "+locator.getElementName());
	}
	//5.元素输入数据
	public void input(Locator locator,String content){
		WebElement e=findElement(locator);
		e.sendKeys(content);
		log.info("在元素 "+locator.getElementName()+" 输入："+content);
	}
	//6.提交表单
	public void summit(Locator locator){
		WebElement e=findElement(locator);
		e.submit();
	}
	//7.文本框清除数据
	public String getText(Locator locator){
		WebElement e=findElement(locator);
		log.info("获取元素： "+locator.getElementName()+"文本值");
		return e.getText();	
	}
	//8.获取元素属性
	public String getAttribute(Locator locator,String attribute){
		WebElement e=findElement(locator);
		return e.getAttribute(attribute);
	}
	//重点:通过页面按钮的名称提取locator
	public Locator getLocator(String locatorName){
		Locator locator=locatorMap.get(locatorName);
		return locator;
	}
}
