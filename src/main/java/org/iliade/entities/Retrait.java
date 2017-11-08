package org.iliade.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

}
