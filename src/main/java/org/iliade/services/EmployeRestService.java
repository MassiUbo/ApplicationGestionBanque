package org.iliade.services;

import java.util.List;

import org.iliade.entities.Employe;
import org.iliade.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author MASSI
 *
 */
@RestController
public class EmployeRestService {
    
    @Autowired
    private EmployeMetier employeMetier ;

   /**
    * Sauvgarder un Employer via POST 
    * @param e : Employe
    * 
    */
    @RequestMapping(value = "/employes",method=RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e ) {
        return employeMetier.saveEmploye( e );
    }

    /**
     * Recuprer liste d'employer via méthode GET
     * @return liste d'employes
     * 
     */
    @RequestMapping(value = "/employes",method=RequestMethod.GET)
    public List<Employe> listeEmploye() {
        return employeMetier.listeEmploye();
    }

}
