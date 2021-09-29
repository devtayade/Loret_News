package com.redple.day2daynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, mscience, mhealth, mtechnology, mentertainment, msports, mbuisness;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api="2b11317f76864c60b5b42939e558acb2";

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome=findViewById(R.id.HomeButton);
        mscience=findViewById(R.id.Science);
        mhealth=findViewById(R.id.Health);
        mtechnology=findViewById(R.id.Tech);
        mentertainment=findViewById(R.id.Entertainment);
        msports=findViewById(R.id.Sports);

        ViewPager viewPager = findViewById(R.id.frangmentContainer);
        tabLayout= findViewById(R.id.include);

        pagerAdapter = new pagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}