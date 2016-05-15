package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogo {

    Jogador jogador;
    private boolean vezJogador;
    private Tela tela;

    private Palavra p1;
    private Palavra p2;


    public Jogo(Tela telaVinculacao){
        tela = telaVinculacao;

        p1 = new Palavra("abacate");
        p2 = new Palavra("elefante");
    }

    public void setJogador(Jogador player){
        jogador = new Jogador(this);
    }

    public RespostaTela chutar(String chute){
        RespostaPalavra r1 = p1.verificarChute(chute);
        RespostaPalavra r2 = p2.verificarChute(chute);

        boolean acertou = false;

        if(r1.acertou || r2.acertou){
            acertou = true;
        }

        boolean vivo = true;

        return new RespostaTela(r1.oculta, r2.oculta, acertou, vivo);
    }























    public void perguntarVez(){
        if(true == false){
            //TODO dormir thread 1seg
            perguntarVez();
        }
        else {
            tela.avisarJogador();
        }
    }


}
