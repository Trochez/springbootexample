/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.service;

import com.datatools.datatools.model.relacion;
import com.datatools.datatools.model.vehiculo;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component
public class relacionService {
    
    private List<relacion> relacionList = new CopyOnWriteArrayList<>();
    
    public relacion addVehiculo(relacion r){
        
        relacionList.add(r);
        return r;
        
    }
    
    public List<relacion> getRelaciones(){
        return relacionList;
    }
    
    public relacion getRelacion(int id){
        return relacionList.stream().filter(p->p.getId() == id).findFirst().get();
    }
    
    public relacion updateRelacion(int id, relacion r){
        relacionList.stream()
                .forEach(p->{
                    if(p.getId()==id){
                        try {
                            p.setParams(r.getParams());
                        } catch (InvocationTargetException ex) {
                            System.err.println("***************ERROR "+ex);
                        }
                    }
                });
        
        return relacionList.stream().filter(p->p.getId()==id).findFirst().get();
    }
    
    public void deleteRelacion(int id){
        relacionList.stream().forEach(p->{
            if(p.getId() == id){
                relacionList.remove(p);
            }
        });
    }
    
}
