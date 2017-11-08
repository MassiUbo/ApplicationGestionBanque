package org.iliade.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )

// nometype par default c'est TYPE, type default c String , length Default c'est 2

// ajout JsonTypeinfo pour distinguer entre Compte Courant et Compte Epargne

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type" )
@JsonSubTypes( {
        @Type( name = "CC", value = CompteCourant.class ),
        @Type( name = "CE", value = CompteEpargne.class )
} )

@XmlSeeAlso ({CompteCourant.class,CompteEpargne.class})

@DiscriminatorColumn( name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2 )
public abstract class Compte implements Serializable {
    
    @Id // pas de generated value car C'est Un string
    private String                codeCompte;
    private Date                  dateCreation;
    private double                solde;
    @ManyToOne
    @JoinColumn( name = "CODE_CLI" )        // Clé etrangere
    private Client                client;
    @ManyToOne
    @JoinColumn( name = "CODE_EMP" )
    private Employe               employe;

    // Compte peut subir +ieurs Operations doc OneToMany
    
    @OneToMany( mappedBy = "compte" )
    private Collection<Operation> operations;

    public Compte() {
        super();
    }

    public Compte( String codeCompte, Date dateCreation, double solde ) {
        super();
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte( String codeCompte ) {
        this.codeCompte = codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( Date dateCreation ) {
        this.dateCreation = dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde( double solde ) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye( Employe employe ) {
        this.employe = employe;
    }

    
    @JsonIgnore
    @XmlTransient
    
    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations( Collection<Operation> operations ) {
        this.operations = operations;
    }

}
