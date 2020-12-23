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

public class TabThree extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_three, container, false);

        //Buttons that open their individual activities upon pressing
        button = (Button) view.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
        button = (Button) view.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity7();
            }
        });
        button = (Button) view.findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity8();
            }
        });
        button = (Button) view.findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity9();
            }
        });
        button = (Button) view.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity10();
            }
        });
        button = (Button) view.findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity11();
            }
        });
        button = (Button) view.findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity12();
            }
        });
        button = (Button) view.findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity13();
            }
        });
        return view;

    }
    public void openActivity6() {
        Intent intent = new Intent(getActivity(), Activity6.class);
        startActivity(intent);
    }
    public void openActivity7() {
        Intent intent = new Intent(getActivity(), Activity7.class);
        startActivity(intent);
    }
    public void openActivity8() {
        Intent intent = new Intent(getActivity(), Activity8.class);
        startActivity(intent);
    }
    public void openActivity9() {
        Intent intent = new Intent(getActivity(), Activity9.class);
        startActivity(intent);
    }
    public void openActivity10() {
        Intent intent = new Intent(getActivity(), Activity10.class);
        startActivity(intent);
    }
    public void openActivity11() {
        Intent intent = new Intent(getActivity(), Activity11.class);
        startActivity(intent);
    }
    public void openActivity12() {
        Intent intent = new Intent(getActivity(), Activity12.class);
        startActivity(intent);
    }
    public void openActivity13() {
        Intent intent = new Intent(getActivity(), Activity13.class);
        startActivity(intent);
    }
}

