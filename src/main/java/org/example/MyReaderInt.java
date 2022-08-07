package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyReaderInt implements IReadable {

    private Scanner sc = null;
    private String filename = null;
    private Integer previous = null;
    private Integer current = null;

    MyReaderInt(String filename) throws FileNotFoundException, EOFException {
        this.filename = filename;
        this.sc = new Scanner(new File(filename));
        setNext();
    }

    @Override
    public void setNext() throws EOFException , NoSuchElementException {
        if (!sc.hasNext()) {
            sc.close();
            throw new EOFException();
        }
        previous = current;
        //     System.out.println("setNext : " + this);

        current = sc.nextInt();
        while (previous != null && isSorted() ) {
            // TODO comparator
            // TODO exception
//            throw new EOFException();
            System.out.println("not sorted: " + current + "> skip");
            current = sc.nextInt();
        }
//        return current;
    }

    @Override
    public boolean isSorted() {
        return  current < previous;
    }

    @Override
    public boolean isMore(IReadable other) {

        return current > Integer.parseInt(other.getCurrent());
    }

    @Override
    public String getCurrent() {
        return  ""+ current;
        //return Integer.toString(current);
    }
    public String toString() {
        return "[" +
                this.filename +
                ']' + current;
    }
}
