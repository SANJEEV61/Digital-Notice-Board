package com.example.brceapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.brceapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.cs,"Computer Science","The Department of Computer Science and Engineering, since its inception in 2008 came with an initial intake of 60 students in UG programme and enhanced its intake to 120 in the year 2012."));
        list.add(new BranchModel(R.drawable.is,"Information Science","The department has evolved over the years to portray its excellent academic performance.The department has dedicated and qualified faculties who are responsible to prepare students technically, morally and ethically."));
        list.add(new BranchModel(R.drawable.ec,"Electronics And Communication","The Department of Electronics and Communication Engineering was established in the year 2008 with an initial intake of 60 students in the UG programme and enhanced its intake to 120."));
        list.add(new BranchModel(R.drawable.mechanic,"Mechanical","The Department of Mechanical Engineering is having a well equipped laboratories and is blessed with highly experienced, qualified and committed faculty members in Machine Design, Thermal Power and Manufacturing Science with Ph.D’s. "));
        list.add(new BranchModel(R.drawable.worker,"Civil","The Department of Civil Engineering was established in the year 2008 with an intake of 60 and over a short period of time due to remarkable efforts of the Management, Faculty and active students an increase intake from 60 to 120 was achieved"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.view_pager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/brindavan-college-app-69bba.appspot.com/o/SliderImages%2Fslider1.png?alt=media&token=6e3ee88b-fc7d-4535-9909-169a090ac340")
                .into(imageView);


        return view;
    }
}