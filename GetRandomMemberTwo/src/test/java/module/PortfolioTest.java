package module;


import model.Stock;
import org.junit.jupiter.api.Test;
import util.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTest {

    Portfolio portfolio; //module
    StockService stockService; //util

    public static void main(String[] args) {
        PortfolioTest tester = new PortfolioTest(); //default constructor
        tester.setUp();
        System.out.println(tester.testMarketValue());

    }

    public void setUp() {
        //create a portfolio object which is to be tested
        portfolio = new Portfolio();

        //create the mock object of stock service
        stockService = mock(StockService.class);

        //set the stockService to the portfolio
        portfolio.setStockService(stockService);
    }

    //@Test
    public boolean testMarketValue() {
        List<Stock> stockList = new ArrayList<>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock microsoftStock = new Stock("2", "Microsoft", 100);

        stockList.add(googleStock);
        stockList.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stockList);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();
        return marketValue == 100500.0;
    }

}
