package com.tms.docs_organize.checker_exceptions;

import com.tms.docs_organize.checker.DocsConstants;

public class LengthException extends Exception{
    public LengthException(){
        super("Document number length isn't equal to " + DocsConstants.LENGTH);
    }
}
