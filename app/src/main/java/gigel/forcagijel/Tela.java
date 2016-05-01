package gigel.forcagijel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tela extends AppCompatActivity {

    private Jogo jogo = new Jogo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);
    }

    public void avisarJogador(){
        //TODO avisar que é a vez do jogador
    }

    public void clickChute(){
        //TODO pegar texto tela
        String textoTela = "";
        jogo.jogador.Chutar(textoTela);
    }
}
