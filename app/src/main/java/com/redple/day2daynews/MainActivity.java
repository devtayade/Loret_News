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
    TabItem mhome, mcatogory , mfav;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api="2b11317f76864c60b5b42939e558acb2";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome=findViewById(R.id.HomeButton);
        mcatogory=findViewById(R.id.catButton);
        mfav=findViewById(R.id.favButton);

        ViewPager viewPager = findViewById(R.id.frangmentContainer);
        tabLayout= findViewById(R.id.include);

        pagerAdapter = new pagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2){
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