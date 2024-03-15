package com.mgrtech.openshift;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    private Set<Post> lastPosts = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PostResource() {}

    @GET
    public Response list() {
        return Response.ok(lastPosts).build();
    }

    @POST
    public Response add(Post post) {
        lastPosts.add(post);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Post post) {
        return Response.ok().build();
    }
}
