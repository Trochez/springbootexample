/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.api;

import static com.datatools.datatools.globals.conductorId;
import com.datatools.datatools.model.conductor;
import com.datatools.datatools.service.conductorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */

@RestController
@RequestMapping(value = "/conductor")
public class conductorApi {
    
    @Autowired
    private conductorService conductorService;
    
    @PostMapping(value = "/addConductor")
    public conductor addEmpresa(@RequestBody conductor c){
        c.setId(conductorId);
        conductorId++;
        return conductorService.addConductor(c);
    }
    
    @GetMapping(value = "/getConductores")
    public List<conductor> getEmpresas(){
        return conductorService.getConductores();
    }
    
    @GetMapping(value = "getConductor/{id}")
    public conductor getEmpresa(@PathVariable int id){
        
        return conductorService.getConductor(id);
        
    }
    
    @PutMapping(value = "putConductor/{id}")
    public conductor updateEmpresa(@PathVariable int id,@RequestBody conductor c){
        return conductorService.updateConductor(id, c);
    }
    
    @DeleteMapping(value = "deleteConductor/{id}")
    public void deletePc(@PathVariable int id){
        conductorService.deleteConductor(id);
    }
    
}
