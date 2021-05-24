package com.tms.docs_organize.checker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class SingleFileReader {
    public static HashSet<String> getDocNums(BufferedReader bf){
        HashSet<String> set = new HashSet<>();
        String num;
        while (true) {
            try {
                if ((num = bf.readLine())==null) break;
                set.add(num);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return set;
    }
}
