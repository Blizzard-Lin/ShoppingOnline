package com.cy.store.service.ex;
/**
 * 表示用户收货地址条目数超出限制的异常
 */
public class AddressCountLimitException extends SecurityException{
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String s) {
        super(s);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

}
