package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class ExampleHandler extends GeneralException {
    public ExampleHandler(BaseErrorCode errorCode) { super(errorCode); }
}