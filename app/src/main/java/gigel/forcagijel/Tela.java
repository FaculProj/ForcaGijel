package gigel.forcagijel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Tela extends AppCompatActivity {

    //private Jogo jogo = new Jogo(this);

    private Palavra p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);
        p1 = new Palavra("abacate");
    }

    public void avisarJogador(){
        //TODO avisar que é a vez do jogador
    }

    public void clickChute(View view){
        //TODO pegar texto tela
        String a = p1.verificarChute("t");
        //jogo.jogador.Chutar(textoTela);
    }
}
