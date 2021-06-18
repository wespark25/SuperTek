package main;

public class Employee {

    private String name;

    private Manager parent = null;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {

    }

    public Employee(String name, Manager parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getParent() {
        return parent;
    }

    public void setParent(Manager parent) {
        this.parent = parent;
    }


}
