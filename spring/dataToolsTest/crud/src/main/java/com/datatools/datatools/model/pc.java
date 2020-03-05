/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.model;

import java.lang.reflect.Field;
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
 * @author juan.trochez.montoya
 */
@Entity
public class pc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int serial;
    public int rammemory;
    public int hdd;
    public int sdd;
    public String board;
    public String RGB;
    public String gpu;
    public String cpu;
    public String refrigeration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getRammemory() {
        return rammemory;
    }

    public void setRammemory(int rammemory) {
        this.rammemory = rammemory;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getSdd() {
        return sdd;
    }

    public void setSdd(int sdd) {
        this.sdd = sdd;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getRGB() {
        return RGB;
    }

    public void setRGB(String RGB) {
        this.RGB = RGB;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRefrigeration() {
        return refrigeration;
    }

    public void setRefrigeration(String refrigeration) {
        this.refrigeration = refrigeration;
    } 
    
    public void setParams(HashMap<String,Object> hm){
        Iterator it = hm.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry) it.next();
            
            java.lang.reflect.Method method;
            try {
                method = this.getClass().getMethod("set"+mp.getKey().toString(), mp.getValue().getClass());
                method.invoke(this, mp.getValue());
            } catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { 
                System.err.println("----------- ERROR setting param");
            }
            
        }
    }
    
    public HashMap<String,Object> getParams(){
       HashMap<String,Object> hm = new HashMap<>();
       
       Field[] f = this.getClass().getFields();
       
       for(int i = 0;i<f.length;i++){
           
           java.lang.reflect.Method method;
            try {
                
                method = this.getClass().getMethod("get"+f[i].toString().substring(0,1).toUpperCase()+f[i].toString().substring(1));
                hm.put(f[i].toString(),method.invoke(this));
            
            } catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { 
                System.err.println("----------- ERROR setting param");
            }
           
           
       }
       
       return hm;
    }
    
}
