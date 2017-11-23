package org.iliade.services;

import java.util.List;

import org.iliade.entities.Client;
import org.iliade.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author MASSI
 *
 */

@RestController
public class ClientRestService {
   // pour injection 
    @Autowired
    private ClientMetier clientMetier;

/**
 * Sauvegarder liste de clients
 * @param  paramètre Clinet c
 * 
 */
@RequestMapping(value = "/clients",method=RequestMethod.POST)
public Client saveClient( @RequestBody Client c ) {
    return clientMetier.saveClient( c );
}

/**
 *  Recuperation de la liste des client via requete GET
 *  
 * @return liste de clients
 */
@RequestMapping(value = "/clients",method=RequestMethod.GET)
public List<Client> listeClient() {
    return clientMetier.listeClient();
}
    
    // via source on va generer directement les méthode (delegateméthode)
}
