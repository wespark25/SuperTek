package main;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepartmentTest {


    @Test
    public void testComplexTree() {
        //Three heads of the department.
        Department superTek = new Department("SuperTek");
        Manager rebecca = new Manager("Rebecca", superTek); //600
        Manager susan = new Manager("Susan", superTek); //600
        Manager frank = new Manager("Frank", superTek); // 600 / No subordinates.

        //Rebecca's team of managers.
        Manager don = new Manager("Don", rebecca); //600 / No subordinates.
        Manager sam = new Manager("Sam", rebecca); //600 / No subordinates.
        Manager anna = new Manager("Anna", rebecca); //600 / No subordinates.

        //Susan's team
        Developer gary = new Developer("Gary", susan); //2000
        Developer tom = new Developer("Tom", susan); //2000
        QATester gale = new QATester("Gale", susan); // 1000
        Manager carol = new Manager("Carol", susan); //600
        Manager louis = new Manager("Louis", susan); //600 / No subordinates.

        //Carol's team
        Developer jeff = new Developer("Jeff", carol); //2000
        QATester harry = new QATester("Harry", carol); // 1000
        Manager john = new Manager("john", carol); //600 / No subordinates.

        System.out.println("Cost of the Department is " + superTek.costOfDepartment());
        System.out.println("Cost of the Susan's team is " + susan.costOfSubordinates());
        System.out.println("Here are the managers with no subordinates: ");
        ArrayList<Manager> managersWithNoSubordinates = superTek.managersWithNoSubordinates();
        for (Manager manager:
                managersWithNoSubordinates) {
            System.out.printf("-> " + manager.getName());
        }
    }

}