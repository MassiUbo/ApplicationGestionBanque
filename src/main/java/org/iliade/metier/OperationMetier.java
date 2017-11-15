package org.iliade.metier;

public interface OperationMetier {

    /**
     * On ajoute le codeEmp pour garder la trace de lempyer qui a fait
     * l'operation
     */

    // Operation verssement
    public boolean verser( String code, double montant, Long codeEmp );

    // retirer
    public boolean retirer( String code, double montant, Long codeEmp );

    // virement on a bsoin de deux comptes Emetter, Recepteur

    public boolean virement( String cpte1, String cpte2, double montant, Long codeEmp );

    // pages oprations contient compte , pages , nbre de ligne

    public PageOperation getOperations( String codeCompte, int page, int size );

}
