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
    public int hashCode() {
        return Objects.hash(trackName.toLowerCase()+"-"+artistName.toLowerCase());
    }
}
