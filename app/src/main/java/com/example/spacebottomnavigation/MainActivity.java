package com.example.spacebottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    SpaceNavigationView spaceNavigationView;
    //Initialize for Fragment-------------------
    FrameLayout frameLayout;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_add));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_search));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_favorite));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_setting));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddFragment()).commit();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
                spaceNavigationView.setCentreButtonSelectable(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
//                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                Fragment fragment = null;
                switch (itemIndex)
                {
                    case 0:
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 1:
                        fragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Fragment fragment = null;
                switch (itemIndex)
                {
                    case 0:
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 1:
                        fragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                        fragment = new AddFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                }
            }
        });
    }
}