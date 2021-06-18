package main;

import java.util.ArrayList;

public class Department {

    // The Department works as the root node of the tree.
    private String name;

    //An assumption I'm making here is that the head/heads of each department are always going to be managers.
    private ArrayList<Manager> departmentHeads = new ArrayList<>();

    public ArrayList<Manager> getDepartmentHeads() { return departmentHeads; }

    public void setDepartmentHeads(ArrayList<Manager> departmentHeads) { this.departmentHeads = departmentHeads; }

    public void addManager(Manager manager) {
        this.departmentHeads.add(manager);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Department(String name) { this.name = name; }

    //Method for calculating the cost of the entire department.
    public Integer costOfDepartment() {
        Integer total = 0;
        for (Manager manager :
                departmentHeads) {
            total += manager.costOfSubordinates();
        }
        return total;
    }

    //Method for searching a department for managers with no subordinates.
    public ArrayList<Manager> managersWithNoSubordinates() {
        ArrayList<Manager> managers = new ArrayList<>();
        for (Manager manager :
                departmentHeads) {
            managers.addAll(manager.managersWithNoSubordinates());
        }
        return managers;
    }
}
