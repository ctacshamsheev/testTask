package org.example;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MergeSort {
    private ArrayList<IReadable> getReaderList(ArrayList<String> filenames) {
        ArrayList<IReadable> readersList = new ArrayList<IReadable>();
        for (String filename : filenames) {
            try {
                readersList.add(new MyReaderInt(filename));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return readersList;
    }

    MergeSort(String[] args) throws IllegalArgumentException, IOException {
        Parser attributes  = new Parser(args);
        FileWriter writer = new FileWriter(attributes.getOutputFileName());
        ArrayList<IReadable> readersList = getReaderList(attributes.getInputFileNames());

        // sort and print
        while (readersList.size() > 0) {

            // search min
            int minIndex = 0;
            for (int i = 1; i < readersList.size(); i++) {
                if (readersList.get(minIndex).isMore(readersList.get(i))) {
                    minIndex = i;
                }
            }
            // print min
            writer.write(readersList.get(minIndex).getCurrent() + "\n");
            // System.out.println("min = " + readersList.get(minIndex).getCurrent() + " from " + readersList.get(minIndex));
            // min next
            try {
                //install next
                readersList.get(minIndex).setNext();
            } catch (EOFException | NoSuchElementException e) {
                // remove file
                readersList.remove(minIndex);
            }
        }
        writer.close();
    }

}
