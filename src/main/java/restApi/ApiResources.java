package restApi;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
public class ApiResources {
	
	@GET
	public String test() {
		return "Medicine API for DoseWise app";
	}

	@GET
	@Path("/data-without-response")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MedicineName> getconnect(){
		mydata datamy = new mydata();
		return datamy.dbdata();
	}
	
	@GET
	@Path("/dataRequest")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse(){
		mydata databaseManager = new mydata();
		List<MedicineName> names = databaseManager.dbdata();
		if(!names.isEmpty()) {
			return Response.ok(databaseManager.dbdata()).build();
		}
		return Response.serverError().entity("Can't featch from DB").build();
	}
}
