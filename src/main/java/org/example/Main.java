package org.example;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyReader r1 = new MyReader ("test1.txt");
        MyReader r2 = new MyReader ("test2.txt");

        while (r1.isNext() && r2.isNext()){
            System.out.println("("+r1.getNext() +")["+ r2.getNext()+"]");
        }
        while (r1.isNext() ){
            System.out.println("("+r1.getNext() +")");
        }
        while (r2.isNext()){
            System.out.println("["+ r2.getNext()+"]");
        }

        r1.close();
        r2.close();




        //        FileWriter writer = null;
//        try {
//            writer = new FileWriter("test1.txt");
//            writer.write(Integer.toString(5));
//            writer.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}