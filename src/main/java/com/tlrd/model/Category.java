package com.tlrd.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Category {
	

    private String id;
    private String name;

     private List<Subcategory> subCategories;
    
    
    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for subCategories
    public List<Subcategory> getSubCategories() {
        return subCategories;
    }

    // Setter for subCategories
    public void setSubCategories(List<Subcategory> subCategories) {
        this.subCategories = subCategories;
    }
    
    
    
    public void addSubcategory(Subcategory subcategory) {
        if (subCategories == null) {
            subCategories = new ArrayList<>();
        }
        subCategories.add(subcategory);
        subcategory.setCategory(this);
    }

}