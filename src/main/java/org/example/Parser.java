package org.example;

import java.util.ArrayList;

public class Parser {
    private ArrayList<String> inputFileNames = new ArrayList<>();
    private String outputFileName = null;
    private boolean isIntOrString = false; // int - true; string - false;
    private boolean isIncreaseOrDecrease = true; // Increase - true; Decrease - false;

    Parser(String[] args) throws IllegalArgumentException {
        boolean errNotOutput = true;
        boolean errNotInput = true;
        int errNotFlagsType = 0;
        int errNotFlagsSort = 0;

        // parsing input args
        for (String arg : args) {
            if (arg.charAt(0) == '-') { // parsing key
                switch (arg) {
                    case "-i":
                        isIntOrString = true;
                        errNotFlagsType++;
                        break;
                    case "-s":
                        isIntOrString = false;
                        errNotFlagsType++;
                        break;
                    case "-a":
                        isIncreaseOrDecrease = true;
                        errNotFlagsSort++;
                        break;
                    case "-d":
                        isIncreaseOrDecrease = false;
                        errNotFlagsSort++;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown argument: " + arg);
                }
            } else {
                if (outputFileName == null) { // first - output file
                    outputFileName = arg;
                    errNotOutput = false;
                } else if (arg.equals(outputFileName)) { // others - input files
                    throw new IllegalArgumentException("input and output files must be different: " + arg);
                } else {
                    inputFileNames.add(arg);
                    errNotInput = false;
                }
            }
        }
        if (errNotOutput || errNotInput || errNotFlagsType != 1 || errNotFlagsSort > 1) { // generate error
            String err = "Error argument: (" + args + ")";
            if (errNotOutput) err += " No output file!";
            if (errNotInput) err += " No input file!";
            if (errNotFlagsType != 1) err += " Use one type flag -i or -s!";
            if (errNotFlagsSort > 1) err += " Use only one flag -a or -d! ";
            throw new IllegalArgumentException(err);
        }
    }

    public ArrayList<String> getInputFileNames() {
        return inputFileNames;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public boolean isIntOrString() {
        return isIntOrString;
    }

    public boolean isIncreaseOrDecrease() {
        return isIncreaseOrDecrease;
    }
}
