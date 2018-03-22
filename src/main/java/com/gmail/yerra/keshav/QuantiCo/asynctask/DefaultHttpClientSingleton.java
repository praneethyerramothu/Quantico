package com.gmail.yerra.keshav.QuantiCo.asynctask;

import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by keshav on 15/2/2016.
 */
public class DefaultHttpClientSingleton {

    private static final DefaultHttpClient mDefaultHttpClientSingleton = new DefaultHttpClient();

    protected static final DefaultHttpClient instance() {
        return mDefaultHttpClientSingleton;
    }
}