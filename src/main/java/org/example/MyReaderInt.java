package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MyReaderInt implements IReadable {
    private boolean isIncreaseOrDecrease;
    private Scanner sc = null;
    private String filename = null;
    private Integer previous = null;
    private Integer current = null;

    MyReaderInt(String filename, boolean isIncreaseOrDecrease) throws FileNotFoundException, EOFException {
        this.filename = filename;
        this.sc = new Scanner(new File(filename));
        this.isIncreaseOrDecrease = isIncreaseOrDecrease;
        setNext();
    }

    private int getNext() throws EOFException {
        if (sc.hasNext()) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error input: " + filename + " " + sc.nextLine());
                //throw new EOFException("Error input: " + filename + " " + sc.nextLine());
                return getNext();
            }
        } else {
            throw new EOFException();
        }
    }

    @Override
    public void setNext() throws EOFException, NoSuchElementException {
        previous = current;
        current = getNext();
        while (previous != null && isSorted(current, previous)) {
            System.out.println("Error input: " + filename +  " Not sorted file, skip:\t" + current + "\t(previous: " + previous + ")");
            current = getNext();
        }
    }


    @Override
    public boolean isSearch(IReadable other) {
        return isSorted(Integer.parseInt(other.getCurrent()), current);
    }

    @Override
    public String getCurrent() {
        return "" + current;
        //return Integer.toString(current);
    }

    public String toString() {
        return "[" +
                this.filename +
                ']' + current;
    }

    private boolean isSorted(int first, int second) {
        return (isIncreaseOrDecrease) ? first < second : first > second;
    }
}
