package gigel.forcagijel;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by gabri on 01/05/2016.
 */
public class Palavra {

    //exemplo: ABACATE
    private String palavra;

    //exemplo: A_A_A_E
    String palavraDisplay;

    boolean palavraCompleta = true;

    public Palavra(String novaPalavra){
        palavra = novaPalavra.trim();
        String p = "";
        for(int i = 0; i < novaPalavra.length(); i++){
            p += " _";
        }
        palavraDisplay = p.trim();
    }

    public RespostaPalavra verificarChute(String chute){
        boolean acertou = false;
        String p = palavraDisplay;

        if(! chute.equals("")) {
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.toLowerCase().charAt(i) == chute.toLowerCase().charAt(0)) {
                    acertou = true;
                    p = (p.substring(0, (i * 2)) + chute + p.substring((i * 2) + 1, p.length()));
                }
            }
        }

        palavraDisplay = p;

        palavraCompleta = true;
        for(int i = 0; i < palavraDisplay.length(); i++){
            if(palavraDisplay.charAt(i) == "_".charAt(0)){
                palavraCompleta = false;
            }
        }

        if(palavraCompleta){
            palavraDisplay = palavra;
        }

        RespostaPalavra r = new RespostaPalavra(palavraDisplay, acertou);

        return r;
    }

    public RespostaPalavra verificarTentativa(String tentativa){
        RespostaPalavra r;

        if(tentativa.toLowerCase().trim().equals(palavra.toLowerCase())){
            r = new RespostaPalavra(palavra, true);
        } else {
            r = new RespostaPalavra("PERDEU!", false);
        }

        return r;
    }
}
