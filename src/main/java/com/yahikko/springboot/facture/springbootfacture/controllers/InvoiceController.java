package com.yahikko.springboot.facture.springbootfacture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yahikko.springboot.facture.springbootfacture.models.Client;
import com.yahikko.springboot.facture.springbootfacture.models.Invoice;

@RestController
@RequestMapping("api/v0")
public class InvoiceController {

    private static final String ROUTE_INVOICES = "/invoices";

    @Autowired
    private Invoice invoice;

    @GetMapping(ROUTE_INVOICES)
    public Invoice show(){
        Invoice i = new Invoice();
        Client c = new Client();

        c.setName(invoice.getClient().getName());
        c.setLastName(invoice.getClient().getLastName());

        i.setClient(c);

        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        return i;
    }

}
