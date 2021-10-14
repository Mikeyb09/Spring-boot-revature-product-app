package com.example.springbootrevatureproductapp;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerE2ESeleniumTest {
	
	private WebDriver driver;
	
	@LocalServerPort
	private int port;
	
	@Test
	public void testMessage() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		
		driver.get(String.format("http://127.0.0.1:%s/message", port));
		String result = driver.findElement(By.tagName("body")).getText();
		assertEquals("--Revature Training App--", result);
	}
	

}
