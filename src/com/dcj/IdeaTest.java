package com.dcj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdeaTest {


    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.addAll(Arrays.asList(new Employee(2000),new Manager(200,100)));
        staff.sort((t1,t2)->t1.getSalary()>t2.getSalary()?1:-1);
        System.out.println(staff);

    }

}

