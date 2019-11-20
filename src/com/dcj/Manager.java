package com.dcj;

public class Manager extends Employee{
    private double bonus;

    public Manager(int salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + (this.getSalary()) +
                '}';
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary() {//访问方法
        //System.out.println("这里是访问方法");
        double salary = super.getSalary();
        return salary + this.bonus;
    }

}
