package com.example.secondhw.data.remote;

import com.example.secondhw.data.models.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {

    @GET("films")
    Call<List<Films>> getAllFilms();

}
