package com.example.fandroidexpensemanagements.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fandroidexpensemanagements.Main.AddMultyBudgets;
import com.example.fandroidexpensemanagements.Main.AddMultyExpenses;
import com.example.fandroidexpensemanagements.Main.OrganizeExpenses;
import com.example.fandroidexpensemanagements.R;

public class Fragment_User extends Fragment {
    ImageView menu,avatar;
    TextView txtSaving,txtBudget,txtExpense;
    Button btnSeeExpense;
    RelativeLayout addBudget,addExpense;
    DrawerLayout sideMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__user, container, false);
        menu = view.findViewById(R.id.user_menu);
        avatar = view.findViewById(R.id.user_avatar);
        txtSaving = view.findViewById(R.id.user_saving);
        txtBudget = view.findViewById(R.id.user_dailyBudget);
        txtExpense = view.findViewById(R.id.user_expenses);
        btnSeeExpense = view.findViewById(R.id.user_seeExpense);
        addBudget = view.findViewById(R.id.userLayout_addBudget);
        addExpense = view.findViewById(R.id.userLayout_addExpenses);
        sideMenu = getActivity().findViewById(R.id.navigate_drawer);


        menu.setOnClickListener(view1 -> {
            sideMenu.openDrawer(GravityCompat.START);
        });
        addExpense.setOnClickListener(view1->{
            changeActivity(new AddMultyExpenses());
        });
        addBudget.setOnClickListener(view1->{
            changeActivity(new AddMultyBudgets());
        });
        btnSeeExpense.setOnClickListener(view1->{
            changeActivity(new OrganizeExpenses());
        });



        return view;
    }

    public void changeActivity(AppCompatActivity activity){
        Intent intent = new Intent(getActivity(),activity.getClass());
        startActivity(intent);
    }
}