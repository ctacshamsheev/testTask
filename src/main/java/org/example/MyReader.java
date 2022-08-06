package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyReader implements IReadable  {
    private Scanner sc = null;
    private String filename = null;
    private String previous = null;
    private String current = null;


    MyReader(String filename) throws FileNotFoundException, EOFException {

        this.filename = filename;
        this.sc = new Scanner(new File(filename));
        setNext();
//        System.out.println( "[" +
//                filename +
//                ']');
    }
    public String getCurrent() {
        return current;
    }

    public void setNext() throws EOFException {
        if (!sc.hasNext()) {
            sc.close();
            throw new EOFException();
        }
        previous = current;
   //     System.out.println("setNext : " + this);

        current = sc.next();
        if (previous != null && isMore() ) {
            // TODO comparator
            // TODO exception
//            throw new EOFException();
            System.out.println("not sorted");
        }
//        return current;
    }

    public boolean  isMore() {
       return current.compareTo(previous) < 0;
    }

    public boolean  isMore(MyReader other) {
        return current.compareTo(other.getCurrent()) < 0;
    }


    @Override
    public String toString() {
        return "[" +
                this.filename +
                ']' + current;
    }
}
