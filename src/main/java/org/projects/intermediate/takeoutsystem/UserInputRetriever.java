package org.projects.intermediate.takeoutsystem;

public interface UserInputRetriever<T> {

    T produceOutput(int selection) throws IllegalArgumentException;
}
