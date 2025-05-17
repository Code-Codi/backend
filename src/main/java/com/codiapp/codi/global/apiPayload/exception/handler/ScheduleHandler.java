package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class ScheduleHandler extends GeneralException {
    public ScheduleHandler(BaseErrorCode errorCode) { super(errorCode); }
}