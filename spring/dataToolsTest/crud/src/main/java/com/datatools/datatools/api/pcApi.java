/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.api;
import com.datatools.datatools.model.pc;
import com.datatools.datatools.service.pcService;
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
 * @author juan.trochez.montoya
 */
@RestController
@RequestMapping(value = "/pcs")
public class pcApi{
    
    @Autowired
    private pcService pcService;
    
    @PostMapping(value = "/addPc")
    public pc addPc(@RequestBody pc pc){
        return pcService.addPC(pc);
    }
    
    @GetMapping(value = "/getPcs")
    public List<pc> getPcs(){
        System.out.println("---------- llega a getPcs");
        return pcService.getPcs();
    }
    
    @GetMapping(value = "getPc/{id}")
    public pc getPc(@PathVariable int id){
        
        return pcService.getPc(id);
        
    }
    
    @PutMapping(value = "putPc/{id}")
    public pc putPc(@PathVariable int id,@RequestBody pc pc){
        return pcService.updatePc(id, pc);
    }
    
    @DeleteMapping(value = "deletePc/{id}")
    public void deletePc(@PathVariable int id){
        pcService.deletePc(id);
    }
    
         
}
