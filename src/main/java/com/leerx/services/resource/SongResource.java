package com.leerx.services.resource;

import com.leerx.services.api.LyricAPI;
import com.leerx.services.dto.Song;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Path("/")
public class SongResource {

    @Inject
    @RestClient
    LyricAPI lyricAPI;

    @GET
    @Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Song> query(@QueryParam("artist") String name, @QueryParam("trackName") String trackName) {
        return lyricAPI.search(Optional.ofNullable(name).orElse(trackName)).stream().distinct().collect(Collectors.toSet());
    }
    @GET
    @Path("/songs/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String lyrics(@PathParam("id") long id) {
        return lyricAPI.getSong(id).plainLyrics;
    }
}