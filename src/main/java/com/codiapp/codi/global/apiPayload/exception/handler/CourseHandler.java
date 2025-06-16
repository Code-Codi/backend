package com.codiapp.codi.global.apiPayload.exception.handler;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.exception.GeneralException;

public class CourseHandler extends GeneralException {
  public CourseHandler(BaseErrorCode errorCode) { super(errorCode); }
}