package org.iliade.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * 
 * @author MASSI
 *
 */
@Entity
public class Employe implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long               codeEmploye;
    private String             nomEmploye;

    // Associations
    @ManyToOne
    @JoinColumn( name = "code_emp_sup" )
    private Employe            employeSup; 
    
    // ici c'est une association
    // reflexive
    // on devrai avoir une collection dans groupe qui s'appel employes
    
    @ManyToMany
    @JoinTable( name = "EMP_GR" )
    private Collection<Groupe> groupes;

    public Employe( String nomEmploye ) {
        super();
        this.nomEmploye = nomEmploye;
    }

    public Employe() {
        super();
    }

    // getters & setters
    public Long getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye( Long codeEmploye ) {
        this.codeEmploye = codeEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye( String nomEmploye ) {
        this.nomEmploye = nomEmploye;
    }

    @JsonIgnore
    public Employe getEmployeSup() {
        return employeSup;
    }

    @JsonSetter
    public void setEmployeSup( Employe employeSup ) {
        this.employeSup = employeSup;
    }

    @JsonIgnore
    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    @JsonSetter
    public void setGroupes( Collection<Groupe> groupes ) {
        this.groupes = groupes;
    }

}
