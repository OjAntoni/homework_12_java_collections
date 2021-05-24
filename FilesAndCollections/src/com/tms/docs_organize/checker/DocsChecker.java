package com.tms.docs_organize.checker;

import com.tms.docs_organize.checker_exceptions.DocException;
import com.tms.docs_organize.checker_exceptions.LengthException;

import java.io.*;
import java.util.*;

public class DocsChecker {

    public static void checkDocs(ArrayList<BufferedReader> files, BufferedWriter fileTo){

        Set<String> docsNum = new HashSet<>();

        for (BufferedReader item:
             files) {
            docsNum.addAll(SingleFileReader.getDocNums(item));
        }

        Map<String, String> finalDocs = new HashMap<>();
        for (String num : docsNum){
            try {
                NumChecker.check(num);
                finalDocs.put(num, "Everithing is all right");
            } catch (DocException | LengthException e) {
                finalDocs.put(num, e.getMessage());
            }
        }
        for (Map.Entry<String,String> item : finalDocs.entrySet()) {
            try {
                fileTo.write(item.getKey()+" "+item.getValue()+"\n");
               // System.out.println(item.getKey()+" "+item.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
