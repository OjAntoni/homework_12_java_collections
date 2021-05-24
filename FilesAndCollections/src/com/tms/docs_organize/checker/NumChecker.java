package com.tms.docs_organize.checker;

import com.tms.docs_organize.checker_exceptions.*;

public class NumChecker {
    /**
     * Статический метод для проверки номера документа на условия
     * Использует интерфейс констант com.tms.docs_organize.checker.DocsConstants
     * @param docNum номер документа для проверки
     * @throws DocException если номер не наченается с DOCNUM
     * @throws LengthException если длинна номера не равна LENGTH
     */
    public static void check (String docNum)
            throws DocException, LengthException{
        if(docNum.length() != DocsConstants.LENGTH)
            throw new LengthException();
        if(!(docNum.startsWith(DocsConstants.DOCNUM)) && !(docNum.startsWith(DocsConstants.KONTRACT)))
            throw new DocException();

    }
}
