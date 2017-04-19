package Controller;

import Model.Etakemon;
import Model.Users;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public class EtakemonManagerImpl implements EtackemonManager{
    private static EtakemonManagerImpl instance;
    private HashMap<String, Users> usersHashMap;
    final static Logger logger = Logger.getLogger(EtakemonManagerImpl.class);


    public EtakemonManagerImpl(){

        usersHashMap=new HashMap<String,Users>();
        logger.info("se crea hashmap usuarios");

    }
    public  static EtakemonManagerImpl getInstance(){
        if (instance==null) instance=new EtakemonManagerImpl();
        logger.info("se llama a la funcion getInstance");
        return instance;
    }


    public int addUser(Users u) {
        String nombre = u.getName();
        usersHashMap.put(nombre,u);
        logger.info("se añade usuario: "+nombre);
        return usersHashMap.size();
    }

    public int addEtakemon(Users u, Etakemon p) {
        usersHashMap.get(u.getName()).addEtakemon(p);
        /*Users f = usersHashMap.get(u.getName());
        f.addEtakemon(p);*/
        /*u.addEtakemon(p);*/
        int numEtacemons=u.numEtakemon();
        logger.info("se añade etakemon: "+ p.getName()+" al usuario: "+u.getName());
        return numEtacemons;
    }

    public void updateUser(String name, String newName, String newMail) {

        Users u=usersHashMap.get(name);
        String mail=u.getMail();
        u.setName(newName);
        u.setMail(newMail);
        usersHashMap.remove(name);
        usersHashMap.put(newName,u);
        logger.info("nombre del usuario: "+name+" cambiado a: "+newName);
        logger.info("mail del usuario: "+mail+" cambiado a: "+newMail);
    }


    public String infoUser(String nombre) {
        Users user = usersHashMap.get(nombre);
        if (user!=null) {

            String mail = usersHashMap.get(nombre).getMail();
            String sol = "El usuario " + nombre + " tiene el e-Mail: " + mail;
            logger.info("Se ha dado la información del usuario: " + nombre);
            return sol;
        }
        else {
            logger.error("No se ha encontrado usuario");
            return null;
        }

    }

    public List<Etakemon> returnEtakemon(Users u) {

        List<Etakemon> myListEtakemons = usersHashMap.get(u.getName()).returnEtakemon();
        if (myListEtakemons==null){
            logger.error("se pide lista de etakemons, está vacía y se devuelve vacía");
            return null;
        }
        logger.info("Se devuelve la lista de etakemons del usuario: "+u.getName());
        return myListEtakemons;//usersHashMap.get(u.getName()) devuelve un usuario(clase User)
    }
    public List<String> listUsers(){
        List<String> us=new ArrayList<String>();
        int i=0;
        for (String key: usersHashMap.keySet()) {
            String usu= String.valueOf(usersHashMap.get(key));
            us.add(usu);
            i++;
        }
        if (us.size()!=0){
            Collections.sort(us);
            logger.info("Se devuelven "+i+ " usuarios");
            return us;
        }
        else{
            logger.error("se pide lista de usuarios, está vacía y se devuelve null");
            return null;
        }

    }
}
