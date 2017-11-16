package org.iliade.metier;

import java.util.Date;

import org.iliade.dao.CompteRepository;
import org.iliade.dao.EmployeRepository;
import org.iliade.dao.OperationRepository;
import org.iliade.entities.Compte;
import org.iliade.entities.Employe;
import org.iliade.entities.Operation;
import org.iliade.entities.Retrait;
import org.iliade.entities.Versment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository    compteRepository;
    @Autowired
    private EmployeRepository   employeRepository;

    @Override
    @Transactional // si tous ce passe bien la transaction et faite
    public boolean verser( String code, double montant, Long codeEmp ) {

        // On charge le compte
        Compte cp = compteRepository.findOne( code );

        // on charge l'employe
        Employe ep = employeRepository.findOne( codeEmp );
        Operation o = new Versment();

        // mettre a jour date et montant compte et employe
        o.setDateOperation( new Date() );
        o.setMontant( montant );
        o.setCompte( cp );
        o.setEmploye( ep );

        // sauvgarder l'operation
        operationRepository.save( o );

        // mettre a jour le solde
        cp.setSolde( cp.getSolde() + montant );
        return true;

    }

    @Transactional
    @Override
    public boolean retirer( String code, double montant, Long codeEmp ) {
        Compte cp = compteRepository.findOne( code );
        if ( cp.getSolde() < montant )
            throw new RuntimeException( "Solde insuffisant !" );
        // on charge l'employe
        Employe ep = employeRepository.findOne( codeEmp );
        Operation o = new Retrait();
        // mettre a jour date et montant compte et employe
        o.setDateOperation( new Date() );
        o.setMontant( montant );
        o.setCompte( cp );
        o.setEmploye( ep );
        // sauvgarder l'operation
        operationRepository.save( o );
        // mettre a jour le solde
        cp.setSolde( cp.getSolde() - montant );
        return true;

    }

    @Transactional
    @Override
    public boolean virement( String cpte1, String cpte2, double montant, Long codeEmp ) {
        // on utilise la méthode reirer puis verser
        retirer( cpte1, montant, codeEmp );
        verser( cpte2, montant, codeEmp );

        return true;
    }

    @Override
    public PageOperation getOperations( String codeCompte, int page, int size ) {

        Page<Operation> ops = operationRepository.getOperations( codeCompte, new PageRequest( page, size ) );

        PageOperation pOp = new PageOperation();
        pOp.setOperations( ops.getContent() ); // get content retourne la liste
                                               // des operations
        pOp.setNmbreOperations( ops.getNumberOfElements() ); // nombre
                                                             // operations
        pOp.setPage( page ); // ops.getNumber()
        pOp.setTotalPages( ops.getTotalPages() );
        pOp.setTotalOperations((int) ops.getTotalElements() );
        return pOp;

    }

}
