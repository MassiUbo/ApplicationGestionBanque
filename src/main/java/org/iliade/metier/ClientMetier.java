package org.iliade.metier;

import java.util.List;

import org.iliade.entities.Client;

/**
 * 
 * @author MASSI
 *
 */
public interface ClientMetier {
    
   public Client saveClient(Client c);
   public List<Client> listeClient();
}
