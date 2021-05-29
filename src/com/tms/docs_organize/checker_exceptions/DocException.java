package com.tms.docs_organize.checker_exceptions;

import com.tms.docs_organize.checker.DocsConstants;

public class DocException extends Exception{
    public DocException(){
        super("Not found doc expected symbols: " +
                DocsConstants.DOCNUM + " or "+
                DocsConstants.KONTRACT);
    }
}
