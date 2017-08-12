package com.hackathonix.eudora.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
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
    private List<SoldItem> soldProducts;
    private static Stock stock;

    private Stock(){
        this.soldProducts = new ArrayList<>();
    }

    public static Stock getInstance(){
        if(stock == null){
            stock = new Stock();
        }
        return stock;
    }

    public SoldItem find(String name){
        for(SoldItem p:this.soldProducts){
            if(p.getProduct().getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    public int getSalesNumber(Product prod){
        return this.find(prod.getName()).getAmount();
    }

    public void registerSoldIten(Product prod, int amount){
        SoldItem item = this.find(prod.getName());

        if(item != null) {
            item.inc(amount);
        }
    }

    // k = number of best sellers, cat = category
    public List<Product> bestSellerByCategory(int cat, int k){
        Collections.sort(this.soldProducts);
        List<Product> bestSellers = new ArrayList<>();
        int i = 0;
        Iterator<SoldItem> iterator = this.soldProducts.iterator();
        while(iterator.hasNext() && i<k){
            Product prod = iterator.next().getProduct();
            if (prod.getCategory() == cat) {
                i++;
                bestSellers.add(prod);
            }
        }

        return bestSellers;
    }

}

class SoldItem implements Comparable<SoldItem>{
    private Product product;
    private Integer amount;

    public SoldItem(Product prod, Integer amount){
        this.product = prod;
        this.amount = amount;
    }

    public void inc(int size){
        this.amount+=size;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public int compareTo(@NonNull SoldItem soldItem) {
        return soldItem.getAmount().compareTo(this.getAmount());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SoldItem){
            SoldItem item = (SoldItem) obj;
            return item.getProduct().getName().equals(this.product.getName());
        }
        return false;
    }
}