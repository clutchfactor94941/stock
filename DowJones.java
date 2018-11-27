import java.io.File;

public class DowJones {

	private File[] dowJonesPortfolio=new File[30];
	private final File dowJonesIndustrialAverage = File(DJI.csv);
	
	
	
	
	public void createDowJones()
	{
		String fileName;
		for(int i=0;i<30;i++)
		{
			fileName="stock"+i;
			ImportFile temp=new ImportFile(fileName);
		}
	}
}
