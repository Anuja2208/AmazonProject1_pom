package AmazonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataForInvalid 
{
//	String un1; String pwd1;
	String un2; String pwd2;
	
	@DataProvider(name = "loginData1")
    public Object[][] loginData() throws EncryptedDocumentException, IOException {

		FileInputStream f1 = new FileInputStream("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\DataForTest\\AnujaDDT.xlsx");
        Workbook wb = WorkbookFactory.create(f1);
        Sheet s1 = wb.getSheet("LoginDetails"); // sheet name is "LoginDetails"

        String un2 = s1.getRow(2).getCell(2).getStringCellValue();
        String pwd2 = s1.getRow(2).getCell(3).getStringCellValue();
       
        Object[][] data = new Object[1][2];
        data[0][0] = un2; // Maps to first parameter of test method
        data[0][1] = pwd2; // Maps to second parameter of test method

        // Close the workbook and input stream to release resources
        wb.close();
        f1.close();

        return data;

    }

}
