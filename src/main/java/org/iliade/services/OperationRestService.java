package org.iliade.services;

import org.iliade.metier.OperationMetier;
import org.iliade.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author MASSI
 *
 */
@RestController
public class OperationRestService {

    @Autowired
    private OperationMetier operationMetier;
/**
 * Retourner liste d'oprations avec méthode GET
 * 
 */
    @RequestMapping( value = "/operations", method = RequestMethod.GET )
    public PageOperation getOperations( 
            @RequestParam String codeCompte, 
            @RequestParam int page, 
            @RequestParam int size ) {
        return operationMetier.getOperations( codeCompte, page, size );
    }

    /**
     * Operation versement 
     * 
     * @param code : code compte
     * @param montant : montant à verser
     * @param codeEmp : code employer
     * @return
     */
    @RequestMapping( value = "/versement", method = RequestMethod.PUT )
    public boolean verser(
            @RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp ) {
        return operationMetier.verser( code, montant, codeEmp );
    }

    /**
     * Operation retrait via requeête PUT
     * 
     */
    @RequestMapping( value = "/retrait", method = RequestMethod.PUT )
    public boolean retirer(
            @RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp ) {
        return operationMetier.retirer( code, montant, codeEmp );
    }

    /**
     * Opéation virement d'un compte à un autre
     * 
     */
    @RequestMapping( value = "/virement", method = RequestMethod.PUT )
    public boolean virement(
            @RequestParam String cpte1,
            @RequestParam String cpte2,
            @RequestParam double montant,
            @RequestParam Long codeEmp ) {
        return operationMetier.virement( cpte1, cpte2, montant, codeEmp );
    }

}
