package org.iliade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@Table( name = "GROUPES" )
public class Groupe implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long                numGroupe;
    private String              nomGroupe;

    // Association (ici biderctionnelle donc ManyToMany)
    @ManyToMany(mappedBy="groupes")     
    private Collection<Employe> employes;
    

    public Groupe( String nomGroupe ) {
        super();
        this.nomGroupe = nomGroupe;
    }

    public Groupe() {
        super();
    }

    public Long getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe( Long numGroupe ) {
        this.numGroupe = numGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe( String nomGroupe ) {
        this.nomGroupe = nomGroupe;
    }

    public Collection<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes( Collection<Employe> employes ) {
        this.employes = employes;
    }

}
