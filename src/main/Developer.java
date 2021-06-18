package main;

public class Developer extends Employee {

    public Developer(String name, Manager manager) {
        this.setName(name);
        this.setParent(manager);
        manager.addSubDevelopers(this);
    }
}