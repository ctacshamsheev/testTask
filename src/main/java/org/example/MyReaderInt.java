package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MyReaderInt implements IReadable {
    private boolean isIncreaseOrDecrease; // sort type
    private Scanner sc = null;
    private String filename = null;
    private Integer previous = null;
    private Integer current = null;

    /* class implements reading int value from file, implements validation, and checks for order */
    MyReaderInt(String filename, boolean isIncreaseOrDecrease) throws FileNotFoundException, EOFException {
        this.filename = filename;
        this.sc = new Scanner(new File(filename));
        this.isIncreaseOrDecrease = isIncreaseOrDecrease;
        setNext();
    }

    @Override
    public void setNext() throws EOFException, NoSuchElementException {
        previous = current;
        current = getNext();
        while (previous != null && isSorted(current, previous)) {
            System.out.println("Error input: " + filename + " Not sorted file, skip:\t" + current + "\t(previous: " + previous + ")");
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

    private int getNext() throws EOFException {
        if (sc.hasNextLine()) {
            String result = sc.nextLine();
            if (result.contains(" ") || result.contains("\t") || result.length() == 0) {
                System.out.println("Error input: " + filename + " String contains a whitespace character or empty:" + result);
                return getNext();
            } else {
                try {
                    return Integer.parseInt(result);
                } catch (NumberFormatException e) {
                    System.out.println("Error input: " + filename + " Convert to int error:" + result);
                    return getNext();
                }
            }
        } else {
            throw new EOFException("empty file or incorrect: " + filename);
        }

    }

    private boolean isSorted(int first, int second) {
        return (isIncreaseOrDecrease) ? first < second : first > second;
    }
}
