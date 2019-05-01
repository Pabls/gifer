package com.ar4i.gifer.presentation.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ar4i.gifer.R;

public class MainActivity extends AppCompatActivity {

    //==========================================start ui============================================
    FrameLayout flContainer;
    //-------------------------------------------end ui---------------------------------------------


    //==========================================start lifecycle=====================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.flContainer = findViewById(R.id.fl_container);

        if (savedInstanceState == null) {
            showFragment(MainFragment.newInstance());
        }
    }
    //-------------------------------------------end lifecycle--------------------------------------


    //==========================================start private methods===============================
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }
    //-------------------------------------------end private methods--------------------------------

}
