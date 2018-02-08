package com.saltedfish.app;

import android.os.Bundle;
import android.support.design.widget.SaltedFishBottomSheetDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private SparseArray<String> mTabs;
    private SparseArray<String> mPagerContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();

    }

    private void initDatas(){
        mTabs = new SparseArray<>();
        for (int i = 0; i < 10 ; i++) {
            mTabs.put(i,String.format("tab%s",i));
        }

        mPagerContents = new SparseArray<>();
        for (int i = 0; i < 30; i++) {
            mPagerContents.put(i,String.format("content%s",i));
        }


        Button button = findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null == mChooseAdDialog){
                    createChooseAdDialog();
                }else{
                    mChooseAdDialog.show();
                }
            }
        });

    }


    private SaltedFishBottomSheetDialog mChooseAdDialog;
    private void createChooseAdDialog(){
        mChooseAdDialog = new SaltedFishBottomSheetDialog(this);
        View rootView = View.inflate(this,R.layout.saltedfish_bottom_sheet,null);

        TabLayout tab =  rootView.findViewById(R.id.tab);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewPager viewPager = rootView.findViewById(R.id.pager);

        for (int i = 0 , count = mTabs.size(); i <count ; i++) {
            tab.addTab(tab.newTab().setText(mTabs.get(i)));//add tab
        }
        viewPager.setAdapter(new SaltedFishPagerAdapter(this,mTabs,mPagerContents));
        tab.setupWithViewPager(viewPager);
        mChooseAdDialog.setupWithViewPager(viewPager);
        mChooseAdDialog.setContentView(rootView);
        mChooseAdDialog.show();
    }
}
