
package com.usa.Servicios;

import com.usa.Modelo.Computer;
import com.usa.Repositorio.ComputerRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosComputer {
    
    @Autowired
    private ComputerRepositorio metodosCrud;
    
    public List<Computer> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Computer> getComputer(int id){
        return metodosCrud.getComputer(id);
    }
    
    public Computer save(Computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<Computer> evt=metodosCrud.getComputer(computer.getId());
            if(evt.isEmpty()){
               return metodosCrud.save(computer);
            }else{
                return computer;
            }
        }
    }
    
    public Computer update(Computer computer){
        if (computer.getId()!=null){
            Optional<Computer> evt = metodosCrud.getComputer(computer.getId());
            if (!evt.isEmpty()){
                if (computer.getName()!=null){
                    evt.get().setName(computer.getName());
                }
                if (computer.getBrand()!=null){
                    evt.get().setBrand(computer.getBrand());
                }
                if (computer.getYear()!=null){
                    evt.get().setYear(computer.getYear());
                }
                if (computer.getDescription()!=null){
                    evt.get().setDescription(computer.getDescription());
                }
                if (computer.getCategory()!=null){
                    evt.get().setCategory(computer.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else {
                return computer;
            }
        }else {
            return computer;
        }
    }
    
    public boolean deleteComputer(int id){
        Boolean del = getComputer(id).map(computer -> {
            metodosCrud.delete(computer);
            return true;
        }).orElse(false);
        return del;
    }
}
