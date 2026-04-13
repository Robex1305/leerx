package com.leerx.services.resource;

import com.leerx.services.api.LyricAPI;
import com.leerx.services.dto.Song;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Comparator;
import java.util.List;
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
    public List<Song> query(@QueryParam("q") String criteria) {
        Set<Song> results = lyricAPI.search(criteria);
        return results.stream().sorted(Comparator.comparing(s -> s.trackName)).collect(Collectors.toList());
    }
    @GET
    @Path("/songs/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String lyrics(@PathParam("id") long id) {
        return lyricAPI.getSong(id).plainLyrics;
    }
}