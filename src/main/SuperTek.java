package main;

import java.util.ArrayList;

public class SuperTek {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

         Manager gary = new Manager("Gary");
         Manager grace = new Manager("Grace", gary);
         Manager kevin = new Manager("Kevin", grace);
         Developer wes = new Developer("Wes", grace);
         QATester quincy = new QATester("Quincy", grace);

        Department superTek = new Department("main.SuperTek");
        superTek.addManager(gary);
        superTek.addManager(new Manager("Horace"));

        ArrayList<Manager> managersWithNoSubordinates = superTek.managersWithNoSubordinates();


        Rest.parentTree(quincy);
        System.out.println("Cost of Gary's team is " + gary.costOfSubordinates());
        System.out.println("Cost of main.SuperTek is " + superTek.costOfDepartment() + "\n");

        System.out.println("Here are the managers with no subordinates: ");
        for (Manager manager:
                managersWithNoSubordinates) {
            System.out.printf("-> " + manager.getName());
        }


        //My biggest decision when making this application was how I wanted to go about calculating the total cost of a managers subordinates.

    }
}
