package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogador {

    String nome;
    String status;
    boolean vivo;


    public Jogador(String name){
        status = "vivo";
        nome = name;
        vivo = true;
    }

    public void morrer(){
        vivo = false;
    }

}
