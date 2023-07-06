package excelHandling;

import utility.ExcelLib;

public class TestExcelLib {

	public static void main(String[] args) {
		
		ExcelLib xl = new ExcelLib("./testData/ExcelData.xlsx");
		int count = xl.getRowCount("TestData");
		System.out.println(count);
		
		for(int i=0; i< count; i++)
		{
			String row = xl.getCellData("TestData", i, 0);
			String col = xl.getCellData("TestData", i, 1);
			System.out.println(row + "   :    " + col);

		}
	}

}
