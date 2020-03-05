/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datatools.datatools.api;

import static com.datatools.datatools.globals.empresaId;
import com.datatools.datatools.model.empresa;
import com.datatools.datatools.service.empresaService;
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
@RequestMapping(value = "/empresa")
public class empresaApi {
    
    @Autowired
    private empresaService empresaService;
    
    @PostMapping(value = "/addEmpresa")
    public empresa addEmpresa(@RequestBody empresa e){
        e.setId(empresaId);
        empresaId++;
        return empresaService.addEmpresa(e);
    }
    
    @GetMapping(value = "/getEmpresas")
    public List<empresa> getEmpresas(){
        return empresaService.getEmpresas();
    }
    
    @GetMapping(value = "getEmpresa/{id}")
    public empresa getEmpresa(@PathVariable int id){
        
        return empresaService.getEmpresa(id);
        
    }
    
    @PutMapping(value = "putEmpresa/{id}")
    public empresa updateEmpresa(@PathVariable int id,@RequestBody empresa e){
        return empresaService.updateEmpresa(id, e);
    }
    
    @DeleteMapping(value = "deleteEmpresa/{id}")
    public void deleteEmpresa(@PathVariable int id){
        empresaService.deleteEmpresa(id);
    }
    
}
