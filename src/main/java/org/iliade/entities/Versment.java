package org.iliade.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * @author MASSI
 *
 */

@Entity
@DiscriminatorValue("V")
public class Versment extends Operation {
    
}
