package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class TeamHandler extends GeneralException {
    public TeamHandler(BaseErrorCode errorCode) { super(errorCode); }
}