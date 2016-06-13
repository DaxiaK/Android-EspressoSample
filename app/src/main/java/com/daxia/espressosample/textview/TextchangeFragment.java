package com.daxia.espressosample.textview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daxia.espressosample.R;


public class TextchangeFragment extends Fragment {


    private TextView TV_import_str;
    private Button But_change;

    public TextchangeFragment() {
        // Required empty public constructor
    }

    public static TextchangeFragment newInstance() {
        TextchangeFragment fragment = new TextchangeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_textchange, container, false);
        TV_import_str = (TextView) rootView.findViewById(R.id.TV_import_str);
        But_change = (Button) rootView.findViewById(R.id.But_change);
        But_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TV_import_str.setText("HelloKitty");
            }
        });
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


}
