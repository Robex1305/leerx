package com.leerx.services.api;

import com.leerx.services.dto.Song;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;


@RegisterRestClient(configKey = "lyrics")
public interface LyricAPI {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Song getSong(@PathParam("id") long id);

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    Set<Song> search(@QueryParam("q") String keyword);
}
