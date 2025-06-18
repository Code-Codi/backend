package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class TaskGuideHandler extends GeneralException {
    public TaskGuideHandler(BaseErrorCode errorCode) { super(errorCode);}
}
