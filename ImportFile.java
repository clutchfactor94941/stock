import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.lang.Exception;

public class ImportFile {

	private String fileName;
	private File newFile;
	private Stock stock=new Stock();
	
	private int size;
	private String[] dateArray;
	private double[] openArray;
	private double[] highArray;
	private double[] lowArray;
	private double[] closeArray;
	private ArrayList<Double> dividendList=new ArrayList<>();

	public ImportFile()
	{
		
	}
	
	public ImportFile(String fileName)
	{
		this.fileName=fileName;
		newFile=new File(fileName);
		getSize();
		createDateArray();
		createOpenArray();
		createCloseArray();
		createLowArray();
		createHighArray();
	}
	
	public void importData()
	{
		try {
			Scanner inputStream=new Scanner(newFile);
			stock.importName(inputStream.next());
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSize()
	{
		try {
			Scanner inputStream=new Scanner(newFile);
			size=0;
			inputStream.next();
			inputStream.next();
			while(inputStream.hasNext())
			{
				
				String data=inputStream.next();
				String[] values=data.split(",");
				if(values[0].equals("Dividend"))
				{
					dividendList.add(Double.parseDouble(values[1]));
				}
				else
				{
				size++;
				}
			}
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Optional<String []> createDateArray()
	{
		
		try {
			Scanner inputStream=new Scanner(newFile);
			getSize();
			if(size<2)
			{
				throw new FileNotFoundException();
			}
			dateArray=new String[size-2];
			inputStream.next();
			inputStream.next();
			
			int i=0;
			while(inputStream.hasNext())
			{
				String data=inputStream.next();
				String[] values = data.split(",");
				if(values[0].equals("Dividend")) 
				{
					
				}
				else
				{
				dateArray[i]=values[0];
				i++;
				}
			}
			return Optional.of(dateArray);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	
	public Optional<double []> createOpenArray()
	{
		
		try {
			Scanner inputStream=new Scanner(newFile);
			getSize();
			if(size<2)
			{
				throw new FileNotFoundException();
			}
			openArray=new double[size-2];
			inputStream.next();
			inputStream.next();
			
			int i=0;
			while(inputStream.hasNext())
			{
				String data=inputStream.next();
				String[] values = data.split(",");
				if(values[0].equals("Dividend")) 
				{
					
				}
				else
				{
				openArray[i]= Double.parseDouble(values[1]);
				i++;
				}
			}
			return Optional.of(openArray);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	
	public Optional<double[]> createHighArray()
	{
		
		try {
			Scanner inputStream=new Scanner(newFile);
			getSize();
			if(size<2)
			{
				throw new FileNotFoundException();
			}
			highArray=new double[size-2];
			inputStream.next();
			inputStream.next();
			
			int i=0;
			while(inputStream.hasNext())
			{
				String data=inputStream.next();
				String[] values = data.split(",");
				if(values[0].equals("Dividend")) 
				{
					
				}
				else
				{			
				highArray[i]= Double.parseDouble(values[2]);
				i++;
				}
			}
			return Optional.ofNullable(highArray);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public Optional<double []> createLowArray()
	{
		
		try {
			Scanner inputStream=new Scanner(newFile);
			getSize();
			if(size<2)
			{
				throw new FileNotFoundException();
			}
			closeArray=new double[size-2];
			inputStream.next();
			inputStream.next();
			
			int i=0;
			while(inputStream.hasNext())
			{
				String data=inputStream.next();
				String[] values = data.split(",");
				if(values[0].equals("Dividend")) 
				{
					
				}
				else
				{
				lowArray[i]= Double.parseDouble(values[3]);
				i++;
				}
			}
			return Optional.of(lowArray);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public Optional<double[]> createCloseArray()
	{
		
		try {
			Scanner inputStream=new Scanner(newFile);
			getSize();
			if(size<2)
			{
				throw new FileNotFoundException();
			}
			closeArray=new double[size-2];
			inputStream.next();
			inputStream.next();
			
			int i=0;
			while(inputStream.hasNext())
			{
				String data=inputStream.next();
				String[] values = data.split(",");
				closeArray[i]= Double.parseDouble(values[1]);
				i++;
			}
			return Optional.of(closeArray);
			
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public void test1()
	{
		FileWriter fw;
		try {
			fw = new FileWriter("testDataImport.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw= new PrintWriter(bw);
			
			Scanner keyboard=new Scanner(newFile);
			
			while(keyboard.hasNext())
			{
				pw.println(keyboard.next());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
