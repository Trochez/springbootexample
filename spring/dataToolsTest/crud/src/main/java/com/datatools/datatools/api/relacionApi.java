/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.api;

import static com.datatools.datatools.globals.relacionId;
import com.datatools.datatools.model.relacion;
import com.datatools.datatools.model.vehiculo;
import com.datatools.datatools.service.relacionService;
import com.datatools.datatools.service.vehiculoService;
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
@RequestMapping(value = "/relacion")
public class relacionApi {
    
    @Autowired
    private relacionService relacionService;
    
    @PostMapping(value = "/addRelacion")
    public relacion addEmpresa(@RequestBody relacion r){
        r.setId(relacionId);
        relacionId++;
        return relacionService.addVehiculo(r);
    }
    
    @GetMapping(value = "/getRelaciones")
    public List<relacion> getEmpresas(){
        return relacionService.getRelaciones();
    }
    
    @GetMapping(value = "getRelacion/{id}")
    public relacion getEmpresa(@PathVariable int id){
        
        return relacionService.getRelacion(id);
        
    }
    
    @PutMapping(value = "putRelacion/{id}")
    public relacion updateEmpresa(@PathVariable int id,@RequestBody relacion r){
        return relacionService.updateRelacion(id, r);
    }
    
    @DeleteMapping(value = "deleteRelacion/{id}")
    public void deletePc(@PathVariable int id){
        relacionService.deleteRelacion(id);
    }
    
}
