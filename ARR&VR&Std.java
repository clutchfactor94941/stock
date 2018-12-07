package com.bert.assignment.ExcelReader;

 
import java.io.File;
 
import java.io.IOException;
 

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelHelper {
	public static void main(String[]args) throws BiffException, IOException, RowsExceededException, WriteException {
		
		  
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Bert\\Desktop\\test.xls"));
		 
		//1.To get the first sheet and the total rows and columns
		Sheet sheet = workbook.getSheet(0);
		int totalRows = sheet.getRows();
		//int totalCols = sheet.getColumns();
	    
		//someOthers
		System.out.println("total rows :"+totalRows);
		
		//2.Create an double array to save all the datas.
		 double[] datas = new double[totalRows];
		
		//3.use for() loop to read all the data
		int i=0,j=0;
		for(i=1;i<totalRows ;i++){
		//4.now assum thar there is only one Column data
	    //5. read data from cell 
			Cell cell = sheet.getCell(0,i); 
			String strData = cell.getContents();
			datas[j++] = Double.parseDouble(strData);
		}
		 
	
		 //6.process the datas ,count : the raw data number.
		int count =totalRows-1;
		//datas[count]= 0;
		double[] results=new double[count];
		double sum = 0.0; 
		double sum2=0.0;
		// the last index of the excel 
		   
		    
		for(i=0;i<count;i++) {
			if(i==count-1)
			{
				break;
			}
			results[i] = datas[i]/datas[i+1]-1;
			sum+=results[i];
			 
		}
		    
		System.out.println("sum is:"+sum);
		double ARR =(sum*100)/count ;
		
		  //7.Calculate the Variance
		for(i=0;i<totalRows-1;i++) {
			sum2 += (results[i]*100 - ARR)*(results[i]*100 - ARR);
		}
		double Variance = sum2/(count*10000);
		double stdDev = Math.sqrt(Variance);
		
		//output to the console.
		System.out.println("ARR:"+ARR);
		System.out.println("sum2:"+sum2+",,,sum:"+sum);
		System.out.println("StdDev:"+stdDev+"***Variance:"+Variance+",,,Length:"+datas.length);
		
		/*
		for(i=0;i<totalRows-1;i++) {
			 System.out.println(i+",,OutPut:"+results[i] +",,Origin:"+datas[i]);
		}
		*/
		 
		workbook.close();
		
		  //8.write the result datas to the workbook.
	    WritableWorkbook newbook = Workbook.createWorkbook(new File("C:\\Users\\Bert\\Desktop\\test.xls"));
		 WritableSheet sheet2 = newbook.createSheet("results", 0);
	   // WritableSheet sheet2 = newbook.getSheet(1);
		Label label = new Label(2,0,"Returns");
		sheet2.addCell(label);
		sheet2.addCell(new Label(3,0,"Variance"));
		sheet2.addCell(new Label(4,0,"stdDev"));
		sheet2.addCell(new Label(5,0,"ARR"));
		sheet2.addCell(new Label(3,1,Double.toString(Variance)));
		sheet2.addCell(new Label(4,1,Double.toString(stdDev)));
		sheet2.addCell(new Label(5,1,Double.toString(ARR)));
		
		
	    j=0;
		for(i=1;i<totalRows;i++) {
			Number number = new Number(2,i,results[j++]);
			sheet2.addCell(number);
		}
		
		//9.close the stream.
		newbook.write();
		newbook.close();        
		
		
		System.out.println("hello world .\n what I want is to live lively.");
     }
}
