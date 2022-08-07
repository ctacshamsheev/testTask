package org.example;

import java.io.IOException;
import java.util.*;
import java.io.*;


public class Main {

    public static ArrayList<IReadable> getReaderList(ArrayList<String> filenames) {
        ArrayList<IReadable> readersList = new ArrayList<IReadable>();
        for (String filename : filenames) {
            try {
                readersList.add(new MyReaderInt(filename));
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return readersList;
    }

    public static void main(String[] args) {
        System.out.println( new Parser(new String[]{"-i", "-a", "out.txt", "in.txt"}).toString()); // sort-it.exe -i -a out.txt in.txt
        System.out.println( new Parser(new String[]{"-s", "out.txt", "in1.txt", "in2.txt", "in3.txt"}).toString()); // sort-it.exe -s out.txt in1.txt in2.txt in3.txt
        System.out.println( new Parser(new String[]{"-d", "-s", "out.txt", "in1.txt", "in2.txt"}).toString()); // sort-it.exe -d -s out.txt in1.txt in2.txt
        ArrayList<String> filenames = new ArrayList<>();

        for (int i = 1; i < 7; i++) { // TODO args list
            filenames.add("test" + i + ".txt");
        }

        ArrayList<IReadable> readersList = getReaderList(filenames);

        while (readersList.size() > 0) {
            ArrayList<String> strings = new ArrayList<String>();
            for (IReadable reader : readersList) {
                strings.add(reader.getCurrent());
            }
//            // TODO getmin
//            String minValue = Collections.min(strings, String.CASE_INSENSITIVE_ORDER);
//            System.out.println("min = " + minValue + " from " + strings);

            int minIndex = 0;
            for (int i = 1; i < readersList.size(); i++) {
                if (readersList.get(minIndex).isMore(readersList.get(i))) {
                    minIndex = i;
                }
            }

            System.out.println("min = " + readersList.get(minIndex).getCurrent() + " from " + readersList.get(minIndex));
            // min next
            try {
                readersList.get(minIndex).setNext();
            } catch (EOFException e) {
                readersList.remove(minIndex);
            } catch (NoSuchElementException e) {
                readersList.remove(minIndex);
            }
        }
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