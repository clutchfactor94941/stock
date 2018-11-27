/*
 * comma seperated value 
 * converts data from excel
 * 
 * free stock quote API
 */
/*
 * need to implement method to read in all of the individual prices and assign an index to each to make things easier
 * Also need a method to calculate covariances of each value
 */

public class Market{

	private Stock[] stocksInPortfolio;
	private float indexValue;
	private float expectedRate;
	private float actualizedRate;
	private float cash;
	private int capacity;
	private int size;
	private float marketRisk;
	
	/*
	 * the initialization method will take in the initial data at the beginning
	 * and create a portfolio from the information
	 */
	public Market()
	{
		
	}
	
	/*
	 * this method will update the value of the stock information in the entire market
	 * and will have to take this data from the data file
	 * and will have to interact a lot with the stock and portfolio classes
	 */
	public void newData()
	{
		
	}
	
	/*
	 *this method will retrieve data from the file it is stored in 
	 */
	public void retrieveData()
	{
		
	}
	
	
}
