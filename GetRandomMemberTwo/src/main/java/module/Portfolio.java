package module;

import model.Stock;
import util.StockService;

import java.util.List;

public class Portfolio {
    private StockService stockService;
    private List<Stock> stocks;

    /**
     * constructor: none
     * getters and setters for the class/interface
     * @return
     */

    public StockService getStockService() {
        return stockService;
    }

    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public double getMarketValue() {
        double marketValue = 0.0;
        for(Stock stock : stocks) {
            marketValue += stockService.getPrice(stock) * stock.getQuantity();
        }
        return marketValue;
    }
}
