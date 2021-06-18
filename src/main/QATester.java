package main;

public class QATester extends Employee {

    public QATester(String name, Manager manager) {
        this.setName(name);
        this.setParent(manager);
        this.getParent().addSubQATesters(this);
    }
}
