package com.webonise.simtestcasesample;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webonise on 28/12/17.
 */

public class ListActivityTest extends ActivityInstrumentationTestCase2<ListActivity> {

    private Solo solo;

    public ListActivityTest() {
        super(ListActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testViews() throws Exception {
        solo.assertCurrentActivity("ListActivity", ListActivity.class);
        solo.getView(R.id.rvList);
    }

    public void testList() throws Exception {
        String name = ((TextView)solo.getView(R.id.tvName)).getText().toString();
        assertEquals("harry",name);
        Activity currentActivity = getActivity();
        ArrayList<ListDataModel> list = ((ListActivity)currentActivity).createList();
        //failure
        assertEquals(4,((ListActivity)currentActivity).getListDataAdapter().getItemCount());
        //pass
        assertEquals(list.size(),((ListActivity)currentActivity).getListDataAdapter().getItemCount());

    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
