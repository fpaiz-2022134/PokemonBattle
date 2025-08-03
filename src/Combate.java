import java.sql.SQLOutput;
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
        System.out.println(" ");

        for(int i = 0; i <4; i++){
            ejecutarRonda();
            actualizarEfectosHabilidades();
            rondaActual++;
        }

        determinarGanadorCombate();
    }

    public void ejecutarRonda(){
        System.out.println("        RONDA " + rondaActual + "       ");

        // Choosing trainer's Pokémon
        Pokemon pokemon1 = seleccionarPokemonEntrenador(entrenador1);
        Pokemon pokemon2 = seleccionarPokemonEntrenador(entrenador2);

        System.out.println("\n" + entrenador1.getNombre() + " eligió a: " + pokemon1.getNombre() + " ( Tipo: " + pokemon1.getTipo() + ")");
        System.out.println(entrenador2.getNombre() + " eligió a: " + pokemon2.getNombre() + " (Tipo: " + pokemon2.getTipo() + ")");

        boolean habilidad1 = decidirHabilidadEspecial(pokemon1, entrenador1.getNombre());
        boolean habilidad2 = decidirHabilidadEspecial(pokemon2, entrenador2.getNombre());

        //Calculating the atacks of each one

        int ataque1 = pokemon1.calcularAtaqueTotal(pokemon2);
        int ataque2 = pokemon2.calcularAtaqueTotal(pokemon1);

        //Seeing the results
        System.out.println("        RESULTS     ");
        System.out.println("Ataque total de " + pokemon1.getNombre() + ":" + ataque1);
        System.out.println("Ataque total de " + pokemon2.getNombre() + ":" + ataque2);

        int resultado = determinarGanadorRonda(ataque1, ataque2);

        if (resultado == 1) {
            ganadasEntrenador1++;
            System.out.println("¡" + entrenador1.getNombre() + " ganó la ronda!");
        } else if (resultado == 2) {
            ganadasEntrenador2++;
            System.out.println("¡" + entrenador2.getNombre() + " ganó la ronda!");
        } else {
            System.out.println("EMPATE :V");
        }

        System.out.println("Marcador: " + entrenador1.getNombre() + " " + ganadasEntrenador1 +
                " - " + ganadasEntrenador2 + " " + entrenador2.getNombre());

    }

    private void actualizarEfectosHabilidades() {
        for (Pokemon pokemon : entrenador1.getPokemones()) {
            pokemon.actualizarEfectoHabilidad();
        }
        for (Pokemon pokemon : entrenador2.getPokemones()) {
            pokemon.actualizarEfectoHabilidad();
        }
    }


    private Pokemon seleccionarPokemonEntrenador(Entrenador entrenador){
        System.out.println(entrenador.getNombre() + " selecciona tu pokemón: ");

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

    private boolean decidirHabilidadEspecial(Pokemon pokemon, String nombreEntrenador){
        System.out.println("\n" + nombreEntrenador + " ¿Deseas activar la habilidad " + pokemon.getHabilidadEspecial().getNombre() +"? ");
        System.out.println("1. Sí \n 2.No");

        int decision = scanner.nextInt();
        if(decision == 1){
            boolean activada = pokemon.activarHabilidad();
            if(activada == true){
                System.out.println("La habilidad " + pokemon.getHabilidadEspecial().getNombre() + "ha sido activada.");
                return true;
            }else{
                System.out.println("La habilidad no se activó :/");
            }
        }
        return false;
    }

    private int determinarGanadorRonda(int ataque1, int ataque2){

        if(ataque1 > ataque2){
            return 1;
        }else if(ataque1 < ataque2){
            return 2;
        }

        return 0;
    }

    private void determinarGanadorCombate() {
        System.out.println("\n      RESULTADOS FINALES      ");
        System.out.println("Rondas ganadas:");
        System.out.println(entrenador1.getNombre() + ": " + ganadasEntrenador1);
        System.out.println(entrenador2.getNombre() + ": " + ganadasEntrenador2);

        if (ganadasEntrenador1 > ganadasEntrenador2) {
            System.out.println("\n¡" + entrenador1.getNombre() + " ES EL CAMPEÓN, THE GOAT!");
        } else if (ganadasEntrenador2 > ganadasEntrenador1) {
            System.out.println("\n¡" + entrenador2.getNombre() + " ES EL CAMPEÓN, THE GOAT!");
        } else {
            System.out.println("\n¡SE OBTUVO UN EMPATE GENERAL!");
        }
        System.out.println("=======================");
    }

}
