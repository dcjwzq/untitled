package com.dcj;


import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

class PersonTest{
    public static void main(String[] args) {
        String className = "com.dcj.Student";
        try {
            Class cl = Class.forName(className);
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }



            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
public abstract class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
