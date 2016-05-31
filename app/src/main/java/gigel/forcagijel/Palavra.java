package gigel.forcagijel;

import android.util.Log;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Created by gabri on 01/05/2016.
 */
public class Palavra {

    //exemplo: ANÃO
    private String palavra;

    //exemplo: _ _ _ _
    //exemplo: A _ Ã _
    String palavraDisplay;

    //exemplo: ANAO
    String palavraNormal;

    boolean palavraCompleta = false;

    public Palavra(String novaPalavra){
        palavra = novaPalavra.trim();
        String p = "";
        for(int i = 0; i < novaPalavra.length(); i++){
            if(palavra.charAt(i) == "-".charAt(0)){
                p += " -";
            } else {
                p += " _";
            }
        }
        palavraDisplay = p.trim();
        palavraNormal = normalizar(palavra);
    }

    public static String normalizar(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public RespostaPalavra verificarChute(String chute){
        if(! palavraCompleta) {
            boolean acertou = false;
            String p = palavraDisplay;

            chute = normalizar(chute);
            if (!chute.equals("")) {
                for (int i = 0; i < palavraNormal.length(); i++) {
                    if (palavraNormal.toLowerCase().charAt(i) == chute.toLowerCase().charAt(0)) {
                        acertou = true;
                        p = (p.substring(0, (i * 2)) + palavra.toUpperCase().charAt(i) + p.substring((i * 2) + 1, p.length()));
                    }
                }
            }

            palavraDisplay = p;

            palavraCompleta = true;
            for (int i = 0; i < palavraDisplay.length(); i++) {
                if (palavraDisplay.charAt(i) == "_".charAt(0)) {
                    palavraCompleta = false;
                }
            }

            if (palavraCompleta) {
                palavraDisplay = palavra;
            }

            RespostaPalavra r = new RespostaPalavra(palavraDisplay, acertou);

            return r;
        } else {
            RespostaPalavra r = new RespostaPalavra(palavraDisplay, true);

            return r;
        }
    }

    public RespostaPalavra verificarTentativa(String tentativa){
        RespostaPalavra r;

        tentativa = normalizar(tentativa);

        if(tentativa.toLowerCase().trim().equals(palavraNormal.toLowerCase()) ){
            palavraDisplay = palavra;
            palavraCompleta = true;
            r = new RespostaPalavra(palavra, true);
        } else {
            r = new RespostaPalavra(palavraDisplay, false);
        }

        return r;
    }
}
