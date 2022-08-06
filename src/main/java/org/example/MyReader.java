package org.example;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyReader {
    private Scanner sc = null;
//    private String filename = null;
//    private String previous = null;


    MyReader(String filename) throws FileNotFoundException {
      //  this.filename = filename;
        this.sc =  new Scanner(new File(filename));

    }

    public String getNext() throws EOFException {
        if (!isNext()) {
            throw new EOFException();
        }
        return sc.next();
//        String result = sc.next();
//        if (previous != null && result!= null ) {
//            if ( result.compareTo(previous) >= 0) { // TODO comparator
//
//                previous = result;
//                return result;
//            } else {  // TODO exception
//                System.out.println("not sorted");
//                previous = result;
//                return result;
//            }
//        } else {
//            previous = result;
//            return result;
//        }
    }

    public boolean isNext(){
        return sc.hasNext();
    }

    public void close() {
        sc.close();
    }

}
