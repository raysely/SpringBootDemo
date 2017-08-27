package org.lhh.demo.utils;

import org.lhh.demo.domain.Result;

/**
 * Created by raysely on 17/8/26.
 */
public class ResultUtil {

    public static Result success(final Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(final Integer code, final String msg) {
        final Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
