package View;

import Controller.EtakemonManagerImpl;
import Model.Etakemon;
import Model.Users;

/**
 * Created by Gurkeerat Singh on 18/04/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        EtakemonManagerImpl Controll = EtakemonManagerImpl.getInstance();
        Users u = new Users("Gurki", "gurki@email");
        Etakemon p=new Etakemon ("eetac");
        Controll.addUser(u);
        Controll.addEtakemon(u,p);

    }
}
