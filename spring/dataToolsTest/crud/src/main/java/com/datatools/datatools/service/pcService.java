/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.service;

import com.datatools.datatools.model.pc;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan.trochez.montoya
 */
@Component
public class pcService {
    
    private List<pc> pcList = new CopyOnWriteArrayList<>();
    
    public pc addPC(pc pc){
        
        pcList.add(pc);
        return pc;
        
    }
    
    public List<pc> getPcs(){
        return pcList;
    }
    
    public pc getPc(int id){
        return pcList.stream().filter(p->p.getId() == id).findFirst().get();
    }
    
    public pc updatePc(int id, pc pc){
        pcList.stream()
                .forEach(p->{
                    if(p.getId()==id){
                        p.setParams(pc.getParams());
                    }
                });
        
        return pcList.stream().filter(p->p.getId()==id).findFirst().get();
    }
    
    public void deletePc(int id){
        pcList.stream().forEach(p->{
            if(p.getId() == id){
                pcList.remove(p);
            }
        });
    }
}
