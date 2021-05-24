package com.tms.docs_organize.filler;

import java.util.Random;

/**
 * Класс со статическим методом, служащим для возвращения строки
 * из латинских букв верхнего регистра и цифр длинной len
 */
public class DocNumGenerator {
        public static String generateDocNum(int len) {
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            return sb.toString();
        }
}
