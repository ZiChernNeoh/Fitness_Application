package com.example.fitnessapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabOne extends Fragment {
    private EditText height;
    private EditText weight;
    private TextView result;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_one, container, false);

        Button btn;
        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height =(EditText)getView().findViewById(R.id.height);
                weight =(EditText)getView().findViewById(R.id.weight);
                result =(TextView)getView().findViewById(R.id.result);
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null  &&  !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);
                    float bmical = weightValue / (heightValue * heightValue);
                    displayBMI(bmical);

                }
            }
            //Display the BMI and state the BMI categories
                public void displayBMI(float bmical) {
                    String bmiLabel = "";

                    //If BMI is lower than 18.5, display underweight
                    if (Float.compare(bmical, 18.5f) < 0) {
                        bmiLabel = getString(R.string.underweight);

                    //If BMI is between 18.5 and 24.9, display normal weight
                    } else if (Float.compare(bmical, 18.5f) >= 0  &&  Float.compare(bmical, 24.9f) <= 0) {
                        bmiLabel = getString(R.string.normal);

                    //If BMI is between 25 and 29.9, display overweight
                    } else if (Float.compare(bmical, 25) > 0  &&  Float.compare(bmical, 29.9f) <= 0) {
                        bmiLabel = getString(R.string.overweight);

                    //If BMI is over 30, display very overweight
                    } else {
                        bmiLabel = getString(R.string.very_overweight);
                    }

                    bmiLabel = bmical + "\n" + bmiLabel;
                    result.setText(bmiLabel);



            }
        });



        return view;
    }
}
