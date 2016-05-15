package gigel.forcagijel;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogo {

    //Server Thing
    //private List<Jogador> jogadores;

    Jogador jogador;
    private Palavra primeiraPalavra;
    private Palavra segundaPalavra;
    private Reu reu;
    private boolean vezJogador;
    API api;
    private Tela tela;


    public Jogo(Tela telaVinculacao){
        tela = telaVinculacao;
    }

    public void setJogador(Jogador player){
        //Server => Acrescentar Jogador ao List
        jogador = player;
    }

    public void perguntarVez(){
        if(api.checarVez() == false){
            //TODO dormir thread 1seg
            perguntarVez();
        }
        else {
            tela.avisarJogador();
        }
    }


}
