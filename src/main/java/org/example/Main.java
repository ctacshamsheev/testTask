package org.example;

import java.io.IOException;
import java.util.*;
import java.io.*;

//  mvn package
// java -jar target/testTask-1.0-SNAPSHOT.jar -i -d out.txt in1.txt in2.txt

public class Main {
    public static void main(String[] args) {
        //System.out.println( new Parser(args));
        try {
            new MergeSort(new String[]{"-i", "-d", "out.txt", "test1.txt", "test4.txt"});
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}