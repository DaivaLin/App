package com.example.sinni.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class choose_wordvoc extends AppCompatActivity {

    private TabLayout  mTabs;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_wordvoc);


        mTabs = (TabLayout) findViewById(R.id.pager_tabs);
        mTabs.addTab(mTabs.newTab().setText("Word"));
        mTabs.addTab(mTabs.newTab().setText("Voc"));
    //    mTabs.addTab(mTabs.newTab().setText("Contact"));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
    }

    class MyPagerAdapter extends PagerAdapter {
        private int pageCount = 2;
        @Override
        public int getCount() {
            return pageCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "MyPage " + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getLayoutInflater().inflate(R.layout.activity_learn_voc, container, false);
            container.addView(view);
            ///TextView title = (TextView) view.findViewById(R.id.textView_item_title);
           // title.setText("" + (position + 1));
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}