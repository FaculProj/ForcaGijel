package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogador {

    String nome;
    private String status;

    public Jogador(String name){
        status = "vivo";
        nome = name;
    }

    public Palavra CriarPalavra(){
        //TODO Pedir palavra user
        Palavra x = new Palavra("HAHA");
        return x;
    }
}
