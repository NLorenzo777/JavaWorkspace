package org.projects.intermediate.takeoutsystem;

public interface PricedItem<T extends Number> {

    public T getprice();
    public void setPrice(T price);

}
