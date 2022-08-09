package org.example;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MergeSort {
    Parser attributes = null;

    MergeSort(Parser attributes) throws IllegalArgumentException, IOException {
        this.attributes = attributes;
        FileWriter writer = new FileWriter(attributes.getOutputFileName());
        ArrayList<IReadable> readersList = getReaderList(attributes.getInputFileNames(), attributes.isIntOrString(), attributes.isIncreaseOrDecrease());
        // sort and print
        while (readersList.size() > 0) {
            // search min or max
            int minIndex = 0;
            for (int i = 1; i < readersList.size(); i++) {
                if (readersList.get(minIndex).isSearch(readersList.get(i))) {
                    minIndex = i;
                }
            }
            // print min
            writer.write(readersList.get(minIndex).getCurrent() + "\n");
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
        System.out.println("Sort finished. Open: " + attributes.getOutputFileName());
    }

    private ArrayList<IReadable> getReaderList(ArrayList<String> filenames, boolean typeFlag, boolean sortFlag) {
        ArrayList<IReadable> readersList = new ArrayList<IReadable>();
        for (String filename : filenames) {  // input files
            try {
                if (typeFlag) { // int file
                    readersList.add(new MyReaderInt(filename, sortFlag));
                } else { // string file
                    readersList.add(new MyReader(filename, sortFlag));
                }
            } catch (IOException e) { // file not found
                System.out.println(e.getMessage());
            }
        }
        return readersList;
    }

}
