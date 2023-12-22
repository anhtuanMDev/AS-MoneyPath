package com.example.fandroidexpensemanagements.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fandroidexpensemanagements.Adapters.ViewPager_Adapter;
import com.example.fandroidexpensemanagements.R;

import java.util.ArrayList;

public class Fragment_Chart extends Fragment {
    View mon,tue,wed,thur,fri,sat,sun,baseLine;
    ViewPager2 mPager;
    TextView txtDailyBudget,txtDayButton,txtWeekButton,txtMonthButton;
    RecyclerView mRecyclerView;
    ViewPager_Adapter pager_adapter;
    float length;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__chart, container, false);
        baseLine = view.findViewById(R.id.baselineMonday);
        mon = view.findViewById(R.id.lineMonday);
        tue = view.findViewById(R.id.lineTuesday);
        wed = view.findViewById(R.id.lineWednesday);
        thur = view.findViewById(R.id.lineThursday);
        fri = view.findViewById(R.id.lineFriday);
        sat = view.findViewById(R.id.lineSaturday);
        sun = view.findViewById(R.id.lineSunday);
        mPager = view.findViewById(R.id.chart_ViewPager);
        txtDailyBudget = view.findViewById(R.id.chart_DailyBudget);
        txtDayButton = view.findViewById(R.id.chart_DayButton);
        txtWeekButton = view.findViewById(R.id.chart_WeekButton);
        txtMonthButton = view.findViewById(R.id.chart_MonthButton);
        mRecyclerView = view.findViewById(R.id.chart_RecyclerView);

        ArrayList<Fragment> manage = new ArrayList<>();
        manage.add(new Fragment_Monday());
        manage.add(new Fragment_Tuesday());
        manage.add(new Fragment_Wednesday());
        manage.add(new Fragment_Thursday());
        manage.add(new Fragment_Friday());
        manage.add(new Fragment_Saturday());
        manage.add(new Fragment_Sunday());

        pager_adapter = new ViewPager_Adapter(getActivity(),manage);
        mPager.setAdapter(pager_adapter);
//        View baseLine's height is 275
        return view;
    }

    public void setPercentage(View line,int percent){
        ViewGroup.LayoutParams params = line.getLayoutParams();
        params.height = percent*275;
        line.setLayoutParams(params);
    }
}