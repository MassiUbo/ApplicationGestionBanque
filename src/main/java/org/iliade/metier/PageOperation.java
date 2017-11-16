package org.iliade.metier;

import java.io.Serializable;
import java.util.List;

import org.iliade.entities.Operation;


/**
 * 
 * 
 * @author MASSI
 *
 */
public class PageOperation implements Serializable{
    
    // listes d'operations 
    private List<Operation> operations ;
    // numero de pages 
    private int page;
    private int nmbreOperations; 
    private int totalOperations;
    private int totalPages;
    
    
    // get & set 
    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations( List<Operation> operations ) {
        this.operations = operations;
    }
    public int getPage() {
        return page;
    }
    public void setPage( int page ) {
        this.page = page;
    }
    public int getNmbreOperations() {
        return nmbreOperations;
    }
    public void setNmbreOperations( int nmbreOperations ) {
        this.nmbreOperations = nmbreOperations;
    }
    public int getTotalOperations() {
        return totalOperations;
    }
    public void setTotalOperations( int totalOperations ) {
        this.totalOperations = totalOperations;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages( int totalPages ) {
        this.totalPages = totalPages;
    } 
    
    
    
}
