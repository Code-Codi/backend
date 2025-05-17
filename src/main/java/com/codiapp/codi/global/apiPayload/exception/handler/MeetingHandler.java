package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class MeetingHandler extends GeneralException {
    public MeetingHandler(BaseErrorCode errorCode) { super(errorCode); }
}
