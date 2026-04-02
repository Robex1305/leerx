package com.leerx;

import com.leerx.entities.Request;
import com.leerx.services.RequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Objects;

@Slf4j
@Path("/requests")
public class RequestResource {

    @Inject
    RequestService service;

    @GET()
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String read(@PathParam("id") Long id) {
        return service.read(id).orElseThrow(() -> new NotFoundException("No request found for id " + id)).content;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Long persist(String content) {
        Request request = new Request();
        request.creationTime = Instant.now();
        request.url = "/requests";
        request.method = "POST";
        request.content = content;
        service.persist(request);
        return request.id;
    }

    @PUT()
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String update(@PathParam("id") Long id, String newContent) {
        Request request = service.read(id).orElseThrow(() -> new NotFoundException("No request found for id " + id));
        request.content = newContent;
        service.merge(request);
        return read(request.id);
    }

    @DELETE()
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }

}
