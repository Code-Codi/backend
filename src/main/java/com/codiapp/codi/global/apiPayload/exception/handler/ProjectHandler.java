package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class ProjectHandler extends GeneralException {
    public ProjectHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}