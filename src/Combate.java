import java.util.Scanner;

public class Combate {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int ganadasEntrenador1;
    private int ganadasEntrenador2;
    private int rondaActual;
    private Scanner scanner = new Scanner(System.in);


    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public void iniciarCombate(){

    }

    public void ejecutarRonda(){}

    private void actualizarEfectosHabilidades(){

    }
    /*
    private Pokemon seleccionarPokemonEntrenador(Entrenador entrenador){

        return
    }*/

    private boolean decidirHabilidadEspecial(Pokemon pokemon, String text){

        return false;
    }

    private int determinarGanadorRonda(int ataque1, int ataque2){

        return ataque1;
    }

    public void determinarGanadorCombate(){}

}
