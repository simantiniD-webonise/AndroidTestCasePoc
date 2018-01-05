package com.webonise.simtestcasesample;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by webonise on 28/12/17.
 */

public class FormFillingFragment extends Fragment {
    private Calendar mCalendar;
    TextInputEditText tiedob;
    TextInputEditText tieFirstName;
    TextInputEditText tieMiddleName;
    TextInputEditText tieLastName;
    Button btnSubmit;
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_form_filling, container, false);
        initView();
        return mView;

    }

    private void initView() {
        tieFirstName = (TextInputEditText) mView.findViewById(R.id.tieFirstName);
        tieMiddleName = (TextInputEditText) mView.findViewById(R.id.tieMiddleName);
        tieLastName = (TextInputEditText) mView.findViewById(R.id.tieLastName);

        tiedob = mView.findViewById(R.id.tiedob);
        tiedob.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    showCalendar();
                }
                return false;
            }
        });
        btnSubmit = (Button) mView.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Submit button clicked", Toast.LENGTH_SHORT).show();
                if (validateInputText()) {
                    Intent intent = new Intent(getActivity(), ListActivity.class);
                    getActivity().startActivity(intent);
                }

            }
        });
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, month);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            tiedob.setText(new SimpleDateFormat("MMM dd, yyyy").format(mCalendar.getTime()));
        }
    };

    private void showCalendar() {

        mCalendar = Calendar.getInstance();

        InputMethodManager inputManager = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        Calendar calender = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), dateSetListener,
                calender.get(Calendar.YEAR), calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH));
        if (datePickerDialog != null) {

            datePickerDialog.show();
        }
    }

    public boolean validateInputText() {
        if (TextUtils.isEmpty(tieFirstName.getText())) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tieFirstName.setError("Please enter firstname");
                }
            });

            return false;
        }
        if (TextUtils.isEmpty(tieMiddleName.getText())) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tieMiddleName.setError("Please enter middle name");
                }
            });

            return false;
        }
        if (TextUtils.isEmpty(tieLastName.getText())) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tieLastName.setError("Please enter last name");
                }
            });

            return false;
        }
        if (TextUtils.isEmpty(tiedob.getText())) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tieLastName.setError("Please enter date");
                }
            });

            return false;
        }
        return true;
    }

}
