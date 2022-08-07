package org.example;

import java.util.ArrayList;

public class Parser {
    private ArrayList<String> inputFileNames = null;
    private String outputFileName = null;
    private boolean isIntOrString = false; // int - true; string - false;
    private boolean isIncreaseOrDecrease = true; // Increase - true; Decrease - false;

    Parser(String[] args) {
        inputFileNames = new ArrayList<>();
        for (String arg : args) {
            if (arg.charAt(0) == '-') {
                switch (arg) {
                    case "-i":
                        isIntOrString = true;
                        break;
                    case "-s":
                        isIntOrString = false;
                        break;
                    case "-a":
                        isIncreaseOrDecrease = true;
                        break;
                    case "-d":
                        isIncreaseOrDecrease = true;
                        break;
                    default:
                        System.out.println("Oooops, something wrong !");
                }
            } else {
                if (outputFileName == null) {
                    outputFileName = arg;
                } else {
                    inputFileNames.add(arg);
                }
            }
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

    @Override
    public String toString() {
        return "Parser{" +
                "inputFileNames=" + inputFileNames +
                ", outputFileName='" + outputFileName + '\'' +
                ", isIntOrString=" + isIntOrString +
                ", isIncreaseOrDecrease=" + isIncreaseOrDecrease +
                '}';
    }
}
