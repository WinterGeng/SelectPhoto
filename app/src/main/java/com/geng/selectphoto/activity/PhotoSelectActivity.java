package com.geng.selectphoto.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;
import com.geng.selectphoto.adapter.MyPagerAdapter;
import com.geng.selectphoto.R;
import com.geng.selectphoto.fragment.PhotoFragment;
import com.geng.selectphoto.fragment.SourceFragment;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import java.util.ArrayList;

public class PhotoSelectActivity extends AppCompatActivity {

    private SlidingTabLayout mTab;
    private ViewPager mVp;
    private String[] mTitlesArrays = {"资源", "相册"};
    private MyPagerAdapter mPagerAdapter;
    private ArrayList<Fragment> mFragmentsList;
    private ImageView mSelectPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_select);
        initView();
    }

    private void initView() {
        mTab = findViewById(R.id.tab);
        mVp = findViewById(R.id.vp);
        mSelectPhoto = findViewById(R.id.select_photo);

        SourceFragment sourceFragment = new SourceFragment();
        PhotoFragment photoFragment = new PhotoFragment();
        mFragmentsList = new ArrayList<>();
        mFragmentsList.add(sourceFragment);
        mFragmentsList.add(photoFragment);

        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragmentsList);
        mVp.setAdapter(mPagerAdapter);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    mSelectPhoto.setVisibility(View.VISIBLE);
                } else {
                    mSelectPhoto.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTab.setViewPager(mVp, mTitlesArrays);//tab和ViewPager进行关联
        mSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2021/6/3 打开相册
                PictureSelector.create(PhotoSelectActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
    }
}