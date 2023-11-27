package com.example.revisionmobileexam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.revisionmobileexam.Data.ParcelData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private  ParcelData data;

    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_fragment1, container, false);

        if ( getArguments()!=null && getArguments().getParcelable("parcel_data")!=null){
        data = getArguments().getParcelable("parcel_data");
        textView = (TextView)  view.findViewById(R.id.fragment1TextModif);
        String st = data.toString();
        Log.i("data",st.toString());
        textView.setText(st);
            }

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewId);

        translateAnim(imageView);




        // Inflate the layout for this fragment
        return view;
    }

    public static Fragment1 newInstance(ParcelData parcelData) {

        Fragment1 fragment = new Fragment1();

        Bundle args = new Bundle();

        args.putParcelable("parcel_data", parcelData);

        fragment.setArguments(args);

        return fragment;
    }




    //DE BASE ////////////////////////////////////////////////////
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void translateAnim(ImageView imageView){
        Animation transAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        transAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.setOnClickListener(v->{
            imageView.startAnimation(transAnimation);
        });


    }

    //DE BASE ////////////////////////////////////////////////////
}