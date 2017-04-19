package JSonService;
import Controller.EtackemonManager;
import Model.Users;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 19/04/2017.
 */

@Path("/json")
@Singleton

public class JSonService {

        protected EtackemonManager etackemonManager;
        public JSonService() {

        }

        @GET
        @Path("/tenertodos")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Users> getList() {
            List<Users> a = new ArrayList<Users>();
            a= etackemonManager.getInstance().listUsers();//Falla al obtener la instancia
            return a;
        }
        @POST
        @Path("/addUser")
        @Produces(MediaType.APPLICATION_JSON)
        public void setUser(Users user){
            etackemonManager.getInstance().addUser(user);//Falla al obtener la instancia
        }
        @POST
        @Path("/updateUser")
        @Produces(MediaType.APPLICATION_JSON)
        public void modificarUser(String name, String newName, String mail){
            etackemonManager.getInstance().updateUser(name,newName,mail);//Falla al obtener la instancia
        }

}
