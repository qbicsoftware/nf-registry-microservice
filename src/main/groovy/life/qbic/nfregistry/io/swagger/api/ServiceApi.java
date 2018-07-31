package io.swagger.api;

import io.swagger.model.ERRORUNKNOWN;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/service")
@Api(description = "the service API")
public class ServiceApi {

    @GET
    @Path("/info")
    @Produces({ "application/json" })
    @ApiOperation(value = "Query general service information", notes = "", response = ERRORUNKNOWN.class, tags={ "service",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ERRORUNKNOWN.class) })
    public Response serviceInfoGet() {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/status")
    @Produces({ "application/json" })
    @ApiOperation(value = "Query general service information", notes = "", response = ERRORUNKNOWN.class, tags={ "service" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ERRORUNKNOWN.class) })
    public Response serviceStatusGet() {
        return Response.ok().entity("magic!").build();
    }
}
