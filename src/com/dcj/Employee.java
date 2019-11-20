package com.dcj;

import java.time.LocalDate;

class EmployeeTest {
    public static void main(String[] args) {

    }
}

public class Employee extends Person{
    private String name;
    private LocalDate hireDay;
    private double salary;

    {
        //System.out.println("这里是代码初始化");
        this.salary = 2000;
    }

    public Employee(int salary) {
        //System.out.println("这里是构造方法");
        this.salary = salary;
    }

    public Employee() {
        //System.out.println("这里是重载方法");
    }

    @Override
    public String getDescription() {
        return "a employee";
    }

    @Override
    public boolean equals(Object obj) {
        if (this.name == ((Employee) obj).name) return true;
        return false;
    }

    public Employee getBuddy(){
        Employee e = new Employee();
        return e;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}