package org.example;

import java.io.EOFException;

public interface IReadable {
    public void setNext()throws EOFException ;
       public boolean  isSearch(IReadable other);
    public String toString();
    public String getCurrent(); // todo erase

}
