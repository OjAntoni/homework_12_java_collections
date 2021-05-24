package com.tms.docs_organize.console_data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleData {
    public static ArrayList<BufferedReader> getConsoleData() {
        Scanner s = new Scanner(System.in);
        String fileName;
        FileReader fr;
        ArrayList<BufferedReader> files = new ArrayList<>();

        while(!(fileName=s.nextLine()).equals("0")){
            try {
                fr = new FileReader(fileName);
                files.add(new BufferedReader(fr));
            } catch (FileNotFoundException ignored) {
            }
        }

        return files;
    }
}
