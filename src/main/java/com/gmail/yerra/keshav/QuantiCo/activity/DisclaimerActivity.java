package com.gmail.yerra.keshav.QuantiCo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.gmail.yerra.keshav.QuantiCo.Const;
import com.gmail.yerra.keshav.QuantiCo.R;
import com.gmail.yerra.keshav.QuantiCo.helper.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DisclaimerActivity extends BaseActivity {

    protected static final String TAG = DisclaimerActivity.class.getName();

    private CheckBox mCheckBoxAccept;

    private Button mButtonConfirm;
    private Button mButtonCancel;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        initComponents();
        initComponentsActions();
    }

    protected void initComponents() {
        initDrawerLayout();
        initActionBar();

        mCheckBoxAccept = (CheckBox) findViewById(R.id.checkbox_accept_disclaimer);
        mButtonConfirm = (Button) findViewById(R.id.button_confirm_disclaimer);
        mButtonCancel = (Button) findViewById(R.id.button_cancel_disclaimer);
    }

    protected void initComponentsActions(){
        mCheckBoxAccept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mButtonConfirm.setEnabled(isChecked);
                mButtonConfirm.setClickable(isChecked);
            }
        });

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCheckBoxAccept.isChecked()) {
                    return;
                }

                Util.savePreferenceValue(
                        mContext,
                        Const.KEY_PREFERENCE_DISCLAIMERR_ACCEPTED,
                        true);

                DateFormat df = new SimpleDateFormat(Const.DATE_FORMAT);
                Calendar now = new GregorianCalendar();
                Util.savePreferenceValue(
                        mContext,
                        Const.KEY_PREFERENCE_DATE_DISCLAIMERR_ACCEPTED,
                        df.format(now.getTime()));

                openNewActivity(MainActivity.class, false, true);
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.savePreferenceValue(
                        mContext,
                        Const.KEY_PREFERENCE_DISCLAIMERR_ACCEPTED,
                        false);

                mActivity.finish();
            }
        });
    }
}
