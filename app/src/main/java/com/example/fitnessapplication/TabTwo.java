package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabTwo extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_two, container, false);

        //Buttons that open up their individual activities upon pressing
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        button = (Button) view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
        button = (Button) view.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }
        });

        return view;

    }
    public void openActivity2() {
        Intent intent = new Intent(getActivity(), Activity2.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(getActivity(), Activity3.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(getActivity(), Activity4.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(getActivity(), Activity5.class);
        startActivity(intent);
    }
}