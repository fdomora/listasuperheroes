package com.example.listasuperheroes;

import android.os.Parcel;
import android.os.Parcelable;

public class Superheroe implements Parcelable {
    private String nombre;
    private String nomreal;
    private String bio;
    private float poder;

    public Superheroe(String nombre, String nomreal, String bio, float poder){
        this.nombre = nombre;
        this.nomreal = nomreal;
        this.bio = bio;
        this.poder = poder;
    }

    protected Superheroe(Parcel in) {
        nombre = in.readString();
        nomreal = in.readString();
        bio = in.readString();
        poder = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(nomreal);
        dest.writeString(bio);
        dest.writeFloat(poder);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Superheroe> CREATOR = new Creator<Superheroe>() {
        @Override
        public Superheroe createFromParcel(Parcel in) {
            return new Superheroe(in);
        }

        @Override
        public Superheroe[] newArray(int size) {
            return new Superheroe[size];
        }
    };

    public String getNombre(){
        return nombre;
    }
    public String getNomreal(){
        return nomreal;
    }
    public String getBio(){
        return bio;
    }
    public float getPoder(){
        return poder;
    }
}
