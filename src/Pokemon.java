public class Pokemon {

    private String nombre;
    private enum TipoPokemon{VALORES, FUEGO, AGUA, PLANTA, ELECTRICO}
    private TipoPokemon tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean efectoHabilidadActivo;
    private int rondasEfectoRestantes;

    public Pokemon() {
    }

    public Pokemon(String nombre, TipoPokemon tipo, int ataque, int defensa, HabilidadEspecial habilidadEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public boolean isEfectoHabilidadActivo() {
        return efectoHabilidadActivo;
    }

    public int getRondasEfectoRestantes() {
        return rondasEfectoRestantes;
    }
}
