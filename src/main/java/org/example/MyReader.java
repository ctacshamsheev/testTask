package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String getNext() throws EOFException {
        if (sc.hasNextLine()) {
            String result = sc.nextLine();
            if (result.contains(" ") || result.contains("\t")) {
                System.out.println("Error input: " + filename + " String contains a whitespace character:" + result);
                return getNext();
            } else {
                return result;
            }
        } else {
            throw new EOFException();
        }
    }

    public void setNext() throws EOFException {
        previous = current;
        current = getNext();
        while (previous != null && isSorted(current, previous)) {
            System.out.println("Error input: " + filename +  " Not sorted file, skip:\t" + current + "\t(previous: " + previous + ")");
            current = getNext();
        }
    }


    public boolean isSearch(IReadable other) {
        return isSorted(other.getCurrent(), current);
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
