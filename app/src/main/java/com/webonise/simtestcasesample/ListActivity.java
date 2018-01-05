package com.webonise.simtestcasesample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends FragmentActivity {

    private RecyclerView rvList;
    private ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        initView();

    }

    private void initView() {
        listDataAdapter = new ListDataAdapter();
        ArrayList<ListDataModel> list = createList();
        setList(list);
        rvList = (RecyclerView)findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(listDataAdapter);

    }

    public ArrayList<ListDataModel> createList() {
        ArrayList<ListDataModel> list = new ArrayList<>();
        ListDataModel listDataModel1 = new ListDataModel("harry","privet drive");
        ListDataModel listDataModel2 = new ListDataModel("hermoine","muggle home");
        ListDataModel listDataModel3 = new ListDataModel("ron","the burrow");
        ListDataModel listDataModel4 = new ListDataModel("sirius","azkaban");
        ListDataModel listDataModel5 = new ListDataModel("dumbledore","hogwarts");
        ListDataModel listDataModel6 = new ListDataModel("snape","hogwarts");
        ListDataModel listDataModel7 = new ListDataModel("voldemort","hogwarts");

        list.add(listDataModel1);
        list.add(listDataModel2);
        list.add(listDataModel3);
        list.add(listDataModel4);
        list.add(listDataModel5);
        list.add(listDataModel6);
        list.add(listDataModel7);
        return list;
    }

    public void setList(ArrayList<ListDataModel> list) {

        listDataAdapter.setList(list);
        //listDataAdapter.notifyDataSetChanged();
    }

    public ListDataAdapter getListDataAdapter() {
        return listDataAdapter;
    }

}
