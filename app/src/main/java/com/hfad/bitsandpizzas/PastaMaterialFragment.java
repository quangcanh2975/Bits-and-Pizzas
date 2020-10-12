package com.hfad.bitsandpizzas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PastaMaterialFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta_material, container, false);

        String[] names = new String[Pasta.pastas.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Pasta.pastas[i].getName();
        }

        int[] imageIds = new int[Pasta.pastas.length];
        for (int i = 0; i < imageIds.length; i++) {
            imageIds[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(names, imageIds);
        pastaRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        pastaRecycler.setLayoutManager(layoutManager);
        return pastaRecycler;
    }
}