import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicializarDatos();
    }

    public void inicializarDatos() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rangoProbabilidad = random.nextInt(11) + 30;

        // Creating special abilities
        HabilidadEspecial llamaFinal = new HabilidadEspecial("Blaze", TipoEfecto.AUMENTA_ATAQUE, 15, rangoProbabilidad);
        HabilidadEspecial escudoNatural = new HabilidadEspecial("Overgrow", TipoEfecto.AUMENTA_DEFENSA, 20, rangoProbabilidad);
        HabilidadEspecial impactoRelampago = new HabilidadEspecial("Static", TipoEfecto.LASTIMAR_ENEMIGO, 10, rangoProbabilidad);
        HabilidadEspecial tormentaAcuatica = new HabilidadEspecial("Torrent", TipoEfecto.AUMENTA_ATAQUE, 12, rangoProbabilidad);
        HabilidadEspecial fogonazo = new HabilidadEspecial("Flash Fire", TipoEfecto.LASTIMAR_ENEMIGO, 8, rangoProbabilidad);
        HabilidadEspecial barreraVerde = new HabilidadEspecial("Chlorophyll", TipoEfecto.AUMENTA_DEFENSA, 18, rangoProbabilidad);
        HabilidadEspecial rayoMortal = new HabilidadEspecial("Volt Absorb", TipoEfecto.LASTIMAR_ENEMIGO, 15, rangoProbabilidad);
        HabilidadEspecial mareaAlta = new HabilidadEspecial("Intimidate", TipoEfecto.AUMENTA_ATAQUE, 10, rangoProbabilidad);
        HabilidadEspecial trueno = new HabilidadEspecial("Static", TipoEfecto.LASTIMAR_ENEMIGO, 12, rangoProbabilidad);
        HabilidadEspecial llamarada = new HabilidadEspecial("Run Away", TipoEfecto.AUMENTA_ATAQUE, 14, rangoProbabilidad);

        // Pokemons available
        ArrayList<Pokemon> pokemonDisponibles = new ArrayList<>();
        pokemonDisponibles.add(new Pokemon("Charizard", TipoPokemon.FUEGO, 45, 35, llamaFinal));
        pokemonDisponibles.add(new Pokemon("Blastoise", TipoPokemon.AGUA, 42, 40, tormentaAcuatica));
        pokemonDisponibles.add(new Pokemon("Venusaur", TipoPokemon.PLANTA, 40, 42, escudoNatural));
        pokemonDisponibles.add(new Pokemon("Pikachu", TipoPokemon.ELECTRICO, 38, 30, impactoRelampago));
        pokemonDisponibles.add(new Pokemon("Arcanine", TipoPokemon.FUEGO, 44, 38, fogonazo));
        pokemonDisponibles.add(new Pokemon("Gyarados", TipoPokemon.AGUA, 46, 36, mareaAlta));
        pokemonDisponibles.add(new Pokemon("Exeggutor", TipoPokemon.PLANTA, 41, 44, barreraVerde));
        pokemonDisponibles.add(new Pokemon("Jolteon", TipoPokemon.ELECTRICO, 43, 32, rayoMortal));
        pokemonDisponibles.add(new Pokemon("Raichu", TipoPokemon.ELECTRICO, 40, 34, trueno));
        pokemonDisponibles.add(new Pokemon("Rapidash", TipoPokemon.FUEGO, 43, 36, llamarada));

        System.out.println("    Bienvenido al COMBATE POKEMON       ");
        System.out.println();

        // Name of the coaches
        System.out.print("Escribe el nombre del primer entrenador: ");
        String nombreEntrenador1 = scanner.nextLine();

        System.out.print("Escribe el nombre del segundo entrenador: ");
        String nombreEntrenador2 = scanner.nextLine();

        // Creating the trainers
        Entrenador entrenador1 = new Entrenador(nombreEntrenador1);
        Entrenador entrenador2 = new Entrenador(nombreEntrenador2);

        // Selection of Pokémons
        System.out.println("\n" + nombreEntrenador1 + ", selecciona tus 4 Pokémon:");
        seleccionarPokemonParaEntrenador(entrenador1, pokemonDisponibles, scanner);

        System.out.println("\n" + nombreEntrenador2 + ", selecciona tus 4 Pokémon:");
        seleccionarPokemonParaEntrenador(entrenador2, pokemonDisponibles, scanner);

        // Teams selected
        mostrarEquipo(entrenador1);
        mostrarEquipo(entrenador2);

        // Starting the combat
        Combate combate = new Combate(entrenador1, entrenador2);
        combate.iniciarCombate();

        System.out.println("\n¡Gracias por jugar crack, ídolo, terremoto, maremoto!");
        scanner.close();
    }

    private void seleccionarPokemonParaEntrenador(Entrenador entrenador, ArrayList<Pokemon> pokemonDisponibles, Scanner scanner) {
        ArrayList<Integer> seleccionados = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.println("\nSelecciona tu Pokémon #" + (i + 1) + ":");
            mostrarPokemonDisponibles(pokemonDisponibles, seleccionados);

            int seleccion;
            do {
                System.out.print("Escribe número del Pokémon: ");
                seleccion = scanner.nextInt();
                scanner.nextLine();

                if (seleccion < 1 || seleccion > pokemonDisponibles.size()) {
                    System.out.println("El número no es válido, intenta otra vez.");
                } else if (seleccionados.contains(seleccion - 1)) {
                    System.out.println("Ya seleccionaste ese Pokémon. Escoge otro.");
                } else {
                    break;
                }
            } while (true);

            seleccionados.add(seleccion - 1);
            Pokemon pokemonSeleccionado = crearCopiaPokemon(pokemonDisponibles.get(seleccion - 1));
            entrenador.agregarPokemon(pokemonSeleccionado);

            System.out.println("¡" + pokemonSeleccionado.getNombre() + " se unió a tu equipo!");
        }
    }

    private void mostrarPokemonDisponibles(ArrayList<Pokemon> pokemonDisponibles, ArrayList<Integer> seleccionados) {
        System.out.println("Pokémon disponibles:");
        System.out.println("-------------------");

        for (int i = 0; i < pokemonDisponibles.size(); i++) {
            Pokemon p = pokemonDisponibles.get(i);
            String estado = seleccionados.contains(i) ? " [Ya está seleccionado]" : "";

            System.out.printf("%2d. %-12s (%s) - ATAQUE: %2d, DEFENSA: %2d - %s%s%n",
                    (i + 1),
                    p.getNombre(),
                    p.getTipo(),
                    p.getAtaque(),
                    p.getDefensa(),
                    p.getHabilidadEspecial().getNombre(),
                    estado
            );
        }
    }

    private Pokemon crearCopiaPokemon(Pokemon original) {
        HabilidadEspecial habilidadCopia = new HabilidadEspecial(
                original.getHabilidadEspecial().getNombre(),
                original.getHabilidadEspecial().getEfecto(),
                original.getHabilidadEspecial().getValor(),
                original.getHabilidadEspecial().getProbabilidad()
        );

        return new Pokemon(
                original.getNombre(),
                original.getTipo(),
                original.getAtaque(),
                original.getDefensa(),
                habilidadCopia
        );
    }

    private void mostrarEquipo(Entrenador entrenador) {
        System.out.println("\n     Equipo de " + entrenador.getNombre().toUpperCase() + " ---");
        ArrayList<Pokemon> equipo = entrenador.getPokemones();

        for (int i = 0; i < equipo.size(); i++) {
            Pokemon p = equipo.get(i);
            System.out.printf("%d. %-12s (%s) - ATAQUE: %2d, DEFENSA: %2d - %s%n",
                    (i + 1),
                    p.getNombre(),
                    p.getTipo(),
                    p.getAtaque(),
                    p.getDefensa(),
                    p.getHabilidadEspecial().getNombre()
            );
        }
    }
}
