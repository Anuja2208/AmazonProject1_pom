package AmazonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class TestData_Regi 
{
	public static String stringdata(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
        FileInputStream f1 = new FileInputStream("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\DataForTest\\AnujaDDT.xlsx");
        Workbook wb = WorkbookFactory.create(f1);
        String data=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	
	}
	public static String Numericdata(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
        FileInputStream f1 = new FileInputStream("C:\\Users\\ganesh\\eclipse-workspace\\AmazonProject1\\DataForTest\\AnujaDDT.xlsx");
        Workbook wb = WorkbookFactory.create(f1);
        String data=NumberToTextConverter.toText( wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue());
		return data;
	//for username(TestData.Numericdata("LoginDetails", 1, 0));
	//	for pwd
	//	login.userpassword(TestData.Numericdata("LoginDetails", 1, 1));
	}

}
