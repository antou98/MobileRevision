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

import com.example.revisionmobileexam.Data.DataBase;
import com.example.revisionmobileexam.Data.ParcelData;
import com.example.revisionmobileexam.Data.TableString;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private TextView textView;

    private  List<ParcelData> parcelDataList;

    private DataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dataBase = new DataBase(getContext());

        dataBase.insert(new TableString("test"));
        Log.i("table string","test");
        TableString tableString = dataBase.getByID(1);

        if (tableString!=null){
            Log.i("table string",tableString.toString());

            dataBase.insert(new TableString("test2"));

            dataBase.deleteByID(1);
        }

        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        if(getArguments()!=null && getArguments().getParcelableArray("parcel_data_list")!=null){
        Parcelable[] parcelDataArray = getArguments().getParcelableArray("parcel_data_list");

        // Convert the Parcelable[] back to List<ParcelData>
        List<ParcelData> parcelDataList = new ArrayList<>();
        if (parcelDataArray != null) {
            for (Parcelable parcelData : parcelDataArray) {
                if (parcelData instanceof ParcelData) {
                    parcelDataList.add((ParcelData) parcelData);
                }
            }
        }

        textView = (TextView) view.findViewById(R.id.fragment2TextModif);
        String st = parcelDataList.get(0).toString()+" "+parcelDataList.get(1).toString();
        textView.setText(st);}

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewTranslate);
        imageView.setImageResource(R.drawable.menu_icon);
        translateAnim(imageView);
        // Inflate the layout for this fragment
        return view;
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


    public static Fragment2 newInstance(List<ParcelData> parcelData) {

        //passe la référence
        Fragment2 fragment = new Fragment2();

        // Convert the List<ParcelData> to Parcelable[]
        Parcelable[] parcelDataArray = parcelData.toArray(new Parcelable[parcelData.size()]);

        Bundle args = new Bundle();

        args.putParcelableArray("parcel_data_list", parcelDataArray);

        fragment.setArguments(args);

        return fragment;
    }




    //De BASE /////////////////////////////////////
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Fragment2() {
        // Required empty public constructor
    }
    //De BASE /////////////////////////////////////
}