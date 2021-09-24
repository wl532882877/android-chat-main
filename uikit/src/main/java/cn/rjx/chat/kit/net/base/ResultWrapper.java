/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.net.base;

/**
 * Created by imndx on 2017/12/15.
 */

public class ResultWrapper<T> extends StatusResult {
    T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
