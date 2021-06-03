package com.geng.selectphoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT;

public class PhotoSelectActivity extends AppCompatActivity {

    private SlidingTabLayout mTab;
    private ViewPager mVp;
    private String[] mTitlesArrays = {"资源", "相册"};
    private MyPagerAdapter mPagerAdapter;
    private ArrayList<Fragment> mFragmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_select);
        initView();
    }

    private void initView() {
        mTab = findViewById(R.id.tab);
        mVp = findViewById(R.id.vp);

        SourceFragment sourceFragment = new SourceFragment();
        PhotoFragment photoFragment = new PhotoFragment();
        mFragmentsList = new ArrayList<>();
        mFragmentsList.add(sourceFragment);
        mFragmentsList.add(photoFragment);

        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragmentsList);
        mVp.setAdapter(mPagerAdapter);
        mTab.setViewPager(mVp, mTitlesArrays);//tab和ViewPager进行关联
    }
}