package org.example;

import java.io.IOException;

// mvn package
// java -jar target/testTask-1.0-SNAPSHOT.jar -i -d out.txt in1.txt in2.txt

public class Main {
    public static void main(String[] args) {
        try {
           // new MergeSort(args);
            new MergeSort(new String[]{"-i", "-d", "out.txt", "test1.txt"});
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}