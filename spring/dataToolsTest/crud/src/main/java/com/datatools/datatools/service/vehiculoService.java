/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.service;

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
public class vehiculoService {
    
    private List<vehiculo> vehiculoList = new CopyOnWriteArrayList<>();
    
    public vehiculo addVehiculo(vehiculo v){
        
        vehiculoList.add(v);
        return v;
        
    }
    
    public List<vehiculo> getVehiculos(){
        return vehiculoList;
    }
    
    public vehiculo getVehiculo(int id){
        return vehiculoList.stream().filter(p->p.getId() == id).findFirst().get();
    }
    
    public vehiculo updateVehiculo(int id, vehiculo v){
        vehiculoList.stream()
                .forEach(p->{
                    if(p.getId()==id){
                        try {
                            p.setParams(v.getParams());
                        } catch (InvocationTargetException ex) {
                            System.err.println("***************ERROR "+ex);
                        }
                    }
                });
        
        return vehiculoList.stream().filter(p->p.getId()==id).findFirst().get();
    }
    
    public void deleteVehiculo(int id){
        vehiculoList.stream().forEach(p->{
            if(p.getId() == id){
                vehiculoList.remove(p);
            }
        });
    }
    
}
