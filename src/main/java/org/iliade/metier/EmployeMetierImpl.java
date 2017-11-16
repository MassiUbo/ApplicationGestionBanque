package org.iliade.metier;

import java.util.List;

import org.iliade.dao.EmployeRepository;
import org.iliade.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author MASSI
 *
 */
@Service
public class EmployeMetierImpl implements EmployeMetier {

    @Autowired
    private EmployeRepository employeRepository;

    
    @Override
    public Employe saveEmploye( Employe e ) {
        // TODO Auto-generated method stub
        return employeRepository.save( e );
    }

    @Override
    public List<Employe> listeEmploye() {
        // TODO Auto-generated method stub
        return employeRepository.findAll();
    }
    

}
