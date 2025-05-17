package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class TaskHandler extends GeneralException {
    public TaskHandler(BaseErrorCode errorCode) { super(errorCode); }
}
