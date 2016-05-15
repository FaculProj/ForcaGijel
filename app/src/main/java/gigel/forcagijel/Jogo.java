package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Jogo {

    Jogador jogador = new Jogador(this);
    private Reu reu = new Reu();
    private boolean vezJogador;
    private Tela tela;


    private Palavra p1;
    private Palavra p2;


    public Jogo(Tela telaVinculacao){
        tela = telaVinculacao;

        p1 = new Palavra("abacate");
        p2 = new Palavra("elefante");
    }

    public RespostaTela chutar(String chute){
        RespostaPalavra r1 = p1.verificarChute(chute);
        RespostaPalavra r2 = p2.verificarChute(chute);

        boolean acertou = false;

        if(r1.acertou || r2.acertou){
            acertou = true;
        } else{
            reu.perderVida();
        }

        return new RespostaTela(r1.oculta, r2.oculta, acertou, reu.vivo, reu.vidasPerdidas);
    }


    public RespostaTela tentar(String tentativa1, String tentativa2){

        RespostaPalavra r1 = p1.verificarTentativa(tentativa1);
        RespostaPalavra r2 = p2.verificarTentativa(tentativa2);

        boolean acertou = false;

        if(r1.acertou || r2.acertou){
            acertou = true;
        } else{
            reu.perderVida();
        }

        return new RespostaTela(r1.oculta, r2.oculta, acertou, reu.vivo, reu.vidasPerdidas);
    }


}
