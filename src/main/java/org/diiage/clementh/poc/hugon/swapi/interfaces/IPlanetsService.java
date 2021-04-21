package org.diiage.clementh.poc.hugon.swapi.interfaces;

import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPlanetsService {
        //Get a planet by id
        @GET("planets/{id}/")
        Call<Planet> planet(@Path("id") String id);

        //Get all planets
        @GET("planets/")
        Call<SWModelList<Planet>> listPlanets();

}
