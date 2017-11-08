package org.iliade.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("CC")  
@XmlType(name="CC")

public class CompteCourant extends Compte {
    private double  decouvert;

    public CompteCourant() {
        super();
    }
    
    // Constructeur via super() + attribut decouvert
    
    public CompteCourant( String codeCompte, Date dateCreation, double solde, double decouvert ) {
        super( codeCompte, dateCreation, solde );
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert( double decouvert ) {
        this.decouvert = decouvert;
    } 
    
   
}
