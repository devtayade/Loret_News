package com.redple.day2daynews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homeFragment extends Fragment {

    String api="2b11317f76864c60b5b42939e558acb2";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewofhome;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.home_fragment, null);

//after this we have to copy and paste for category news and also copy all above 22-26 and make changes.*videp me 1hr3min par cate ki settings mil jaigi.

         recyclerViewofhome= view.findViewById(R.id.recyclerviewofhome);
         modelClassArrayList=new ArrayList<>();
          recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
         adapter = new Adapter(getContext(),modelClassArrayList);
         recyclerViewofhome.setAdapter(adapter);

         findNews();
         return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
