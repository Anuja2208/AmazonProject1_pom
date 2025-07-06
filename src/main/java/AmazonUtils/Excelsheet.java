package AmazonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;

public class Excelsheet 
{
	String un1; String pwd1;
	String un2; String pwd2;
	
	@DataProvider(name = "loginData1")
    public Object[][] loginData() throws EncryptedDocumentException, IOException {

		FileInputStream f1 = new FileInputStream("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\DataForTest\\AnujaDDT.xlsx");
        Workbook wb = WorkbookFactory.create(f1);
        Sheet s1 = wb.getSheet("LoginDetails"); // Assuming your sheet name is "LoginDetails"

        // --- Reading the FIRST data row (Excel Row 2, POI index 1) ---
        String un1 = s1.getRow(1).getCell(0).getStringCellValue();        // Column 'Username/Email' (Excel C, POI 2)
        String pwd1 = s1.getRow(1).getCell(1).getStringCellValue();     // Column 'Password' (Excel D, POI 3)

        // --- Reading the SECOND data row (Excel Row 3, POI index 2) ---
      //  String un2 = s1.getRow(2).getCell(0).getStringCellValue();
      //  String pwd2 = s1.getRow(2).getCell(1).getStringCellValue();
        
        // Create an array to hold 2 rows of data, with 2 columns (username, password)
        Object[][] data = new Object[1][2];
        
        //first row of the DataProvider with data from Excel Row 2
        data[0][0] = un1; // Maps to first parameter of test method
        data[0][1] = pwd1; // Maps to second parameter of test method

        // Populate the second row of the DataProvider with data from Excel Row 3
    //    data[1][0] = un2;
    //    data[1][1] = pwd2;
   
        // Close the workbook and input stream to release resources
        wb.close();
        f1.close();

        return data;

    }
}
	


	