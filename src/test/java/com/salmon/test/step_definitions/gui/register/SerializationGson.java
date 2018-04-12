package com.salmon.test.step_definitions.gui.register;

public class SerializationGson {

    String name;
    String email;
    int age;
    boolean isTester;


    public static void main (String args[]){

        SerializationGson obj1 = new SerializationGson();

        obj1.divRunning();


    }


    public void divRunning(){

        System.out.println("Divya running");

    }



    public void add(int a, int b){

        int c = a + b;
    }


}
