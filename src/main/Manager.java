package main;

import java.util.ArrayList;

public class Manager extends Employee {

    private ArrayList<Manager> subManagers = new ArrayList<>();
    private ArrayList<QATester> subQATesters = new ArrayList<>();
    private ArrayList<Developer> subDevelopers = new ArrayList<>();

    public ArrayList<Manager> getSubManagers() {
        return subManagers;
    }

    public void setSubManagers(ArrayList<Manager> subManagers) {
        this.subManagers = subManagers;
    }

    public void addSubManager(Manager manager) {
        subManagers.add(manager);
    }

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

    //When you create a Manager they must either report to another manager or they must be listed as a head of a department

    public Manager(String name, Manager manager) {
        this.setName(name);
        this.setParent(manager);
        manager.addSubManager(this);
    }

    public Manager(String name, Department department) {
        this.setName(name);
        department.addManager(this);
    }

    //Method for calculating the cost of any manager's team. This includes the cost of the root manager.
    public Integer costOfTeam() {
        int total = (subDevelopers.size() * 2000) + (subQATesters.size() * 1000) + 600;
        for (Manager manager :
                subManagers) {
            total += manager.costOfTeam();
        }
        return total;
    }

    //Method for finding any managers at this level or under that don't have any subordinates.
    public ArrayList<Manager> managersWithNoSubordinates() {
        ArrayList<Manager> managers = new ArrayList<Manager>();
        if (this.subManagers.size() == 0 && this.subQATesters.size() == 0 && this.subDevelopers.size() == 0) {
            managers.add(this);
            return managers;
        } else if (this.subManagers.size() != 0) {
            for (Manager manager :
                    subManagers) {
                managers.addAll(manager.managersWithNoSubordinates());
            }
        }
        return managers;
    }
}


