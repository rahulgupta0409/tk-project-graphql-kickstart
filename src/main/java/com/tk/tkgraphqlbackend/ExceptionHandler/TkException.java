package com.tk.tkgraphqlbackend.ExceptionHandler;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class TkException extends RuntimeException implements GraphQLError {

    public TkException(String message){
        super(message);
    }

    public TkException(String message, Throwable throwable){
        super(message, throwable);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
