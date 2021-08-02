package week9.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datamaran {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("url");
		
		//to find number of rows
		
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='issue-bucket-mapping']/tr");
		int rowSize = rows.size();
		
		//to print from the second row leaving out the table header row
		
		for(int i=2;i<=rowSize;i++) {
		WebElement rows1 = driver.findElementByXPath("//table[@id='issue-bucket-mapping']/tr["+i+"]");
		String text = rows1.getText();
		System.out.println(text);
		}
		
		//to click on the link to go next page
		
		driver.findElementByLinkText("View Details (click here to go to page 2)").click();
				
		
		//dropdown //to click on the dropdown box arrow
		
		WebElement source = driver.findElementByXPath("//div[@class='dropdown']");
		//source.click();
		
		Select dropDown = new Select(source);

		List<WebElement> options = dropDown.getOptions();
		
		int size = options.size();
		System.out.println(size);
	
		
	for (WebElement dropdownlist : options) {
		String text = dropdownlist.getText();
		 System.out.println(text);	
		}
		  
		if(rows.equals(options)) {
			System.out.println("All elements are same");
				}
		else {
			System.out.println("Elements are not same");
		}
	}
	
	

}
