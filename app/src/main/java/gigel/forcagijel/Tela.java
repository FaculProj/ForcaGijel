package gigel.forcagijel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Tela extends AppCompatActivity {

    private Jogo jogo;

    //TODO mover para Jogo e transformar em uma lista, para verificar se a letra já foi jogada
    String chutes = "";

    TextView p1Tela;
    TextView p2Tela;
    TextView qtdVidasTela;
    TextView jogadorTela;
    TextView nomeTela;
    TextView jogadaTela;
    TextView chutesTela;

    EditText chuteTela;
    EditText tentativa1Tela;
    EditText tentativa2Tela;

    EditText palavraFornecida1;
    EditText palavraFornecida2;
    Palavra givenWord;

    RelativeLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);

        background = (RelativeLayout)findViewById(R.id.background);

        p1Tela = (TextView) findViewById(R.id.palavra1);
        p2Tela = (TextView) findViewById(R.id.palavra2);
        qtdVidasTela = (TextView) findViewById(R.id.qtdVidas);
        jogadorTela = (TextView) findViewById(R.id.jogador);
        nomeTela = (TextView) findViewById(R.id.nome);
        jogadaTela = (TextView) findViewById(R.id.jogada);
        chutesTela = (TextView) findViewById(R.id.chutes);

        chuteTela = (EditText) findViewById(R.id.chute);
        tentativa1Tela = (EditText) findViewById(R.id.tentativa1);
        tentativa2Tela = (EditText) findViewById(R.id.tentativa2);

        jogo = new Jogo(this);
        pegarPalavras();

    }

    public void clickChute(View view){
        String chute = chuteTela.getText().toString();
        chuteTela.setText("");
        if(! chute.equals("")){
            chutes = (chutes +" "+ chute).trim();
            chutesTela.setText(chutes);
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
        qtdVidasTela.setText(rt.vidas + " de 5");

        if(rt.acertou){
            jogadaTela.setText("Acertou");
        } else {
            jogadaTela.setText("Errou");
        }

        if(rt.vivo){
            jogadorTela.setText("Vivo");
        } else {
            jogadorTela.setText("Morto");
            mostrarMorreu();
        }

        jogo.proximoJogador();
    }

    public void trocarJogador(Jogador player){

        if(player.nome.equals("A")){
            background.setBackgroundColor(getResources().getColor(R.color.ja));
        } else if(player.nome.equals("B")){
            background.setBackgroundColor(getResources().getColor(R.color.jb));
        } else if(player.nome.equals("C")){
            background.setBackgroundColor(getResources().getColor(R.color.jc));
        } else{
            background.setBackgroundColor(getResources().getColor(R.color.jm));
        }

        nomeTela.setText(player.nome);
    }

    public void mostrarGanhou(){
        Toast.makeText(getApplicationContext(), "Jogador "+jogo.jogadorAtual.nome+" Ganhou!!", Toast.LENGTH_SHORT).show();
    }

    public void mostrarMorreu(){
        Toast.makeText(getApplicationContext(), "Você perdeu!", Toast.LENGTH_SHORT).show();
    }

    public void pegarPalavras(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Insira uma palavra");
        palavraFornecida1 = new EditText(this);
        builder.setView(palavraFornecida1);

        builder.setPositiveButton("Começar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jogo.setP1(new Palavra(palavraFornecida1.getText().toString()));
            }
        });

        AlertDialog ad = builder.create();
        ad.show();
        jogo.proximoJogador();

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Insira uma palavra");
        palavraFornecida2 = new EditText(this);
        builder.setView(palavraFornecida2);

        builder.setPositiveButton("Começar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jogo.setP2(new Palavra(palavraFornecida2.getText().toString()));
            }
        });

        ad = builder.create();
        ad.show();
        jogo.proximoJogador();

    }






}
