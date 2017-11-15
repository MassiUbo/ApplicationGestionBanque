package org.iliade.dao;


/**
 * @author MASSI
 */

import org.iliade.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    
    
    // solution 1 
    @Query("select o from Operation o where o.compte.codeCompte=:x")
    public Page<Operation> getOperations( @Param("x") String code, Pageable pageable);
    
    // solution 2 
    // public Page<Operation> findByCompte(Compte cp, Pageable pageable);
    

}
