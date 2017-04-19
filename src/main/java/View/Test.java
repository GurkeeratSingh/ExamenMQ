package View;

import Controller.EtackemonManager;
import Controller.EtakemonManagerImpl;
import Model.Etakemon;
import Model.Users;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 19/04/2017.
 */
public class Test extends TestCase {
    EtakemonManagerImpl etakemonManager = new EtakemonManagerImpl();
    Etakemon e=new Etakemon();
    Users u=new Users();
    List<Etakemon> h=new ArrayList<Etakemon>();
    List<Users> listUsers = new ArrayList<Users>();

    @Before
    public void setUp() throws Exception {
        // start the server
        u.setName("Masmi");
        u.setMail("masmi@mail");
        e.setName("Masmimon");
        h.add(e);
        listUsers.add(u);

    }
    @After
    public void tearDown() throws Exception {
        listUsers.clear();
        h.clear();
    }

    @org.junit.Test
    public void añadirUser(){
        int numUser = 1;
        int esperado=etakemonManager.addUser(u);

        Assert.assertEquals(numUser,esperado);
    }

    @org.junit.Test
    public void añadirEtack(){
        int numEtac = 1;
        int esperado = etakemonManager.addEtakemon(u,e);

        Assert.assertEquals(numEtac,esperado);
    }




    @org.junit.Test
    public void infoUser(){

        String nombre = u.getName();
        String mail=u.getMail();
        String res = "El usuario " + nombre + " tiene el e-Mail: "+mail;



        Assert.assertEquals(res,etakemonManager.infoUser(nombre));
    }

    @org.junit.Test
    public void returnEta(){


        Assert.assertEquals(h,etakemonManager.returnEtakemon(u));
    }

    @org.junit.Test
    public void listUser(){

        Assert.assertEquals(listUsers,etakemonManager.listUsers());
    }


}
