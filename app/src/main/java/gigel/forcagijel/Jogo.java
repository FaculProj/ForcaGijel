package gigel.forcagijel;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogo {

    Jogador ja = new Jogador("A");
    Jogador jb = new Jogador("B");
    Jogador jc = new Jogador("C");
    Jogador jogadorMorto = new Jogador("M");
    Palavra p1;
    Palavra p2;

    ArrayList<String> chutes = new ArrayList<String>();



    private Reu reu = new Reu();
    private Tela tela;

    //TODO variaveis utilizadas para simular o servidor
    Jogador jogadorAtual = ja;


    public Jogo(Tela telaVinculacao){
        tela = telaVinculacao;
        tela.trocarJogador(ja);
    }

    public RespostaTela chutar(String chute){

        boolean acertou = false;
        boolean vivo = false;


        if(chutes.contains(chute)){
            reu.perderVida();
            if (jogadorAtual.vivo && reu.vivo) {
                vivo = true;
            } else{
                tela.mostrarMensagem("Jogador " + jogadorAtual.nome + " MORREU!!");
            }
            return new RespostaTela(p1.palavraDisplay, p2.palavraDisplay, false, vivo, reu.vidasPerdidas);
        } else {

            chutes.add(chute);
            RespostaPalavra r1 = p1.verificarChute(chute);
            RespostaPalavra r2 = p2.verificarChute(chute);

            if (r1.acertou || r2.acertou) {
                acertou = true;
            } else {
                reu.perderVida();
            }

            if (jogadorAtual.vivo && reu.vivo) {
                vivo = true;
            } else{
                tela.mostrarMensagem("Jogador " + jogadorAtual.nome + " MORREU!!");
            }

            if (p1.palavraCompleta && p2.palavraCompleta) {
                tela.mostrarMensagem("Jogador "+jogadorAtual.nome+" Ganhou!!");
            }

            return new RespostaTela(r1.oculta, r2.oculta, acertou, vivo, reu.vidasPerdidas);
        }
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

        if(! acertou){
            tela.mostrarMensagem("Jogador " + jogadorAtual.nome + " MORREU!!");
        } else if(p1.palavraCompleta && p2.palavraCompleta){
            tela.mostrarMensagem("Jogador " + jogadorAtual.nome + " GANHOU!!");
        }

        return new RespostaTela(r1.oculta, r2.oculta, acertou, vivo, reu.vidasPerdidas);
    }


    public void setP1(Palavra pq){
        p1 = pq;

    }

    public void setP2(Palavra pq){
        p2 = pq;
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

        if(! jogadorAtual.vivo) {
            proximoJogador();
        }

        tela.trocarJogador(jogadorAtual);
    }


}
