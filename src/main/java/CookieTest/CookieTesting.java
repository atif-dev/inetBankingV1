package CookieTest;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;





public class CookieTesting {
	
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.canva.com/login");
		
		
//		driver.manage().window().maximize();
		
		driver.get("https://www.canva.com/login");
		driver.findElement(By.id("__a11yId7")).click();
	    driver.findElement(By.id("__a11yId7")).sendKeys("14140042");
	    driver.findElement(By.id("__a11yId10")).click();
	    driver.findElement(By.id("__a11yId10")).sendKeys("");
	    driver.findElement(By.cssSelector(".ogth8A > .\\_38oWvQ")).click();
	    
//	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
//		driver.findElement(By.className("_1QoxDw Qkd66A fFOiLQ fP4ZCw o4TrkA zKTE_w Qkd66A fFOiLQ fP4ZCw lsXp-w ubW6qw GnpDIA zQlusQ uRvRjQ ogth8A")).click();
		
		//get cookies from browser
//		  Set <Cookie> cookies = driver.manage().getCookies(); 
		  
//		  System.out.println("Size of cookies: " + cookies.size());
		  
		   
		//read and print all cookies
//		  int i = 1;
//		  for(Cookie cookie:cookies) 
//		  	{
//		  System.out.println("Cookie# " + i + "==> " + cookie.getName() + ":" + cookie.getValue()); //will print name and value of the cookies 
//		  i++; 
//		  	}
		  
		  //Get cookie Value against cookie value
//		  System.out.println("Got cookie value against cookie name...");
//		  System.out.println(driver.manage().getCookieNamed(
//		  "gtm_custom_user_engagement_lock_4"));
		  
		  
		  //add Cookie 
//		  System.out.println("Adding Custom Cookie..."); 
//		  Cookie cookieObj = new Cookie("MyCookie_123", "123456789"); 
//		  driver.manage().addCookie(cookieObj);
//		  
//		  cookies = driver.manage().getCookies();
//		  
//		  System.out.println("Size of Cookies after adding new custom cookie: " + cookies.size());
		 
		  
		//read and print all cookies
//		  int a = 1; 
//		  for(Cookie cookie:cookies) 
//		  {
//		  System.out.println("Cookie# " + a + "==> " + cookie.getName() + ":" + cookie.getValue()); //will print name and value of the cookies 
//		  a++; 
//		  }
		  
		  //Delete Custom Cookie
//		  System.out.println("Deleting Custom Cookie...."); 
//		  driver.manage().deleteCookie(cookieObj);
//		  cookies =driver.manage().getCookies();
//		  
//		  System.out.println("Size of Cookies after deleting custom cookie: " + cookies.size());
		  
		//read and print all cookies after deleting custom cookie
//		  int b = 1; 
//		  for(Cookie cookie:cookies) 
//		  {
//		  System.out.println("Cookie# " + b + "==> " + cookie.getName() + ":" + cookie.getValue()); //will print name and value of the cookies 
//		  b++; 
//		  }
		  
		  //Delete all cookies
//		  System.out.println("Deleting all Cookies:");
//		  driver.manage().deleteAllCookies();
//		  cookies =driver.manage().getCookies();
//		  System.out.println("Size of Cookies after deleting all cookies: " + cookies.size());
		  
//		  driver.get("chrome://settings/cookies");
		 
//		  String radio1 = driver.findElement(By.className("cr-title-text")).getText();
//		  String radio1 = driver.findElement(By.tagName("h1")).getText();
//		  WebElement radio1 = driver.findElement(By.xpath("//*[text()='Block all cookies (not recommended)']"));
//		  WebElement radio1 = driver.findElement(By.name("3"));
//		  radio1.click();
	    
//	    WebDriverWait wait = new WebDriverWait(driver,30);
//	    wait.until(ExpectedConditions.titleIs("Home - Canva"));
	    
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
//		prefs.put("profile.block_third_party_cookies", True);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
//		
		ChromeDriver driver1 = new ChromeDriver(options);
		
		driver1.get("https://www.canva.com/login");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement e = driver1.findElement(By.xpath("//form/button"));
		
		 driver.navigate().refresh();
		
		boolean actualValue = e.isEnabled();
//		System.out.println(actualValue);
		 if (actualValue) {
		       System.out.println("Button is enabled");}
		else {
			System.out.println("Status: \n" + "Cannot Signin(Login button is disabled)");
			String message = driver1.findElement(By.className("eCRvjw")).getText();
			System.out.println("Canva Login page Alert message: "+ message);
			
			JavascriptExecutor js=(JavascriptExecutor)driver1; 
			js.executeScript("alert('Cookies are Disabled by Selenium Chrome Driver. You are not able to Login');");
//			driver.switchTo().alert().sendKeys("Text");
		}
			
		    
		      
//		Thread.sleep(2000);
//		prefs.put("profile.default_content_setting_values.cookies", 1);
//		  System.out.println(radio1);
	    
//		  driver.navigate().refresh();
//		   driver.close();
//		  
//		  driver.quit();
		 
	
		
		}

}