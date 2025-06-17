package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class BriefHandler extends GeneralException {
    public BriefHandler(BaseErrorCode errorCode) { super(errorCode);}
}
