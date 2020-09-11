package com.hfad.bitsandpizzas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

public class PastaFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pasta));
        setListAdapter(adapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasta, container, false);
    }
}