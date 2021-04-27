/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baonq.category;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CategoryDTO implements Serializable{
    private String cateID;
    private String cateName;

    public CategoryDTO() {
    }

    public CategoryDTO(String cateID, String cateName) {
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "cateID=" + cateID + ", cateName=" + cateName + '}';
    }
    
    
}
