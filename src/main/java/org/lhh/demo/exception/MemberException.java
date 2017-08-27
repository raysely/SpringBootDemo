package org.lhh.demo.exception;

import org.lhh.demo.enums.ResultEnum;

/**
 * Created by raysely on 17/8/26.
 *
 *  注意，这里必须继承RuntimeException，而不是Exception，因为spring只对RuntimeException进行回滚。对Exception是不进行回滚。
 */
public class MemberException extends  RuntimeException{

    private Integer code;

    public MemberException(final ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
