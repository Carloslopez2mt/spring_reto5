
package com.usa.Repositorio;

import com.usa.Interface.interfaceComputer;
import com.usa.Modelo.Computer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerRepositorio {
    
    @Autowired
    private interfaceComputer crud;
    
    public List<Computer> getAll(){
        return (List<Computer>) crud.findAll();
    }
    
    public Optional<Computer> getComputer(int id){
        return crud.findById(id);
    }
    
    public Computer save(Computer computer){
        return crud.save(computer);
    }
    
    public void delete(Computer computer){
        crud.delete(computer);
    }
}
