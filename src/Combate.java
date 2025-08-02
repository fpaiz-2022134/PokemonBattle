import java.util.ArrayList;
import java.util.Scanner;

public class Combate {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int ganadasEntrenador1;
    private int ganadasEntrenador2;
    private int rondaActual;
    private Scanner scanner;


    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.ganadasEntrenador1 = 0;
        this.ganadasEntrenador2 = 0;
        this.rondaActual = 1;
        this.scanner = new Scanner(System.in);

    }

    public void iniciarCombate(){
        System.out.println("    ¡POKEMON BATTLE!    ");
        System.out.println(entrenador1.getNombre() + "  VS  " + entrenador2.getNombre());
        System.out.println("");

        for(int i = 0; i <4; i++){
            ejecutarRonda();
            actualizarEfectosHabilidades();
            rondaActual++;
        }

        determinarGanadorCombate();
    }

    public void ejecutarRonda(){
        System.out.println("        RONDA " + rondaActual + "       ");

        // Choosing trainer's pokemons
        Pokemon pokemon1 = seleccionarPokemonEntrenador(entrenador1);
        Pokemon pokemon2 = seleccionarPokemonEntrenador(entrenador2);

        System.out.println("\n" + entrenador1.getNombre() + " eligió a: " + pokemon1.getNombre() + " ( Tipo: " + pokemon1.getTipo() + ")");
        System.out.println(entrenador2.getNombre() + " eligió a: " + pokemon2.getNombre() + " (Tipo: " + pokemon2.getTipo() + ")");


    }

    private void actualizarEfectosHabilidades(){

    }


    private Pokemon seleccionarPokemonEntrenador(Entrenador entrenador){
        System.out.println(entrenador1.getNombre() + " selecciona tu pokemón: ");

        ArrayList<Pokemon> disponibles = entrenador.getPokemonesDisponibles();
        for(int i = 0; i < disponibles.size(); i++){
            Pokemon pok = disponibles.get(i);
            String estado = pok.isEfectoHabilidadActivo() ? " EFECTO HABILIDAD ACTIVO": " ";
            System.out.println((i+1) + ". " + pok.getNombre() + " - " + pok.getTipo() + " - ATAQUE: "+ pok.getAtaque() + " Estado: " + estado);
        }

        int seleccion;

        do{
            System.out.println("Número de Pokemon: ");
            seleccion = scanner.nextInt() -1;
        } while (seleccion < 0 || seleccion >= disponibles.size());

        Pokemon pokSeleccionado = disponibles.get(seleccion);
        int indicePok = entrenador.getPokemones().indexOf(pokSeleccionado);
        return entrenador.seleccionarPokemon(indicePok);
    }

    private boolean decidirHabilidadEspecial(Pokemon pokemon, String text){

        return false;
    }

    private int determinarGanadorRonda(int ataque1, int ataque2){

        return ataque1;
    }

    public void determinarGanadorCombate(){}

}
