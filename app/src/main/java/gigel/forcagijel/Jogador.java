package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogador {

    private String status;
    private Jogo jogo;

    //FUTURE: Quantidades jogadas, letras ok, level, bla bla bla

    public Jogador(Jogo nj){
        status = "";
        jogo = nj;
    }

    public Palavra CriarPalavra(){
        //TODO Pedir palavra user
        Palavra x = new Palavra("HAHA");
        return x;
    }
    public void Chutar(String chute){
        boolean res = jogo.api.chute(chute);
        if(res == false){

        }
    }

    public void Tentar(String tent){
        jogo.api.tentativa(tent);
    }
}
