import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Portfolio {

	private List<Double> heldAssets;
	private double expectedRate;
	private double actualizedRate;
	private double[] weightOfPortfolio;
	private double portfolioRisk;
	private double cash;
	
	
	/*
	 * the update data method will import the new data available about the price
	 * so it will change the value of each stock
	 * needs to use a for loop and will take in 3 pieces of information
	 * the price at close on friday
	 * the high of the week
	 * the low of the week
	 */
	public void importData()
	{
		
	}
	
	/*
	 * if a stock sells then add cash to the firm 
	 * need to find a way to target a specific stock preferably without having to use an entire loop
	 * this will use the various buy methods of the specific stock
	 */
	public void getPaid()
	{

	}
	
	/* 
	 * this is a method to buy new stocks and then add it to the portfolio
	 * so cash will decrease
	 * and a new stock will be added to the portfolio
	 * 
	 */
	public void buyStock()
	{
		
	}
	
	/*
	 * this method will create a covariance matrix
	 * not entirely sure how to do that right now
	 */
	public void covarianceMatrix()
	{
		
	}
	
}
