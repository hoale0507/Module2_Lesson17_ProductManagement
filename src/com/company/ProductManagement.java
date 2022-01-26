package com.company;

import java.util.ArrayList;

public class ProductManagement {
    ArrayList<Product> products = new ArrayList<>();

    public ProductManagement() {
    }

    public ProductManagement(ArrayList<Product> products) {
        this.products = products;
    }

    public int size(){
        return products.size();
    }

    public void display(){
        for (int i = 0; i < size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public void add(Product product){
        products.add(product);
    }

    public int indexFindByCode(String code){
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if(products.get(i).getCode().equals(code)){
                index = i;
            }
        }
        return index;
    }


}
