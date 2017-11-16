package org.iliade.metier;

import java.util.List;
import org.iliade.dao.ClientRepository;
import org.iliade.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author MASSI
 *
 */
@Service
public class ClientMetierImpl implements ClientMetier {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient( Client c ) {
        // methode fourni par spring repository
        return clientRepository.save( c );
    }

    @Override
    public List<Client> listeClient() {
        // retourner tous les clients
        return clientRepository.findAll();
    }

}
