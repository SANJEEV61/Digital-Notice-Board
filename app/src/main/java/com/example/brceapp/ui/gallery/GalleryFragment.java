package com.example.brceapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brceapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

   RecyclerView convoRecycler,seminarRecycler,clgfestRecycler,eventsRecycler;
   GalleryAdapter adapter;

   DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);
        convoRecycler = view.findViewById(R.id.convoRecycler);
        seminarRecycler = view.findViewById(R.id.seminarRecycler);
        clgfestRecycler = view.findViewById(R.id.clgfestRecycler);
        eventsRecycler = view.findViewById(R.id.eventsRecycler);


        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getConvoImage();
        getSeminarImage();
        getClgFestImage();
        getEventsImage();


        return view;
    }

    private void getEventsImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                eventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
                eventsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }




    private void getClgFestImage() {
        reference.child("College Fest").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                clgfestRecycler .setLayoutManager(new GridLayoutManager(getContext(),2));
                clgfestRecycler .setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getSeminarImage() {
        reference.child("Seminar").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
               seminarRecycler .setLayoutManager(new GridLayoutManager(getContext(),2));
               seminarRecycler .setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}