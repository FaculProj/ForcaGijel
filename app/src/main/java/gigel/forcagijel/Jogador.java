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
    }

    public void morrer(){
        vivo = false;
    }

    public Palavra CriarPalavra(String pf){
        Palavra x = new Palavra(pf);
        return x;
    }
}
