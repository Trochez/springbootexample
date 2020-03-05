/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.api;

import static com.datatools.datatools.globals.vehiculoId;
import com.datatools.datatools.model.vehiculo;
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
@RequestMapping(value = "/vehiculo")
public class vehiculoApi {
    
    @Autowired
    private vehiculoService vehiculoService;
    
    @PostMapping(value = "/addVehiculo")
    public vehiculo addEmpresa(@RequestBody vehiculo v){
        v.setId(vehiculoId);
        vehiculoId++;
        return vehiculoService.addVehiculo(v);
    }
    
    @GetMapping(value = "/getVehiculos")
    public List<vehiculo> getEmpresas(){
        return vehiculoService.getVehiculos();
    }
    
    @GetMapping(value = "getVehiculo/{id}")
    public vehiculo getEmpresa(@PathVariable int id){
        
        return vehiculoService.getVehiculo(id);
        
    }
    
    @PutMapping(value = "putVehiculo/{id}")
    public vehiculo updateEmpresa(@PathVariable int id,@RequestBody vehiculo v){
        return vehiculoService.updateVehiculo(id, v);
    }
    
    @DeleteMapping(value = "deleteVehiculo/{id}")
    public void deletePc(@PathVariable int id){
        vehiculoService.deleteVehiculo(id);
    }
    
}
