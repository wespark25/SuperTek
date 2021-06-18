package main;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Tests {

    //Three heads of the department.
    Department superTek = new Department("SuperTek");
    Manager rebecca = new Manager("Rebecca", superTek); //600
    Manager susan = new Manager("Susan", superTek); //600
    Manager frank = new Manager("Frank", superTek); // 600 / No subordinates.

    //Rebecca's team of managers with no subordinates.
    Manager don = new Manager("Don", rebecca); //600 / No subordinates.
    Manager sam = new Manager("Sam", rebecca); //600 / No subordinates.
    Manager anna = new Manager("Anna", rebecca); //600 / No subordinates.

    //Susan's team. This includes Carol's team as well.
    Developer gary = new Developer("Gary", susan); //2000
    Developer tom = new Developer("Tom", susan); //2000
    QATester gale = new QATester("Gale", susan); // 1000
    Manager carol = new Manager("Carol", susan); //600
    Manager louis = new Manager("Louis", susan); //600 / No subordinates.

    //Carol's team
    Developer jeff = new Developer("Jeff", carol); //2000
    QATester harry = new QATester("Harry", carol); // 1000
    Manager john = new Manager("john", carol); //600 / No subordinates.


    //I assumed that the cost of a manager's team should include the manager as well
    @Test
    public void costOfManagersTeam() {
        assertEquals(10400, susan.costOfTeam().longValue());
    }

    @Test
    public void costOfDepartment() {
        assertEquals(13400, superTek.costOfDepartment().longValue());
    }

    @Test
    public void checkDepartmentForManagersWithNoSubordinates() {
        List<Manager> managerList = Arrays.asList(sam, john, anna, louis, don, frank);
        ArrayList<Manager> expectedResult = new ArrayList<Manager>();
        expectedResult.addAll(managerList);
        ArrayList<Manager> desiredResult = superTek.managersWithNoSubordinates();

        assertTrue(desiredResult.containsAll(expectedResult));
    }

    @Test
    public void checkManagerForOtherManagersWithNoSubordinates() {
        List<Manager> managerList = Arrays.asList(john, louis);
        ArrayList<Manager> expectedResult = new ArrayList<Manager>();
        expectedResult.addAll(managerList);
        ArrayList<Manager> desiredResult = susan.managersWithNoSubordinates();

        assertTrue(desiredResult.containsAll(expectedResult));
    }
}