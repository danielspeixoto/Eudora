package com.hackathonix.eudora.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dcandrade on 8/12/17.
 */

public class Category {
    public static int MAKE_UP = 0;
    public static int PERFUME = 1;
    public static int BODY_N_BATH = 2;
    public static int FACIAL = 3;
    public static int HAIR = 4;
    public static int ACCESSORIES = 5;

    private Map<Integer, String> categoryIndexes;

    public Category(){
        this.categoryIndexes = new HashMap<>();

        this.categoryIndexes.put(Category.MAKE_UP, "Maquiagem");
        this.categoryIndexes.put(Category.PERFUME, "Perfumaria");
        this.categoryIndexes.put(Category.BODY_N_BATH, "Corpo e Banho");
        this.categoryIndexes.put(Category.FACIAL, "Tratamento Facial");
        this.categoryIndexes.put(Category.HAIR, "Cabelos");
        this.categoryIndexes.put(Category.ACCESSORIES, "Acessórios");

    }

    public String getCategoryName(int categoryIndex){
        return this.categoryIndexes.get(categoryIndex);
    }

}
