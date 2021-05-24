package com.tms.docs_organize.filler;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс, служащий для записи в файл сгенерированных номеров документов
 */
public class DocNumWriter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        try(FileWriter fw = new FileWriter(s.nextLine())) {
            for(int j = 0; j < 100; j++){
                fw.write(DocNumGenerator.generateDocNum(10+r.nextInt(10))+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
