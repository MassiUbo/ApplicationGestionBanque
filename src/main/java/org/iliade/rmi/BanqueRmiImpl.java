package org.iliade.rmi;

import java.rmi.RemoteException;

import org.iliade.entities.Compte;
import org.iliade.metier.CompteMetier;
import org.iliade.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 
 * @author MASSI
 *
 */
@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote{

    @Autowired
    private CompteMetier compteMetier;
    @Autowired
    private OperationMetier operationMetier;
    
    
    
    @Override
    public Compte saveCompte( Compte cp ) throws RemoteException {
       
        return compteMetier.saveCompte( cp );
                
    }

    @Override
    public Compte getCompte( String code ) throws RemoteException {
        
        return compteMetier.getCompte( code );
    }

    @Override
    public boolean verser( String code, double montant, Long codeEmp ) throws RemoteException {
        
        return operationMetier.verser( code, montant, codeEmp ); 
    }

    @Override
    public boolean retirer( String code, double montant, Long codeEmp ) throws RemoteException {
        
        return operationMetier.retirer( code, montant, codeEmp );
    }

    @Override
    public boolean virement( String cpte1, String cpte2, double montant, Long codeEmp ) throws RemoteException {
        return operationMetier.virement( cpte1, cpte2, montant, codeEmp );
     
    }

}
