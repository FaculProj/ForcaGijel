package gigel.forcagijel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Tela extends AppCompatActivity {

    private Jogo jogo = new Jogo(this);

    TextView p1Tela;
    TextView p2Tela;

    EditText chuteTela;
    EditText tentativa1Tela;
    EditText tentativa2Tela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);

        p1Tela = (TextView) findViewById(R.id.palavra1);
        p2Tela = (TextView) findViewById(R.id.palavra2);

        chuteTela = (EditText) findViewById(R.id.chute);
        tentativa1Tela = (EditText) findViewById(R.id.tentativa1);
        tentativa2Tela = (EditText) findViewById(R.id.tentativa2);
    }

    public void avisarJogador(){
        //TODO avisar que é a vez do jogador
    }

    public void clickChute(View view){
        String chute = chuteTela.getText().toString();
        chuteTela.setText("");
        if(! chute.equals("")){
            RespostaTela r = jogo.chutar(chute);

            p1Tela.setText(r.oculta1);
            p2Tela.setText(r.oculta2);
        }
    }

    public void clickTentativa(View view){
        String tentativa1 = tentativa1Tela.getText().toString();
        String tentativa2 = tentativa2Tela.getText().toString();
        tentativa1Tela.setText("");
        tentativa2Tela.setText("");
        if( (! tentativa1.equals("")) && (! tentativa2.equals("")) ){

            RespostaTela r = jogo.tentar(tentativa1, tentativa2);

            p1Tela.setText(r.oculta1);
            p2Tela.setText(r.oculta2);
        }
    }
}
