package org.diiage.clementh.poc.hugon.swapi.interfaces;

import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;
import org.diiage.clementh.poc.hugon.swapi.models.Starship;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IStarShipService {
        //Get a starships by id
        @GET("starships/{id}/")
        Call<Starship> starship(@Path("id") int id);

        //Get all starships
        @GET("starships/")
        Call<SWModelList<Starship>> listStarship();

}
