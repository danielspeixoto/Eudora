package com.hackathonix.eudora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dcandrade on 8/12/17.
 */

public class Client implements Serializable{
    private List<Purchase> purchases;
    private String name;
    private int picture;


    public Client(String name, int picture){
        this.name = name;
        this.purchases = new ArrayList<>();
    }


    public int getPicture(){
        return this.picture;
    }

    public void buy(Product product, int amount){
        this.purchases.add(new Purchase());
        Stock.getInstance().registerSoldIten(product, amount);
    }

    public Map<Integer, Integer> getStatistics(){
        Map<Integer, Integer> summary = new HashMap<>();

        for(Purchase purchase: this.purchases){
            Map<Integer, Integer> prodSummary = purchase.getSummary();

            Iterator<Map.Entry<Integer, Integer>> iterator = prodSummary.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                int amount = summary.getOrDefault(next.getKey(), 0);
                summary.put(next.getKey(), amount + next.getValue()); //Collects client statistics
            }
        }

        return summary;
    }

    public int getNumberOfPurchasedProducts(){
        Map<Integer, Integer> stats = this.getStatistics();
        Iterator<Integer> keys = stats.keySet().iterator();

        int total =0;
        while(keys.hasNext()){
            total += stats.get(keys.next());
        }

        return total;
    }
}
