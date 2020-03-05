/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.service;

import com.datatools.datatools.model.conductor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component
public class conductorService {
    
    private List<conductor> conductorList = new CopyOnWriteArrayList<>();
    
    public conductor addConductor(conductor c){
        
        conductorList.add(c);
        return c;
        
    }
    
    public List<conductor> getConductores(){
        return conductorList;
    }
    
    public conductor getConductor(int id){
        return conductorList.stream().filter(p->p.getId() == id).findFirst().get();
    }
    
    public conductor updateConductor(int id, conductor c){
        conductorList.stream()
                .forEach(p->{
                    if(p.getId()==id){
                        try {
                            p.setParams(c.getParams());
                        } catch (InvocationTargetException ex) {
                            System.err.println("***************ERROR "+ex);
                        }
                    }
                });
        
        return conductorList.stream().filter(p->p.getId()==id).findFirst().get();
    }
    
    public void deleteConductor(int id){
        conductorList.stream().forEach(p->{
            if(p.getId() == id){
                conductorList.remove(p);
            }
        });
    }
    
}
