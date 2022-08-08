package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyReader implements IReadable {
    private boolean isIncreaseOrDecrease;
    private Scanner sc = null;
    private String filename = null;
    private String previous = null;
    private String current = null;


    MyReader(String filename, boolean isIncreaseOrDecrease) throws FileNotFoundException, EOFException {
        this.filename = filename;
        this.sc = new Scanner(new File(filename));
        this.isIncreaseOrDecrease = isIncreaseOrDecrease;
        setNext();
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
        current = sc.next();
        while (previous != null && isSorted(current, previous)) {
            System.out.println("Not sorted: " + filename + " skip: " + current);
            current = sc.next();
        }
    }



    public boolean isSearch(IReadable other) {
        return   isSorted(other.getCurrent(), current);
    }


    @Override
    public String toString() {
        return "[" +
                this.filename +
                ']' + current;
    }

    private boolean isSorted(String first, String second) {
        return (isIncreaseOrDecrease) ? first.compareTo(second) < 0 : first.compareTo(second) > 0;
    }
}
