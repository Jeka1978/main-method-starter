package com.naya.mainmethodstarter.aop;

import lombok.*;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class BodyWrapper {
    private Object result;

    @java.beans.ConstructorProperties({"result"})
    public BodyWrapper(Object result) {
        this.result = result;
    }

    public BodyWrapper() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof BodyWrapper;
    }

}
