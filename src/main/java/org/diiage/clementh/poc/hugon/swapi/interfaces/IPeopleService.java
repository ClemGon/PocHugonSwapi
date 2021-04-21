package org.diiage.clementh.poc.hugon.swapi.interfaces;

import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IPeopleService {
    //Get a people by id
    @GET("people/{id}/")
    Call<People> people(@Path("id") String id);

    //Get all people
    @GET("people/")
    Call<SWModelList<People>> listPeoples();
}
