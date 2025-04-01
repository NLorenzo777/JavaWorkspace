package org.projects.simple.medievalserialization;

import java.io.Serial;
import java.io.Serializable;

public class Shirt extends Armour implements Serializable {

    /* Class Variables */
    @Serial
    private static final long serialVersionUID = 1L;

    /* Constructors */
    public Shirt(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}