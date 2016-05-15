package gigel.forcagijel;

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
            p += " _".trim();
        }
        palavraDisplay = p.trim();
    }

    public String verificarChute(String chute){
        //TODO fazer code: Veriricar palavra e atualizar palavra display
        return palavraDisplay;
    }

    public String verificarTentativa(String tentativa){
        //TODO fazer code: Veriricar palavra e atualizar palavra display
        return palavraDisplay;
    }
}
