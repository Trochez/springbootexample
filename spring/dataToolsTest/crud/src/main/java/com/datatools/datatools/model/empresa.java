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
public class empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tipo_documento;
    private String numero_documento;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String pais;
    private String telefono;
    private String tipo_documento_rep;
    private String numero_documento_rep;
    private String nombre_rep;
    private String direccion_rep;
    private String ciudad_rep;
    private String departamento_rep;
    private String pais_rep;
    private String telefono_rep;
    
    private String[] fields = new String[]{"tipo_documento","numero_documento","nombre","direccion","ciudad","departamento","pais","telefono",
    "tipo_documento_rep", "numero_documento_rep","nombre_rep","direccion_rep","ciudad_rep","departamento_rep","pais_rep","telefono_rep"};

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumero_documento_rep() {
        return numero_documento_rep;
    }

    public void setNumero_documento_rep(String numero_documento_rep) {
        this.numero_documento_rep = numero_documento_rep;
    }

    public String getTelefono_rep() {
        return telefono_rep;
    }

    public void setTelefono_rep(String telefono_rep) {
        this.telefono_rep = telefono_rep;
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

    public String getTipo_documento_rep() {
        return tipo_documento_rep;
    }

    public void setTipo_documento_rep(String tipo_documento_rep) {
        this.tipo_documento_rep = tipo_documento_rep;
    }

    public String getNombre_rep() {
        return nombre_rep;
    }

    public void setNombre_rep(String nombre_rep) {
        this.nombre_rep = nombre_rep;
    }

    public String getDireccion_rep() {
        return direccion_rep;
    }

    public void setDireccion_rep(String direccion_rep) {
        this.direccion_rep = direccion_rep;
    }

    public String getCiudad_rep() {
        return ciudad_rep;
    }

    public void setCiudad_rep(String ciudad_rep) {
        this.ciudad_rep = ciudad_rep;
    }

    public String getDepartamento_rep() {
        return departamento_rep;
    }

    public void setDepartamento_rep(String departamento_rep) {
        this.departamento_rep = departamento_rep;
    }

    public String getPais_rep() {
        return pais_rep;
    }

    public void setPais_rep(String pais_rep) {
        this.pais_rep = pais_rep;
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
