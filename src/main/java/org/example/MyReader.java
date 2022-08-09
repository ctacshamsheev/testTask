package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* class implements reading text strings from file, implements validation, and checks for order */
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


    @Override
    public void setNext() throws EOFException {
        previous = current;
        current = getNext();
        while (previous != null && isSorted(current, previous)) {
            System.out.println("Error input: " + filename + " Not sorted file, skip:\t" + current + "\t(previous: " + previous + ")");
            current = getNext();
        }
    }

    @Override
    public boolean isSearch(IReadable other) {
        return isSorted(other.getCurrent(), current);
    }

    @Override
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
            throw new EOFException("empty file or incorrect: " + filename);
        }
    }

    private boolean isSorted(String first, String second) {
        return (isIncreaseOrDecrease) ? first.compareTo(second) < 0 : first.compareTo(second) > 0;
    }
}
