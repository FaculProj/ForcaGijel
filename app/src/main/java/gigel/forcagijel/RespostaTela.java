package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class RespostaTela {

    String oculta1;
    String oculta2;
    boolean acertou;
    boolean vivo;
    int vidas;

    public RespostaTela(String oc1, String oc2, boolean ac, boolean alive, int lifes){
        oculta1 = oc1.toUpperCase();
        oculta2 = oc2.toUpperCase();
        acertou = ac;
        vivo = alive;
        vidas = lifes;
    }

}
