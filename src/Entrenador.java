import java.util.ArrayList;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private ArrayList<Pokemon> pokemonesUsados;

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPokemon(Pokemon pokemon){
        pokemones.add(pokemon);
    }

    public Pokemon seleccionarPokemon(int numero){
        pokemonesUsados.add(pokemones.get(numero));
        return pokemones.get(numero);
    }
    //public boolean pokemonDisponible(){}

    // public void marcarPokemonUsado(){}


    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }
/*
    public ArrayList<Pokemon> getPokemonesDisponibles() {
        return ;
    }*/


}
