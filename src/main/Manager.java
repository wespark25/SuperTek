package main;

import java.util.ArrayList;

public class Manager extends Employee {

    //I made three separate ArrayLists of subordinates based on employee type because the cost of each employee is
    //static. This way when I am totaling the cost of a manager's subordinates I only
    //have to calculate the total number of QATesters and Developers they have. I built this assuming that a manager of
    //a team of developers/QATesters might also still be the manager of another manager and didn't necessarily have to be the
    //bottom end of the chain of managers.

    //TODO is it still worth splitting these into three?
    private ArrayList<Manager> subManagers = new ArrayList<>();
    private ArrayList<QATester> subQATesters = new ArrayList<>();
    private ArrayList<Developer> subDevelopers = new ArrayList<>();

    public ArrayList<Manager> getSubManagers() {
        return subManagers;
    }

    public void setSubManagers(ArrayList<Manager> subManagers) {
        this.subManagers = subManagers;
    }

    public void addSubManager(Manager manager) { subManagers.add(manager) ; }

    public ArrayList<QATester> getSubQATesters() {
        return subQATesters;
    }

    public void setSubQATesters(ArrayList<QATester> subQATesters) {
        this.subQATesters = subQATesters;
    }

    public void addSubQATesters(QATester qaTester) {
        subQATesters.add(qaTester);
    }

    public ArrayList<Developer> getSubDevelopers() {
        return subDevelopers;
    }

    public void setSubDevelopers(ArrayList<Developer> subDevelopers) {
        this.subDevelopers = subDevelopers;
    }

    public void addSubDevelopers(Developer developer) {
        this.subDevelopers.add(developer);
    }

    public Manager(String name, Manager manager) {
        this.setName(name);
        this.setParent(manager);
        manager.addSubManager(this);
    }

    //For creating a the head of a department
    public Manager(String name, Department department) {
        this.setName(name);
        department.addManager(this);
    }

    public Manager(String name) {
        this.setName(name);
    }

    //TODO rename this to be inclusive of manager. Just find correct term.
    //Method for calculating the cost of any manager's team. This includes the cost of the root manager.
    public Integer costOfSubordinates() {
        int total = (subDevelopers.size() * 2000) + (subQATesters.size() * 1000) + 600;
        for (Manager manager :
                subManagers) {
            total += manager.costOfSubordinates();
        }
        return total;
    }

    //TODO rename
    //TODO explain why you chose do all these Recursive methods instead of Caching
    //Instead of this I could have a separate class of managers.
    public ArrayList<Manager> managersWithNoSubordinates() {
        ArrayList<Manager> managers = new ArrayList<Manager>();
        if (this.subManagers.size() == 0 && this.subQATesters.size() == 0 && this.subDevelopers.size() == 0) {
            managers.add(this);
            return managers;
        } else if (this.subManagers.size() != 0) {
            for (Manager manager :
                    subManagers) {
                //TODO what if this function provides an empty list?
                managers.addAll(manager.managersWithNoSubordinates());
            }
        }
        return managers;
    }
}


