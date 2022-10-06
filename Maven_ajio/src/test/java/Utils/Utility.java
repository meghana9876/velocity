package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	private static String value;
	private static double d;
	public static void captureScreenshot(WebDriver driver,double testID) throws IOException
	{ 	
		String path="C:\\Users\\MB\\Desktop\\velocity\\ajio_Screenshot";
		String time=new SimpleDateFormat("dd-MM-yyyy hh.mm.ss").format(new Date());
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest= new File(path+testID+time+" .jpeg");
		 FileHandler.copy(src, dest);
	}

	public static String get_ExcelData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\MB\\Desktop\\velocity\\ajio.xlsx";
		FileInputStream file= new FileInputStream(path);
		Workbook w=WorkbookFactory.create(file);
		try {
			value=w.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		System.out.println(value);
		}
		catch(IllegalStateException e)
		{
			double d=w.getSheet("sheet").getRow(row).getCell(cell).getNumericCellValue();
			value=Double.toString(d);
			return value;
		}
		return value;
	}
}

