package org.iliade.dao;

import org.iliade.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

// deuxieme argument c'est le type de la clé primaire 
public interface ClientRepository extends JpaRepository<Client, Long> {
 

    
}
