package org.iliade.metier;

import java.util.List;

import org.iliade.entities.Employe;

public interface EmployeMetier {
    
    public Employe saveEmploye(Employe e);
    public List<Employe> listeEmploye();

}
