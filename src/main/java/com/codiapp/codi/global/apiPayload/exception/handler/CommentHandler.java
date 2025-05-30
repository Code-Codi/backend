package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class CommentHandler extends GeneralException {
     public CommentHandler (BaseErrorCode errorCode) { super(errorCode); }
}
