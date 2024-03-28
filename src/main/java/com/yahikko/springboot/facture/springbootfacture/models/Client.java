package com.yahikko.springboot.facture.springbootfacture.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Component
@SessionScope
//@JsonIgnoreProperties({"targetSource","advisors"})
public class Client {

    private static final String CONFIG_CLIENT_NAME = "${client.name}";
    private static final String CONFIG_CLIENT_LAST_NAME = "${client.lastname}";
    
    @Value(CONFIG_CLIENT_NAME)
    private String name;
    
    @Value(CONFIG_CLIENT_LAST_NAME)
    private String lastName;

}
