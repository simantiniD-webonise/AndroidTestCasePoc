package com.webonise.simtestcasesample;

import android.support.design.widget.TextInputEditText;
import android.support.test.annotation.UiThreadTest;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * Created by webonise on 28/12/17.
 */

public class FormFillingActivityTest extends ActivityInstrumentationTestCase2<FormFillingActivity> {

    private Solo solo;

    public FormFillingActivityTest() {
        super(FormFillingActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testViews() throws Exception {
       /*solo.searchText(getActivity().getString(R.string.first_name));
       solo.enterText(0,"Sim");*/
        solo.assertCurrentActivity("FormFillingActivity", FormFillingActivity.class);
        solo.waitForFragmentById(R.id.fragmentLayout);
        solo.getView(R.id.tilFirstName);
        solo.getView(R.id.tilMiddleName);
        solo.getView(R.id.tilLastName);
        solo.getView(R.id.btnSubmit);
        solo.clickOnButton(getActivity().getString(R.string.submit_btn));
        solo.assertCurrentActivity("FormFillingActivity", ListActivity.class);
        solo.goBack();
    }

    public void testvalidateInput() throws Exception {
        solo.enterText(0, "Sim");
        solo.enterText(1, "Sim");
        solo.enterText(2, "Sim");
        solo.enterText(3, "02/01/2017");
        FragmentActivity currentActivity = getActivity();
        final Fragment currentFragment = currentActivity.getSupportFragmentManager().findFragmentById(R.id.fragmentLayout);

        if (((FormFillingFragment) currentFragment).validateInputText()) {

            solo.clickOnButton(getActivity().getString(R.string.submit_btn));
        }


    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
