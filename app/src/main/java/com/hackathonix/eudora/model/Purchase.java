package com.hackathonix.eudora.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by dcandrade on 8/12/17.
 */

public class Purchase implements Serializable{
    private Map<Product, Integer> productAmount;

    public Purchase(){
        this.productAmount = new HashMap<>();
    }

    public void add(Product product, int amount){
        this.productAmount.put(product, amount);
    }

    public Map<Integer, Integer> getSummary(){
        Map<Integer, Integer> summary = new HashMap<>();
        Iterator<Map.Entry<Product, Integer>> iterator = productAmount.entrySet().iterator();
        Map.Entry<Product, Integer> next;

        while(iterator.hasNext()){
            next = iterator.next();
            int category = next.getKey().getCategory();
            int amount = next.getValue();
            int currentAmount = summary.getOrDefault(category, 0);
            summary.put(category, amount + currentAmount);
        }

        return summary;
    }
}
