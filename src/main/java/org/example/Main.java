package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static ArrayList<IReadable> getReaderList(ArrayList<String> filenames) {
        ArrayList<IReadable> readersList = new ArrayList<IReadable>();
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

        for (int i = 1; i < 7; i++) { // TODO args list
            filenames.add("test" + i + ".txt");
        }

        ArrayList<IReadable> readersList = getReaderList(filenames);

        while (readersList.size() > 0) {
            // Iterator<IReadable> readerIterator = readersList.iterator();


            ArrayList<String> strings = new ArrayList<String>();
            //String minValue = readersList[0];
            for (IReadable reader : readersList) {
                strings.add(reader.getCurrent());
            }

//            while (readerIterator.hasNext()) {
//                IReadable reader = readerIterator.next();
//                strings.add(reader.getCurrent());
////                System.out.println("(" + reader.getCurrent() + ")");
//            }
            // getmin
            String minValue = Collections.min(strings, String.CASE_INSENSITIVE_ORDER);
            System.out.println("min = " + minValue + " from " + strings);


            // min next

            Iterator<IReadable> readerIterator = readersList.iterator();
            while (readerIterator.hasNext()) {

                IReadable reader = readerIterator.next();

                if (minValue.compareTo(reader.getCurrent()) == 0) {
                  //  System.out.println(reader);
                    try {
                        reader.setNext();
                    } catch (EOFException e) {
                        readerIterator.remove();
                    }
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
//    for (IReadable ptr : readersList) {
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