package com.retrofit.ranad_000.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    private FrameLayout FragmentContainer;
    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentContainer = (FrameLayout) findViewById(R.id.fragmentFrame);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                openFragment(text);
            }
        });
    }


    public void openFragment(String text) {
        Fragment1 fragment = Fragment1.newInstance(text);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.exit_to_left, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragmentFrame, fragment, "Blank Fragment").commit();
    }

    @Override
    public void onFragmentInteraction(String sendBack) {
        editText.setText(sendBack);
        onBackPressed();
    }
}
