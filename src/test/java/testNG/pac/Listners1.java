package testNG.pac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listners1 extends Validations implements ITestListener 
{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Got Pass");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test got fail");

		TakesScreenshot takescreenshot = (TakesScreenshot)sdriver;

		File src=takescreenshot.getScreenshotAs(OutputType.FILE);
		String pathname= "../SDET5/Screenshots/"+result.getMethod().getMethodName()+".PNG";
		File dest = new File(pathname);

		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test got skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("Test Styarted on Start");
	}

	public void onFinish(ITestContext context) 
	{
		System.out.println("Test Finish on finish");
	}


}
