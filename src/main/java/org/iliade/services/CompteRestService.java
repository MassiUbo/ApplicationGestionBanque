package org.iliade.services;

import org.iliade.entities.Compte;
import org.iliade.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {

    @Autowired
    private CompteMetier compteMetier;
/**
 * Associer un employer à un compte
 * @param cp : compte Banque a donné en paramètre
 * @return
 */
    @RequestMapping( value = "/comptes", method = RequestMethod.POST )
    public Compte saveEmploye( @RequestBody Compte cp ) {
        return compteMetier.saveCompte( cp );
    }
/**
 * Recuperer un compte d'un client via requete GET
 * @param code : code d'un client
 * @return compte d'un client
 */
    @RequestMapping( value = "/comptes/{code}", method = RequestMethod.GET )
    public Compte getCompte( @PathVariable String code ) {
        return compteMetier.getCompte( code );
    }

}
