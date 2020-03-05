/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.service;

import com.datatools.datatools.model.empresa;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author root
 */
@Component
public class empresaService {
    
    private List<empresa> empresaList = new CopyOnWriteArrayList<>();
    
    public empresa addEmpresa(empresa e){
        
        empresaList.add(e);
        return e;
        
    }
    
    public List<empresa> getEmpresas(){
        return empresaList;
    }
    
    public empresa getEmpresa(int id){
        return empresaList.stream().filter(p->p.getId() == id).findFirst().get();
    }
    
    public empresa updateEmpresa(int id, empresa e){
        empresaList.stream()
                .forEach(p->{
                    if(p.getId()==id){
                        try {
                            p.setParams(e.getParams());
                        } catch (InvocationTargetException ex) {
                            System.err.println("***************ERROR "+ex);
                        }
                    }
                });
        
        return empresaList.stream().filter(p->p.getId()==id).findFirst().get();
    }
    
    public void deleteEmpresa(int id){
        empresaList.stream().forEach(p->{
            if(p.getId() == id){
                empresaList.remove(p);
            }
        });
    }
    
}
