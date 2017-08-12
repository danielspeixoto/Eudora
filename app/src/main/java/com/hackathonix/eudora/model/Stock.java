package com.hackathonix.eudora.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dcandrade on 8/12/17.
 */

public class Stock {
    private Map<Product, Integer> soldProducts;
    private static Stock stock;

    private Stock(){
        this.soldProducts = new TreeMap<>(new Comparator<Product>() {
            @Override
            public int compare(Product a, Product b) {
             return   soldProducts.get(b).compareTo(soldProducts.get(a));
            }
        });
    }

    public static Stock getInstance(){
        if(stock == null){
            stock = new Stock();
        }
        return stock;
    }

    public int getSalesNumber(Product prod){
        return this.soldProducts.get(prod);
    }

    public void registerSoldIten(Product prod, int amount){
        Integer freq = this.soldProducts.get(prod);
        if(freq != null){
            this.soldProducts.put(prod, freq + amount);
        }else{
            this.soldProducts.put(prod, amount);
        }
    }

    // k = number of best sellers, cat = category
    public List<Product> bestSellerByCategory(int cat, int k){
        List<Product> bestSellers = new ArrayList<>();
        int i = 0;
        Iterator<Map.Entry<Product, Integer>> iterator = this.soldProducts.entrySet().iterator();
        while(iterator.hasNext() && i<k){
            Product prod = iterator.next().getKey();
            if (prod.getCategory() == cat) {
                i++;
                bestSellers.add(prod);
            }
        }

        return bestSellers;
    }

}
