package com.codiapp.codi.global.apiPayload.code.status;

import com.codiapp.codi.global.apiPayload.code.BaseErrorCode;
import com.codiapp.codi.global.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    SCHEDULE_NOT_FOUND(HttpStatus.BAD_REQUEST, "SCHEDULE4001", "존재하지 않는 스케줄입니다."),
    TEAM_NOT_FOUND(HttpStatus.BAD_REQUEST, "TEAM4001", "존재하지 않는 팀입니다."),

    // 회의록 관련 에러
    MEETING_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEETING4001", "회의록이 없습니다."),

    //과제 관련 에러
    TASK_NOT_FOUND(HttpStatus.BAD_REQUEST, "TASK4001", "과제가 없습니다."),
    TASK_DETAIL_NOT_FOUND(HttpStatus.BAD_REQUEST,"TASKD4001", "해당 TaskDetail을 찾을 수 없습니다."),
	  //프로젝트 관련 에러
	  PROJECT_NOT_FOUND(HttpStatus.BAD_REQUEST, "PROJECT4001", "존재하지 않는 프로젝트입니다."),
	  PROJECT_UPDATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "PROJECT5001", "프로젝트 수정 중 오류가 발생했습니다."),
	  PROJECT_NAME_REQUIRED(HttpStatus.BAD_REQUEST, "PROJECT4002", "프로젝트 이름은 필수입니다."),
	  PROJECT_TEAM_REQUIRED(HttpStatus.BAD_REQUEST, "PROJECT4003", "팀 ID는 필수입니다."),
	  ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
