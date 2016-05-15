package gigel.forcagijel;

import android.util.Log;

/**
 * Created by gabri on 01/05/2016.
 */
public class Palavra {

    //exemplo: ABACATE
    private String palavra;

    //exemplo: A_A_A_E
    String palavraDisplay;

    public Palavra(String novaPalavra){
        palavra = novaPalavra;
        String p = "";
        for(int i = 0; i < novaPalavra.length(); i++){
            p += " _";
        }
        palavraDisplay = p.trim();
    }

    public Resposta verificarChute(String chute){
        //TODO fazer code: Veriricar palavra e atualizar palavra display

        boolean acertou = false;
        String p = palavraDisplay;

        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == chute.charAt(0)){
                p = (p.substring(0, (i*2)) + chute + p.substring((i*2)+1, p.length()));
            }
        }
        palavraDisplay = p;

        Resposta r = new Resposta(palavraDisplay, acertou);

        Log.d("LOG", r.oculta);

        return r;
    }

    public String verificarTentativa(String tentativa){
        //TODO fazer code: Veriricar palavra e atualizar palavra display
        return palavra;
    }
}
