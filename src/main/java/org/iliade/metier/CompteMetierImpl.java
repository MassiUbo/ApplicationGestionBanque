package org.iliade.metier;

import java.util.Date;

import org.iliade.dao.CompteRepository;
import org.iliade.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author MASSI
 *
 */
@Service
public class CompteMetierImpl implements CompteMetier{

    @Autowired
    private CompteRepository compteRepository;
    
    
    @Override
    public Compte saveCompte( Compte cp ) {
        
        
        cp.setDateCreation( new Date() );
        return compteRepository.save( cp );
    }

    @Override
    public Compte getCompte( String code ) {
         
        // retourner le code
        return compteRepository.findOne( code );
    }

}
