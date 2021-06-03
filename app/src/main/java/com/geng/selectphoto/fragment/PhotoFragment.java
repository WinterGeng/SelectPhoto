package com.geng.selectphoto.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geng.selectphoto.R;
import com.geng.selectphoto.utils.GlideEngine;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

public class PhotoFragment extends Fragment {
    private View view;
    private ImageView mTakePhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photo, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTakePhoto = view.findViewById(R.id.take_photo);
        mTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2021/6/3 拍照
                PictureSelector.create(getActivity())
                        .openCamera(PictureMimeType.ofImage())
                        .imageEngine(GlideEngine.createGlideEngine())
                        .forResult(PictureConfig.REQUEST_CAMERA);
            }
        });
    }
}
