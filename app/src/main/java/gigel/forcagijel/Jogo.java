package gigel.forcagijel;

import android.util.Log;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogo {

    Jogador ja = new Jogador("A");
    Jogador jb = new Jogador("B");
    Jogador jc = new Jogador("C");
    Jogador jogadorMorto = new Jogador("M");

    private Reu reu = new Reu();
    private boolean vezJogador;
    private Tela tela;

    private Palavra p1;
    private Palavra p2;

    //TODO variaveis utilizadas para simular o servidor
    Jogador jogadorAtual = ja;


    public Jogo(Tela telaVinculacao){
        tela = telaVinculacao;

        p1 = new Palavra("abacate");
        p2 = new Palavra("elefante");

        tela.trocarJogador(ja);
    }

    public RespostaTela chutar(String chute){
        RespostaPalavra r1 = p1.verificarChute(chute);
        RespostaPalavra r2 = p2.verificarChute(chute);

        boolean acertou = false;
        boolean vivo = false;

        if(r1.acertou || r2.acertou){
            acertou = true;
        } else{
            reu.perderVida();
        }

        if(jogadorAtual.vivo && reu.vivo){
            vivo = true;
        }

        return new RespostaTela(r1.oculta, r2.oculta, acertou, vivo, reu.vidasPerdidas);
    }


    public RespostaTela tentar(String tentativa1, String tentativa2){

        RespostaPalavra r1 = p1.verificarTentativa(tentativa1);
        RespostaPalavra r2 = p2.verificarTentativa(tentativa2);

        boolean acertou = false;
        boolean vivo = false;

        if(r1.acertou || r2.acertou){
            acertou = true;
        } else{
            jogadorAtual.morrer();
        }

        if(jogadorAtual.vivo && reu.vivo){
            vivo = true;
        }

        return new RespostaTela(r1.oculta, r2.oculta, acertou, vivo, reu.vidasPerdidas);
    }


    public void proximoJogador(){
        //TODO fazer algoritmo de rand
        //TODO achar um jeito melhor de todos morrerem

        if(jogadorAtual.nome.equals("A")){
            jogadorAtual = jb;
        } else if(jogadorAtual.nome.equals("B")){
            jogadorAtual = jc;
        } else if(jogadorAtual.nome.equals("C")){
            jogadorAtual = ja;
        } else {
            jogadorAtual = jogadorMorto;
        }

        tela.trocarJogador(jogadorAtual);
    }


}
