package org.diiage.clementh.poc.hugon.swapi.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oleur on 22/12/2014.
 * Vehicle model represents a single transport craft that does not have hyperdrive capability.
 */
public class Vehicle implements Serializable {
    public String name;
    public String model;

    @SerializedName("vehicle_class")
    public String vehicleClass;

    public String manufacturer;

    @SerializedName("cost_in_credits")
    public String costInCredits;

    public String length;
    public String crew;
    public String passengers;

    @SerializedName("max_atmosphering_speed")
    public String maxAtmospheringSpeed;

    @SerializedName("cargo_capacity")
    public String cargoCapacity;

    public String consumables;
    public String created;
    public String edited;
    public String url;

    @SerializedName("pilots")
    public ArrayList<String> pilotsUrls;

    @SerializedName("films")
    public ArrayList<String> filmsUrls;

    public String getUrl() {
        return url;
    }

    public String getEdited() {
        return edited;
    }

    public String getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public String getCrew() {
        return crew;
    }

    public String getLength() {
        return length;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public String getModel() {
        return model;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public ArrayList<String> getFilmsUrls() {
        return filmsUrls;
    }

    public ArrayList<String> getPilotsUrls() {
        return pilotsUrls;
    }
}
