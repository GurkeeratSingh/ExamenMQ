package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurkeerat Singh on 17/04/2017.
 */
public class Users {
    private String name;
    private String mail;
    private ArrayList<Etakemon> etakemons =new ArrayList<Etakemon>();
    public Users(){}

    public Users(String name, String mail){

        this.name=name;
        this.mail=mail;
    }

    public void addEtakemon(Etakemon p){
        etakemons.add(p);
    }
    public List<Etakemon> returnEtakemon(){ return this.etakemons;}

    public int numEtakemon(){return etakemons.size();}
    public String getName(){return this.name;}
    public String getMail(){
        return this.mail;
    }
    public void setMail(String mail){this.mail=mail;}
    public void setName(String name){this.name=name;}
}
