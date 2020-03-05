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
public class conductor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo_documento;
    private String numero_documento;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String pais;
    private String Id_empresa;
    private String telefono;
    
    private String[] fields = new String[]{"tipo_documento","numero_documento","nombre","direccion","ciudad","departamento","pais","telefono","Id_empresa"};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getId_empresa() {
        return Id_empresa;
    }

    public void setId_empresa(String Id_empresa) {
        this.Id_empresa = Id_empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
