package com.gmail.yerra.keshav.QuantiCo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gmail.yerra.keshav.QuantiCo.R;
import com.gmail.yerra.keshav.QuantiCo.data.Currencies;
import com.gmail.yerra.keshav.QuantiCo.data.Currency;


/**
 * Created by keshav on 15/2/2016
 */
public class CurrencyAdapter extends ArrayAdapter {

    private Context mContext;
    private Currencies mCurrencies;
    private String mLabel;

    public CurrencyAdapter(final Context context,
                           final Currencies currencies, final String label) {
        super(context, R.layout.spinner_currency_popup, currencies.getAll());

        if (context == null) throw new NullPointerException("Context cannot be null");
        mContext = context;

        if (currencies == null) throw new NullPointerException("Currencies cannot be null");
        mCurrencies = currencies;

        mLabel = label;
    }

    @Override
    public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
        Currency currency = mCurrencies.getCurrency(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View row = inflater.inflate(R.layout.spinner_currency_popup, parent, false);

        ((TextView) row.findViewById(R.id.text_view_currency_code))
                .setText(currency.getCurrencyCode());

        ((TextView) row.findViewById(R.id.text_view_currency_description))
                .setText(currency.getDescription());

        ((TextView) row.findViewById(R.id.text_view_currency_symbol))
                .setText(currency.getSymbol());

        return row;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        Currency currency = mCurrencies.getCurrency(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View row = inflater.inflate(R.layout.spinner_currency, parent, false);

        ((TextView) row.findViewById(R.id.text_view_label_currency_code)).setText(mLabel);

        ((TextView) row.findViewById(R.id.text_view_currency_code))
                .setText( currency.getCurrencyCode());

        return row;
    }
}
