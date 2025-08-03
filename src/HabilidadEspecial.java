import java.util.Random;

public class HabilidadEspecial {

    private String nombre;
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
        this.random = new Random();
    }

    public boolean intentarActivacion(){
        int numeroRandom = random.nextInt(100);

        return numeroRandom <= probabilidad;

    }

    public void aplicarEfecto(Pokemon pokemon){
        pokemon.activarEfectoHabilidad();
    }


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
