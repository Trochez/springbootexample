/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author root
 */
@Entity 
public class relacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String id_Conductor;
    private String id_Vehiculo;
    
    private String[] fields = new String[]{"id_Conductor","id_Vehiculo"};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_Conductor() {
        return id_Conductor;
    }

    public void setId_Conductor(String id_Conductor) {
        this.id_Conductor = id_Conductor;
    }

    public String getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(String id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public void setParams(HashMap<String,String> hm) throws InvocationTargetException{
        Iterator it = hm.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry) it.next();
            
            java.lang.reflect.Method method;
            try {
                method = this.getClass().getMethod("set"+mp.getKey().toString(), mp.getValue().getClass());
                method.invoke(this, mp.getValue());
            } catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { 
                System.err.println("----------- ERROR setting param "+e);
            }
            
        }
    }
    
    public HashMap<String,String> getParams(){
       HashMap<String,String> hm = new HashMap<>();
              
       for(int i = 0;i<fields.length;i++){
           
           java.lang.reflect.Method method;
            try {
                
                method = this.getClass().getMethod("get"+fields[i].substring(0,1).toUpperCase()+fields[i].substring(1));
                hm.put(fields[i].substring(0,1).toUpperCase()+fields[i].substring(1), (String) method.invoke(this));
            
            } catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { 
                System.err.println("----------- ERROR setting param "+e);
            }
           
           
       }
       
       return hm;
    }
    
}
