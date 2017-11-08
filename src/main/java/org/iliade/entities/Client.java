package org.iliade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author MASSI
 *
 */


@Entity
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long               codeClient;
    private String             nomClient;
    
    // Le client peut avoir plusierus comptes donc associations oneToMany
    
    @OneToMany( mappedBy = "client", fetch = FetchType.LAZY )
    
    private Collection<Compte> comptes;

    public Client() {
        super();
    }
        
    public Client( String nomClient ) {
        super();
        this.nomClient = nomClient;
    }

    // Getters & Setters
    
    public long getCodeClient() {
        return codeClient;
    }

    public void setCodeClient( long codeClient ) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient( String nomClient ) {
        this.nomClient = nomClient;
    }
 
    @JsonIgnore
    @XmlTransient
    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes( Collection<Compte> comptes ) {
        this.comptes = comptes;
    }

}
