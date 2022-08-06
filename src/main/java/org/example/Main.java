package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args)  {

        ArrayList<MyReader> readerList = new ArrayList<MyReader>();


        for (int i=1; i<5; i++) {
            try {
                readerList.add(new MyReader ("test"+i+".txt"));
            }  catch (IOException e) {
                System.out.println(e.toString());
        }

      }

        while (readerList.size()>0) {
            Iterator<MyReader> it = readerList.iterator();//создаем итератор
            while(it.hasNext()) {//до тех пор, пока в списке есть элементы
                MyReader nextReader = it.next();//получаем следующий элемент
                try {
//                    ArrayList<String> strings = new ArrayList<String>();
//                    strings.add(nextReader.getNext());

                    System.out.println("("+nextReader.getNext()+")");
                } catch (EOFException e) {
                    nextReader.close();
                    it.remove();
                }
            }
        }
//        while (r1.isNext() && r2.isNext()) {
//
//            if () {
//
//            }
//        }
//        while (r1.isNext() && r2.isNext()){
//            System.out.println("("+r1.getNext() +")["+ r2.getNext()+"]");
//        }
//        while (r1.isNext() ){
//            System.out.println("("+r1.getNext() +")");
//        }
//        while (r2.isNext()){
//            System.out.println("["+ r2.getNext()+"]");
//        }
//
//
//    for (MyReader ptr : readerList) {
//        ptr.close();
//    }



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