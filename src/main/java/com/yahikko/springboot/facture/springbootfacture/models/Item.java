package com.yahikko.springboot.facture.springbootfacture.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Product product;
    private Integer quantity;
    

    public Integer getAmount(){
        return quantity * product.getPrice();
    }

}
