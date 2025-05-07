package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider 1
	
     @DataProvider(name="LoginData")
     public String [][] getData() throws IOException{
    	 String path = ".\\testdata\\login_data.xlsx";
    	 ExcelUtility xlutil = new ExcelUtility(path);
    	 int totalrows = xlutil.getRowCount("sheet1");
    	 int totalcols = xlutil.getCellCount("sheet1", 1);
    	 
    	 String loginData[][]= new String[totalrows][totalcols]; //2D array created to store the data from excel sheet
    	 
    	 for(int i=1;i<=totalrows;i++) { //to read the data from xl stored in 2D array
    		 for(int j=0;j<totalcols;j++) {
    			 loginData[i-1][j] = xlutil.getCellData("sheet1", i, j);
    			 
    		 }
    	 }
    	 return loginData;
    	 
     }
     
     //DataProvider2 Registerdata
     @DataProvider(name="RegisterData")
     public String [][] getRegData() throws IOException{
    	 String path = ".\\testdata\\reg_data1 1.xlsx";
    	 ExcelUtility xlutil = new ExcelUtility(path);
    	 int totalrows = xlutil.getRowCount("sheet1");
    	 int totalcols = xlutil.getCellCount("sheet1", 1);
    	 
    	 String RegData[][]= new String[totalrows][totalcols]; //2D array created to store the data from excel sheet
    	 
    	 for(int i=1;i<=totalrows;i++) { //to read the data from xl stored in 2D array
    		 for(int j=0;j<totalcols;j++) {
    			 RegData[i-1][j] = xlutil.getCellData("sheet1", i, j);
    			 
    		 }
    	 }
    	 return RegData;
    	 
     }
}
