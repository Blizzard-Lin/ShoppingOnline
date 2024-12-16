package com.cy.store.controller;

import com.cy.store.service.ex.AddressCountLimitException;
import com.cy.store.utils.JsonResult;

public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;

    /**
     * 1.当出现了value内的异常之一，就会将下方的方法作为新的控制器方法进行执行
     *   因此该方法的返回值也同时是返回给前端的页面
     * 2.此外还自动将异常对象传递到此方法的参数列表中，这里使用Throwable e来接收
     **/

    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof AddressCountLimitException){
            result.setState(4003); //表示地址数量已超限制

        }
        //返回异常处理结果
        return result;
    }
}
