package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Reu {

    int vidasPerdidas;
    boolean vivo;

    public Reu(){
        vidasPerdidas = 0;
        vivo = true;
    }

    public boolean perderVida(){
        if(vidasPerdidas < 4){
            vidasPerdidas++;
        } else {
            vidasPerdidas++;
            vivo = false;
        }

        return vivo;
    }


}
