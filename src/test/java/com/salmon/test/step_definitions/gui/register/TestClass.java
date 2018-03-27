package com.salmon.test.step_definitions.gui.register;

import cucumber.api.java.eo.Se;

public class TestClass extends SerializationGson {


    public static void main(String args[]) {


        TestClass obj1 = new TestClass();
        obj1.divRunning();
        obj1.add(10,20,30);

    }




    public  void divRunning(){
        System.out.println("Divya jumping");

    }



    public void add(int a, int b, int c){

        int d = a + b + c;

    }


}

