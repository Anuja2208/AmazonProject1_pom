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
        String username1 = s1.getRow(1).getCell(2).getStringCellValue();
        // Column 'Password' (Excel D, POI 3)
        String password1 = s1.getRow(1).getCell(3).getStringCellValue();

        // --- Reading the SECOND data row (Excel Row 3, POI index 2) ---
        // Note: Your screenshot shows only username/email and password for the second row.
        // If 'Name' and 'Mobileno' are truly blank for the second data set, you might need
        // to handle nulls or empty strings, or adjust your test logic.
        // For now, I'll assume you only want the username/password for the second set.
        // If there are 'Name' and 'Mobileno' in Excel Row 3 Column A and B, read them similarly.

        // If you intended the second row to be full data:
        // String name2 = s1.getRow(2).getCell(0).getStringCellValue(); // Assuming name in Col A, Row 3
        // String mob_no2 = NumberToTextConverter.toText(s1.getRow(2).getCell(1).getNumericCellValue()); // Assuming mob_no in Col B, Row 3

        String username2 = s1.getRow(2).getCell(2).getStringCellValue();
        String password2 = s1.getRow(2).getCell(3).getStringCellValue();


        // Create an array to hold 2 rows of data, with 4 columns (name, mob_no, username, password)
        // If your test only uses username/password, you might change the column count to [2][2]
        // and adjust the data population below.
        Object[][] data = new Object[2][4];

        // Populate the first row of the DataProvider with data from Excel Row 2
        data[0][0] = username1; // Maps to first parameter of test method
        data[0][1] = password1; // Maps to second parameter of test method
        data[0][2] = name1;     // Maps to third parameter of test method
        data[0][3] = mob_no1;   // Maps to fourth parameter of test method

        // Populate the second row of the DataProvider with data from Excel Row 3
        // Note: For the second record, your screenshot only shows username/email and password.
        // If name2 and mob_no2 are genuinely empty in Excel Row 3, they will come as empty strings
        // or you would need to handle nulls if getCell() returns null for truly empty cells.
        // For simplicity, I'm passing empty strings for name2 and mob_no2 in this example,
        // as your screenshot doesn't show data in A3 and B3 for the second record.
        data[1][0] = username2;
        data[1][1] = password2;
        data[1][2] = ""; // Assuming name is empty for the second record from screenshot
        data[1][3] = ""; // Assuming mob_no is empty for the second record from screenshot


        // Close the workbook and input stream to release resources
        wb.close();
        f1.close();

        return data;
    }
}
	


	
