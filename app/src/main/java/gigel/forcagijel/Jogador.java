package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogador {

    private String status;
    private Jogo jogo;

    public Jogador(Jogo nj){
        status = "";
        jogo = nj;
    }

    public Palavra CriarPalavra(){
        //TODO Pedir palavra user
        Palavra x = new Palavra("HAHA");
        return x;
    }
}
