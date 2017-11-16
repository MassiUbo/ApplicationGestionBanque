package org.iliade.metier;

import org.iliade.entities.Compte;

/**
 * 
 * @author MASSI
 *
 */
public interface CompteMetier {

    public Compte saveCompte( Compte cp );
    public Compte getCompte(String code);
    

}
