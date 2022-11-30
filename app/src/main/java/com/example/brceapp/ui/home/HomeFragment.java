package com.example.brceapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.brceapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider1.png?alt=media&token=6e3ee88b-fc7d-4535-9909-169a090ac340", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider2.jpg?alt=media&token=59788362-15c0-48c7-8d81-a6b3c663cbd6", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider3.jpg?alt=media&token=e72dba69-2c71-4719-b7a2-2299637019c0", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider4.jpg?alt=media&token=6e35c242-6377-4da1-9130-1d604e4874d9", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider5.png?alt=media&token=add9b0f5-b1ea-4147-9f90-bb138b39b076", ScaleTypes.CENTER_CROP));


        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

       return view;

    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Brindavan Group of Institutions");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

}
