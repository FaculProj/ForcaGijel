package gigel.forcagijel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela extends AppCompatActivity {

    //private Jogo jogo = new Jogo(this);

    private Palavra p1;
    private Palavra p2;

    TextView p1Tela;
    TextView p2Tela;

    EditText chuteTela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);
        p1 = new Palavra("abacate");
        p2 = new Palavra("elefante");

        p1Tela = (TextView) findViewById(R.id.palavra1);
        p2Tela = (TextView) findViewById(R.id.palavra2);

        chuteTela = (EditText) findViewById(R.id.chute);
    }

    public void avisarJogador(){
        //TODO avisar que é a vez do jogador
    }

    public void clickChute(View view){
        //TODO pegar texto tela
        String chute = chuteTela.getText().toString();
        chuteTela.setText("");
        Resposta r1 = p1.verificarChute(chute);
        Resposta r2 = p2.verificarChute(chute);

        p1Tela.setText(r1.oculta);
        p2Tela.setText(r2.oculta);

    }
}
