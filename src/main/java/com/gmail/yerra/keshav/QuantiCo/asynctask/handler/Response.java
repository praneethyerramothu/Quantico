package com.gmail.yerra.keshav.QuantiCo.asynctask.handler;

/**
 * Created by keshav on 15/2/2016.
 */
public interface Response {
    void onSuccess(final String string);

    void onFail();
}