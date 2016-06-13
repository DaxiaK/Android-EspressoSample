package com.daxia.espressosample.listview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daxia.espressosample.R;

import java.util.ArrayList;
import java.util.List;


public class SuperheroListFragment extends Fragment {


    private ListView Listview_Gallery;
    private List<SuperheroListEntity> galleryList;
    private SuperheroListAdapter webAdapter;

    public static SuperheroListFragment newInstance() {
        SuperheroListFragment fragment = new SuperheroListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryList = new ArrayList<SuperheroListEntity>();
        setData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_superherolist, container, false);
        Listview_Gallery = (ListView) rootView.findViewById(R.id.Listview_Gallery);
        webAdapter = new SuperheroListAdapter(getContext(), galleryList);
        Listview_Gallery.setAdapter(webAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void setData() {
        SuperheroListEntity entity1 = new SuperheroListEntity("鎂鍋隊長", "www.Captain.MaPot.com");
        galleryList.add(entity1);
        SuperheroListEntity entity2 = new SuperheroListEntity("低督郎", "www.didolan.tw");
        galleryList.add(entity2);
        SuperheroListEntity entity3 = new SuperheroListEntity("那年被追沈嘉儀", "www.who.is.your.girlfriend.com");
        galleryList.add(entity3);
    }

}
