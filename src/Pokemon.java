public class Pokemon {

    private String nombre;
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
        this.efectoHabilidadActivo = false;
        this.rondasEfectoRestantes = 0;
    }

    public int calcularAtaqueTotal(Pokemon enemigo){

        int totalAtaque = ataque;

        totalAtaque += obtenerEfectividad(enemigo);
        // Applying effect of the ability if it is active
        if(efectoHabilidadActivo){
            switch(habilidadEspecial.getEfecto()){
                case AUMENTA_ATAQUE:
                    totalAtaque += habilidadEspecial.getValor();
                    break;
                case LASTIMAR_ENEMIGO:
                    totalAtaque += habilidadEspecial.getValor();
                    break;
            }
        }

        return totalAtaque;
    }


    public boolean activarHabilidad(){
        if(habilidadEspecial.intentarActivacion()){
            habilidadEspecial.aplicarEfecto(this);
            //Here we update this one and the next round of effect
            rondasEfectoRestantes = 2;
            return true;
        }
        return false;
    }

    public void actualizarEfectoHabilidad(){
        if(efectoHabilidadActivo){
            rondasEfectoRestantes--;
            if(rondasEfectoRestantes <= 0){
                efectoHabilidadActivo = false;
            }
        }
    }


    private int obtenerEfectividad(Pokemon enemigo){
        TipoPokemon tipoEnemigo = enemigo.getTipo();

        if((tipo == TipoPokemon.FUEGO && tipoEnemigo == TipoPokemon.PLANTA ) ||
                (tipo == TipoPokemon.PLANTA && tipoEnemigo == TipoPokemon.AGUA) ||
                (tipo == TipoPokemon.AGUA && tipoEnemigo == TipoPokemon.FUEGO) ||
                (tipo == TipoPokemon.ELECTRICO && tipoEnemigo == TipoPokemon.AGUA)){
            return 20;
        }

        if((tipo == TipoPokemon.PLANTA && tipoEnemigo==TipoPokemon.FUEGO)||
                (tipo == TipoPokemon.AGUA && tipoEnemigo == TipoPokemon.PLANTA)||
                (tipo == TipoPokemon.FUEGO && tipoEnemigo ==  TipoPokemon.AGUA)){
            return -10;
        }

        return 0;
    }

    public void activarEfectoHabilidad(){
        this.efectoHabilidadActivo = true;
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
