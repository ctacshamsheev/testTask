package org.example;

import java.io.EOFException;

public interface IReadable {
    public void setNext()throws EOFException ;
    public boolean  isMore();
    public String toString();
    public String getCurrent(); // todo erase
}
