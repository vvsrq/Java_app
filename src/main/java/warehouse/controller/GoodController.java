package warehouse.controller;

import warehouse.model.Good;
import warehouse.service.GoodService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/goods")
public class GoodController {

    private GoodService goodService = new GoodService();

    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveGood(Good good) {
        try {
            goodService.saveGood(good);
            return Response.status(201).build(); // 201 Created
        } catch (SQLException e) {
            return Response.status(500).entity("Error saving good: " + e.getMessage()).build(); // 500 Internal Server Error
        }
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoods() {
        try {
            List<Good> goods = goodService.getGoods();
            return Response.ok(goods).build(); // 200 OK
        } catch (SQLException e) {
            return Response.status(500).entity("Error retrieving goods: " + e.getMessage()).build();
        }
    }
}
