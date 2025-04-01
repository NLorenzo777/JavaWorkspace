package org.projects.simple.medievalserialization;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class Weapon implements Serializable {

    /* Class Variables */
    @Serial
    private static final long serialVersionUID = 1L;

    /* Instance Variables */
    private final String name;
    private final int damage;

    /* Constructors */
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

}