package gigel.forcagijel;

/**
 * Created by gabri on 01/05/2016.
 */
public class Reu {

    private String status;
    private int partesInseridas;

    public Reu() {
        partesInseridas = 0;
        status = "Vivo";
    }

    public String getStatus() {
        return status;
    }

    public int getVidas() {
        return partesInseridas;
    }

    public void inserirParte() {
        //TODO Verificar antes se já não está morto?
        partesInseridas++;
        if(partesInseridas == 6){
            status = "Enforcado";
        }
    }
}