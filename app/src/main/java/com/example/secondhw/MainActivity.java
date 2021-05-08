package com.example.secondhw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.secondhw.data.adapters.MainAdapter;
import com.example.secondhw.data.models.Films;
import com.example.secondhw.data.remote.RetrofitBuilder;
import com.example.secondhw.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainAdapter.onItemClickLiesten{

    private int position;
    private RecyclerView recyclerView;
    private List<Films> list=new ArrayList<>();
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new MainAdapter(this);

        init();

        RetrofitBuilder.getInstance().getAllFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                list.addAll(response.body());
                adapter.addList(list);
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void clicker(int position) {
        Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra("Description",list.get(position).getDescription());
        intent.putExtra("Director",list.get(position).getDirector());
        intent.putExtra("Producer",list.get(position).getProducer());
        startActivity(intent);
    }
}