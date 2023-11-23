package umc.study.week8.apiPayload.exception.handler;

import umc.study.week8.apiPayload.code.BaseErrorCode;
import umc.study.week8.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}