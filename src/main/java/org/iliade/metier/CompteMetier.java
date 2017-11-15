package org.iliade.metier;

import org.iliade.entities.Compte;

public interface CompteMetier {

    public Compte saveCompte( Compte cp );
    public Compte getCompte(String code);
    

}
