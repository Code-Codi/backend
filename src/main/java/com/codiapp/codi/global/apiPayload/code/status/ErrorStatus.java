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
    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST, "MEETING4002", "잘못된 날짜 형식입니다."),


    //로그인 관련 에러
    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "USER4011", "유저를 찾을 수 없습니다."),
    PASSWORD_NOT_MATCHED(HttpStatus.UNAUTHORIZED, "USER4012", "비밀번호가 일치하지 않습니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "USER4091", "이미 가입된 이메일입니다."),

    //과제 관련 에러
    TASK_NOT_FOUND(HttpStatus.BAD_REQUEST, "TASK4001", "과제가 없습니다."),
    TASK_DETAIL_NOT_FOUND(HttpStatus.BAD_REQUEST,"TASKD4001", "해당 TaskDetail을 찾을 수 없습니다."),

    //과제 제공 관련 에러
    TaskGuide_NOT_FOUND(HttpStatus.BAD_REQUEST, "TGUIDE001", "과제제공이 없습니다."),
    TaskGuide_DETAIL_NOT_FOUND(HttpStatus.BAD_REQUEST, "TGUIDE4002", "과제제공의 세부사항이 없습니다."),

    //프로젝트 관련 에러
	PROJECT_NOT_FOUND(HttpStatus.BAD_REQUEST, "PROJECT4001", "존재하지 않는 프로젝트입니다."),
	PROJECT_UPDATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "PROJECT5001", "프로젝트 수정 중 오류가 발생했습니다."),
	PROJECT_NAME_REQUIRED(HttpStatus.BAD_REQUEST, "PROJECT4002", "프로젝트 이름은 필수입니다."),
	PROJECT_TEAM_REQUIRED(HttpStatus.BAD_REQUEST, "PROJECT4003", "팀 ID는 필수입니다."),

    // 게시글 관련 에러
    POST_NOT_FOUND(HttpStatus.BAD_REQUEST, "POST4001", "존재하지 않는 게시글입니다."),
    POST_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "POST5001", "게시글 생성 중 오류가 발생했습니다."),
    POST_UPDATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "POST5002", "게시글 수정 중 오류가 발생했습니다."),
    POST_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "POST5003", "게시글 삭제 중 오류가 발생했습니다."),

    // 댓글 관련 에러
    COMMENT_NOT_FOUND(HttpStatus.BAD_REQUEST, "COMMENT4001", "존재하지 않는 댓글입니다."),
    COMMENT_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "COMMENT5001", "댓글 생성 중 오류가 발생했습니다."),
    COMMENT_UPDATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "COMMENT5002", "댓글 수정 중 오류가 발생했습니다."),
    COMMENT_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "COMMENT5003", "댓글 삭제 중 오류가 발생했습니다."),

    // 수업 관련 에러
    COURSE_NOT_FOUND(HttpStatus.BAD_REQUEST, "COURSE4001", "존재하지 않는 강의입니다."),
    USER_ALREADY_IN_COURSE(HttpStatus.BAD_REQUEST, "COURSE4002", "사용자가 해당 수업의 팀에 이미 포함되어 있습니다."),
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
