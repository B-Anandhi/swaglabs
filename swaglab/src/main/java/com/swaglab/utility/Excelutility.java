/**
 * 
 */
package com.swaglab.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.swaglab.baseclass.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author banan
 *
 */


public class Excelutility extends BaseClass {

	@DataProvider(name="accountcreation")
	public Object[][] readExcel() 
	{
		File fi=new File(".\\src\\test\\resources\\TestData\\TestData.xlsx");
		FileInputStream path = null;
		try {
			path = new FileInputStream(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet= workbook.getSheet("AccountCreationData");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(0).getLastCellNum();
		  String[][] data= new String[rowCount][colCount];
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		try {
			path.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}

	

}
