package com.hhs.dailypractice;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWebView;
    private Button btnUrlConnection;
    private Button btnOkHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    private void initViews() {
        btnWebView = findViewById(R.id.btn_WebView);
        btnWebView.setOnClickListener(this);
        btnUrlConnection = findViewById(R.id.btn_urlConnection);
        btnUrlConnection.setOnClickListener(this);
        btnOkHttp = findViewById(R.id.btn_okhttp);
        btnOkHttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_WebView:
                replaceFragment(new WebViewFragment());
                break;
            case R.id.btn_urlConnection:
                replaceFragment(new HttpUrlConnectionFramgnet());
                break;


            default:
                break;

        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
