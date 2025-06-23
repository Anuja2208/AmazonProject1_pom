package AmazonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;

public class DataSheetForRegistration 
{
	String un1; String pwd1;
	String name;String mob_no;
	
	@DataProvider(name = "loginData1")
    public Object[][] loginData() throws EncryptedDocumentException, IOException {

		FileInputStream f1 = new FileInputStream("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\DataForTest\\AnujaDDT.xlsx");
        Workbook wb = WorkbookFactory.create(f1);
        Sheet s1 = wb.getSheet("LoginDetails"); // Assuming your sheet name is "LoginDetails"

        // --- Reading the FIRST data row (Excel Row 2, POI index 1) ---
        // Column 'Name' (Excel A, POI 0)
         String name1 = s1.getRow(1).getCell(0).getStringCellValue();
        // Column 'Mobileno' (Excel B, POI 1) - It's numeric, convert to text
        String mob_no1 = NumberToTextConverter.toText(s1.getRow(1).getCell(1).getNumericCellValue());
        // Column 'Username/Email' (Excel C, POI 2)
        String un1 = s1.getRow(1).getCell(2).getStringCellValue();
        // Column 'Password' (Excel D, POI 3)
        String pwd1 = s1.getRow(1).getCell(3).getStringCellValue();

       
        Object[][] data = new Object[1][3];

        // Populate the first row of the DataProvider with data from Excel Row 2
        data[0][0] = name1; // Maps to first parameter of test method
        data[0][1] = mob_no1; // Maps to second parameter of test method
        data[0][2] = un1;
        data[0][3] = pwd1;     // Maps to third parameter of test method
      
        wb.close();
       f1.close();

        return data;
	}

}
