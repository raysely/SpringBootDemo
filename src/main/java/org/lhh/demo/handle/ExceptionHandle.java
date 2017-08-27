package org.lhh.demo.handle;

import org.lhh.demo.domain.Result;
import org.lhh.demo.exception.MemberException;
import org.lhh.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by raysely on 17/8/26.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof MemberException) {
            final MemberException memberException = (MemberException) e;
            return ResultUtil.error(memberException.getCode(), memberException.getMessage());
        } else {
            logger.error("[系统异常]{}", e);
            return ResultUtil.error(-1, e.getMessage());
        }
    }
}
