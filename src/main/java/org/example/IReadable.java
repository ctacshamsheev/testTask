package org.example;

import java.io.EOFException;

/* interface file reading for sorting */
public interface IReadable {
    void setNext() throws EOFException; // read next correct value or throw EOF file

    boolean isSearch(IReadable other); // sort condition. find min or max value

    String getCurrent(); // current value in file
}
