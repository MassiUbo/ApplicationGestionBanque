package org.iliade.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")

public class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne() {
        super();
    }

    // constructeur via super () + attriubt taux
    public CompteEpargne( String codeCompte, Date dateCreation, double solde, double taux ) {
        super( codeCompte, dateCreation, solde );
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux( double taux ) {
        this.taux = taux;
    } 
    
    
}
