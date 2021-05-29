package com.tms.docs_organize.runner;

import com.tms.docs_organize.checker.DocsChecker;
import com.tms.docs_organize.console_data.ConsoleData;

import java.io.*;
import java.util.ArrayList;

public class RunnerWrapper {
    public static void go(){
        ArrayList<BufferedReader> files = ConsoleData.getConsoleData();
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("final.txt"))) {
            DocsChecker.checkDocs(files, bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
