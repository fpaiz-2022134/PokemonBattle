import java.util.ArrayList;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private ArrayList<Pokemon> pokemonesUsados;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        this.pokemonesUsados = new ArrayList<>();
    }

    public void agregarPokemon(Pokemon pokemon){
        if(pokemones.size() < 4  ){
            pokemones.add(pokemon);
        }
    }

    public Pokemon seleccionarPokemon(int indice){
        if(pokemonDisponible(indice)){
            Pokemon pokemon = pokemones.get(indice);
            marcarPokemonUsado(pokemon);
            return pokemon;
        }
        pokemonesUsados.add(pokemones.get(indice));
        return pokemones.get(indice);
    }
    public boolean pokemonDisponible(int indice){
        if(indice >= 0 && indice < pokemones.size()){
            return !pokemonesUsados.contains(pokemones.get(indice));
        }
        return false;

    }

    public void marcarPokemonUsado(Pokemon pokemon){
        pokemonesUsados.add(pokemon);
    }

    public ArrayList<Pokemon> getPokemonesDisponibles(){
        ArrayList<Pokemon> pokemonesDisponibles = new ArrayList<>();
        for(Pokemon pokemon : pokemones){
            if(!pokemonesUsados.contains(pokemon)){
                pokemonesDisponibles.add(pokemon);
            }
        }
        return pokemonesDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }


}
