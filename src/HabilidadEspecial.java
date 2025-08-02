import java.util.Random;

public class HabilidadEspecial {

    private String nombre;
    private enum TipoEfecto{ VALORES, AUMENTA_ATAQUE, AUMENTA_DEFENSA, LASTIMAR_ENEMIGO};
    private TipoEfecto efecto;
    private int valor;
    private int probabilidad;
    private Random random;

    public HabilidadEspecial() {
    }
    public HabilidadEspecial(String nombre, TipoEfecto efecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean intentarActivacion(){
        random = new Random();
        int numeroRandom = random.nextInt(100);

        //If the number is the same or over 50 it's going to be valid.

        if(numeroRandom >= this.probabilidad){
            return  true;
        }

        return false;

    }

    // public void aplicarEfecto(){}


    public String getNombre() {
        return nombre;
    }

    public TipoEfecto getEfecto() {
        return efecto;
    }

    public int getValor() {
        return valor;
    }

    public int getProbabilidad() {
        return probabilidad;
    }
}
