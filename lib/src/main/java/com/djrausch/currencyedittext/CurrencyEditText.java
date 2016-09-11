package com.djrausch.currencyedittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyEditText extends EditText {
    private String mSymbol;
    private CurrencyTextWatcher mCurrencyTextWatcher;
    private String mCurrentValue = "0";
    private double mCurrentDoubleValue = 0.00;

    public CurrencyEditText(Context context) {
        super(context);
        init();
    }

    public CurrencyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurrencyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CurrencyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public double getValue() {
        return mCurrentDoubleValue / 100;
    }

    private void init() {
        initializeSymbol();
        setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mCurrencyTextWatcher = new CurrencyTextWatcher(this);
        addTextChangedListener(mCurrencyTextWatcher);
    }

    private void initializeSymbol() {
        mSymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
    }

    private class CurrencyTextWatcher implements TextWatcher {
        private TextView mTextView;

        public CurrencyTextWatcher(TextView textView) {
            mTextView = textView;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        //http://stackoverflow.com/questions/27027070/android-edittext-addtextchangelistener-currency-format
        @Override
        public void afterTextChanged(Editable editable) {
            if (!editable.toString().equals(mCurrentValue)) {
                mTextView.removeTextChangedListener(mCurrencyTextWatcher);

                String removedSymbol = editable.toString().replaceAll("[" + mSymbol + ",.\\\\s]", "");

                try {
                    mCurrentDoubleValue = Double.parseDouble(removedSymbol);
                } catch (NumberFormatException e) {
                    mCurrentDoubleValue = 0.00;
                }

                mCurrentValue = NumberFormat.getCurrencyInstance().format(mCurrentDoubleValue / 100);
                mTextView.setText("");
                mTextView.append(mCurrentValue);
                mTextView.addTextChangedListener(mCurrencyTextWatcher);

            }

        }
    }
}
