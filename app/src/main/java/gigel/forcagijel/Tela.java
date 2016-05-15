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
    TextView qtdVidasTela;
    TextView jogadorTela;
    TextView nomeTela;
    TextView jogadaTela;

    EditText chuteTela;
    EditText tentativa1Tela;
    EditText tentativa2Tela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);

        p1Tela = (TextView) findViewById(R.id.palavra1);
        p2Tela = (TextView) findViewById(R.id.palavra2);
        qtdVidasTela = (TextView) findViewById(R.id.qtdVidas);
        jogadorTela = (TextView) findViewById(R.id.jogador);
        nomeTela = (TextView) findViewById(R.id.nome);
        jogadaTela = (TextView) findViewById(R.id.jogada);

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
            atualizarTela(r);
        }
    }

    public void clickTentativa(View view){
        String tentativa1 = tentativa1Tela.getText().toString();
        String tentativa2 = tentativa2Tela.getText().toString();
        tentativa1Tela.setText("");
        tentativa2Tela.setText("");
        if( (! tentativa1.equals("")) && (! tentativa2.equals("")) ){
            RespostaTela r = jogo.tentar(tentativa1, tentativa2);

        }
    }

    private void atualizarTela(RespostaTela rt){
        p1Tela.setText(rt.oculta1);
        p2Tela.setText(rt.oculta2);
        qtdVidasTela.setText(rt.vidas+" de 5");

        if(rt.acertou){
            jogadaTela.setText("Acertou");
        } else {
            jogadaTela.setText("Errou");
        }

        if(rt.vivo){
            jogadorTela.setText("Vivo");
        } else {
            jogadorTela.setText("Morto");
        }
    }
}
