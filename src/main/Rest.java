package main;

public class Rest {
    //TODO For Testing purposes
    public static void parentTree(Employee employee){
        System.out.println(employee.getName() + " -> ");
        if(employee.getParent() != null){
            parentTree(employee.getParent());
        }
    }
}
