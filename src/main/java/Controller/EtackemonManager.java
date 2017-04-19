package Controller;

import Model.Etakemon;
import Model.Users;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public interface EtackemonManager {

    int addUser(Users u);
    int addEtakemon(Users u, Etakemon p);
    void updateUser(String name,String newName, String newMail);
   // void updateUser(Users u,String newName);
    String infoUser(String nombre);
    List<Etakemon> returnEtakemon(Users u);
    List<String> listUsers();
}
