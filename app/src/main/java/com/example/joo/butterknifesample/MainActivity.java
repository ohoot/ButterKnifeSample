package com.example.joo.butterknifesample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //@BindView(R.id.btn1) Button btn1;
    //@BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn_on_off) Button btnOnOff;
    @BindView(R.id.text_center) TextView textCenter;
    @BindString(R.string.greeting) String greeting;
    @BindViews({R.id.btn1, R.id.btn2, R.id.btn3}) List<Button> btns;
    public boolean isOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isOn = true;

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, greeting, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.btn1)
    public void btn1OnClick(View view) {
        view.setBackgroundColor(Color.RED);
    }

    @OnClick(R.id.btn2)
    public void btn2OnClick(Button button) {
        button.setText("Test");
    }

    @OnClick(R.id.btn_on_off)
    public void btnOnOffClick() {
        ButterKnife.apply(btns, TOGGLE, isOn);
        isOn = !isOn;
    }

    static final ButterKnife.Setter<View, Boolean> TOGGLE = new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean isOn, int index) {
            view.setEnabled(!isOn);
        }
    };
}
