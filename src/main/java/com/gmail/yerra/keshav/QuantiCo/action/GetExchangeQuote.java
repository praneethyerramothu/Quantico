package com.gmail.yerra.keshav.QuantiCo.action;

import android.content.Context;

import com.gmail.yerra.keshav.QuantiCo.Const;
import com.gmail.yerra.keshav.QuantiCo.asynctask.RequestAsyncTask;
import com.gmail.yerra.keshav.QuantiCo.asynctask.handler.Response;
import com.gmail.yerra.keshav.QuantiCo.data.Conversion;

/**
 * Created by keshav on 26/2/2016.
 */
public class GetExchangeQuote {

    private Context mContext;
    private Response mHandler;

    public GetExchangeQuote(final Context context, final Response handler) {
        if (context == null) throw new NullPointerException("Context cannot be null");
        mContext = context;

        if (handler == null) throw new NullPointerException("Handler cannot be null");
        mHandler = handler;
    }

    public final void execute(final Conversion conversion) {
        String url = String.format(
                Const.URL_CONVERSION,
                conversion.getCurrencyFrom(),
                conversion.getCurrencyTo());

        new RequestAsyncTask(mHandler).execute(String.format("%s%s", Const.URL_BASE, url));
    }
}
