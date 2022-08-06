package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static ArrayList<MyReader> getReaderList(ArrayList<String> filenames) {
        ArrayList<MyReader> readersList = new ArrayList<MyReader>();
        for (String filename : filenames) {
            try {
                readersList.add(new MyReader(filename));
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return readersList;
    }

    public static void main(String[] args) {
        ArrayList<String> filenames = new ArrayList<>();

        for (int i = 1; i < 5; i++) { // TODO args list
            filenames.add("test" + i + ".txt");
        }

        ArrayList<MyReader> readersList = getReaderList(filenames);

        while (readersList.size() > 0) {
            Iterator<MyReader> readerIterator = readersList.iterator();
            ArrayList<String> strings = new ArrayList<String>();

            while (readerIterator.hasNext()) {
                MyReader reader = readerIterator.next();
                strings.add(reader.getCurrent());
//                System.out.println("(" + reader.getCurrent() + ")");
            }
            // getmin
            String minValue = Collections.min(strings, String.CASE_INSENSITIVE_ORDER);
            System.out.println("min = " + minValue);


            // min next
            readerIterator = readersList.iterator();
            while (readerIterator.hasNext()) {
                MyReader reader = readerIterator.next();
                if (reader.getCurrent().equals(minValue))
                    try {
                        reader.setNext();
                    } catch (EOFException e) {
                        readerIterator.remove();
                    }
            }


//            try {
//
//                reader.setNext();
//            } catch (EOFException e) {
//                readerIterator.remove();
//            }
            //
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
//    for (MyReader ptr : readersList) {
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