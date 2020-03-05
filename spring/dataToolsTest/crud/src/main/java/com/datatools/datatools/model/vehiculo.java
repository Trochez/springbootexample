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
public class vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String placa;
    private String motor;
    private String chasis;
    private String modelo;
    private String fecha_matricula;
    private String pasajeros_sentados;
    private String pasajeros_parados;
    private String peso_seco;
    private String peso_bruto;
    private String puertas;
    private String marca;
    private String linea;
    private String Id_empresa;
    private String afiliado;
    
    private String[] fields = new String[]{"placa","motor","chasis","modelo","fecha_matricula","pasajeros_sentados","pasajeros_parados","peso_seco",
    "peso_bruto", "puertas","marca","linea","afiliado","Id_empresa"};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPasajeros_sentados() {
        return pasajeros_sentados;
    }

    public void setPasajeros_sentados(String pasajeros_sentados) {
        this.pasajeros_sentados = pasajeros_sentados;
    }

    public String getPasajeros_parados() {
        return pasajeros_parados;
    }

    public void setPasajeros_parados(String pasajeros_parados) {
        this.pasajeros_parados = pasajeros_parados;
    }

    public String getPeso_seco() {
        return peso_seco;
    }

    public void setPeso_seco(String peso_seco) {
        this.peso_seco = peso_seco;
    }

    public String getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(String peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public String getPuertas() {
        return puertas;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getId_empresa() {
        return Id_empresa;
    }

    public void setId_empresa(String Id_empresa) {
        this.Id_empresa = Id_empresa;
    }

    public String getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(String afiliado) {
        this.afiliado = afiliado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(String fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
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
