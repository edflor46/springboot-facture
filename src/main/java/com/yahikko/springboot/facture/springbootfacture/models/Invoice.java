package com.yahikko.springboot.facture.springbootfacture.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;

@Component
@RequestScope
//@JsonIgnoreProperties({"targetSource","advisors"})
@Data
public class Invoice {

    private static final String INVOICE_CONFIG_DESCRIPTION = "${invoice.description}";

    @Autowired
    private Client client;

    @Value(INVOICE_CONFIG_DESCRIPTION)
    private String description;

    //@Qualifier("itemsInvoiceSecond")
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente Factura");
        client.setName("Luis".concat(" ").concat(client.getName()));

    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente");
    }

   //private Integer total;

    public Integer getTotal() {
        // total = 0;
        //
        // for(Item item : items){
        // total += item.getAmount();
        // }

        Integer total = items.stream()
        .map(item -> item.getAmount())
        .reduce(0, (sum, amount) -> sum + amount);
        return total;
    }

}
