package com.simeonbiniatidis.supersimplestock_maven_ut_03;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simeon
 */

public class SuperSimpleStock {
       
	// private static Log log = LogFactory.getLog(App.class);
	
//    @Bean
    static Map<String, Stock> stockData() {
        
        HashMap<String, Stock> stockHm = new HashMap<>();
        
        stockHm.put("TEA", new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0));
        stockHm.put("POP", new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
        stockHm.put("ALE", new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0));
        stockHm.put("GIN", new Stock("GIN", StockType.PREFERRED, 8.0, 0.2, 100.0));
        stockHm.put("JOE", new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
        return stockHm;
    }

    public static void main( String[] args )
    {
        try {
//            ApplicationContext context = 
//                    new AnnotationConfigApplicationContext(App.class);
            
            // Run dividend and P/E Ratio routines
            @SuppressWarnings("unchecked")
    //		Map<String, Stock> db = context.getBean("Db", Map.class);
            
            Map<String, Stock> stockHm = stockData();
            for (Stock stock: stockHm.values()) {
            System.out.println( stock.getSymbol() + " dividend: " + stock.dividend(9.1));
            System.out.println( stock.getSymbol() + " P/E Ratio: " + stock.PERatio(9.1));
                    // Record some trades
            	for (int i=1; i <= 10; i++) {
            		Random r = new Random();
            		Integer rangeMin = 1;
            		Integer rangeMax = 10;
                        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            		stock.buy(i, randomValue);
                        System.out.println(stock.getSymbol() + " bought " + i + " shares at $" + randomValue);
                        
                        randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            		stock.sell(i, randomValue);
                        System.out.println(stock.getSymbol() + " sold " + i + " shares at $" + randomValue);
            		Thread.sleep(1000);
            	}
                        System.out.println(stock.getSymbol() + " price: $" + stock.getPrice());
                        System.out.println(stock.getSymbol() + " volumeWeightedStockPrice: $" + stock.calculateStockPriceByVolumeWeight());
        
            }
            
            Double GBCEallShareIndex = Stock.allShareIndexGBCE(stockHm);
            System.out.println("GBCE All Share Index: " + GBCEallShareIndex);
            } catch (Exception e) {
		e.printStackTrace();
		}
    }
}


   
