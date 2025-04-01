package org.projects.simple.medievalserialization;

import java.io.Serial;
import java.io.Serializable;

public class Trouser extends Armour implements Serializable {

    /* Class Variables */
    @Serial
    private static final long serialVersionUID = 1L;

    /* Constructors */
    public Trouser(String name, int durability, int defenseRating) {
        super(name, durability, defenseRating);
    }
}