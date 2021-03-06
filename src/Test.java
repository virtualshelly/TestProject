import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//written by Shelly Falconer

public class Test {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait myWaitVar = new WebDriverWait (driver, 5);
		
		//instantiate variables
		String baseUrl = "https://omayo.blogspot.com/";
		String actualTitle;
		String expectedTitle = "omayo (QAFox.com)";
		String addedText = "I love web pages!";
		
        //using get() method, launch browser then navigate to URL variable
        driver.get(baseUrl);
        
        //timeout exception to add text
        try {
        	//set the expectation to wait until the element is seen
        	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("ta1")));
        	//get focus of the text box
        	driver.findElement(By.id("ta1")).click();
        	//send text to the text area box
        	driver.findElement(By.id("ta1")).sendKeys(addedText);
        }
        catch(TimeoutException toe) {
        	System.out.println(toe.toString());
        }
        
       //generic exception to copy text for compare
        try { 
        	//find the text area element again and get the text
        	WebElement textAreaTest = driver.findElement(By.id("ta1"));
        	String text = textAreaTest.getAttribute("value");
        	
        	//compare was failing b/c new line before I
        	text = text.replaceAll("[\\n]", "");
        	//System.out.println("text now = " + text);

        	//test the addedText was added
        		if (text.contentEquals(addedText)){
        			System.out.println("Text Area Test Passed!");
        		} else {
        			System.out.println("Test Area Test Failed");
        		}
        } catch(Exception ioe) {
        	System.out.println(ioe.toString());
        }
        
        //generic exception to find hidden button
        try {
        	driver.findElement(By.id("hbutton"));
        	//report hidden button was found
        	System.out.println("Hidden was button found!");
        } catch(Exception ioe) {
        	System.out.println(ioe.toString());
        }

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        //generic exception to compare actual to expected title
        try {
        	// if else pass or fail page title
        	if (actualTitle.contentEquals(expectedTitle)){
        		System.out.println("Page Title Test Passed!");
        	} else {
        		System.out.println("Page Title Test Failed");
        	}
        } catch(Exception ioe) {
        	System.out.println(ioe.toString());
        } finally {
            //close 1 Chrome window with close() method
            driver.close();
        }
	}
}

