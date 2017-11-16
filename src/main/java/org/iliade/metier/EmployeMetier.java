package org.iliade.metier;

import java.util.List;

import org.iliade.entities.Employe;

/**
 * 
 * @author MASSI
 *
 */
public interface EmployeMetier {
    
    public Employe saveEmploye(Employe e);
    public List<Employe> listeEmploye();

}
