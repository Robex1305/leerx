package com.leerx.services.dto;

import java.util.Objects;

public class Song {
   public long id;
   public String trackName;
   public String artistName;
   public String albumName;
   public String plainLyrics;
   public short duration;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Song that){
            boolean sameArtist = this.artistName.equalsIgnoreCase(that.artistName);
            boolean sameName = this.trackName.equalsIgnoreCase(that.trackName);
            return sameArtist && sameName;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.artistName.toLowerCase() + this.trackName.toLowerCase());
    }}


