import java.time.LocalDateTime;

//creamos la clase de productor de examenes
//implementamos la interfaz de Runnable para poder crear un hilo
//creamos un buffer de examenes para poder generar un nuevo examen y un hilo
//asignamos un numero de examen a cada examen que se genere
public class ProductorExamenes implements Runnable {
    private BufferExamenes buffer;
    private Thread hilo;

    private static int numeroExamen = 0;

    //creamos el constructor de la clase
    //le pasamos el objeto de la clase BufferExamenes
    //añadimos un numero a cada examen que se genere con el ++
    //iniciamos el hilo con su numero de examen y con el año que sea
    //asignamos el buffer al que se meteran los examenes
    //iniciamos el hilo con el metodo start
    public ProductorExamenes(BufferExamenes buffer) {
        numeroExamen++;
        hilo = new Thread(this, "E" + numeroExamen + "-" + LocalDateTime.now().getYear());
        this.buffer = buffer;
        hilo.start();
    }

    //creamos el metodo de run con un override para sobrescribir el metodo
    //creamos una variable de año para que sepa en que año esta
    //creamos una variable de codigo para que sepa que codigo tiene el examen
    //llamamos al metodo de fabricar un nuevo examen del buffer y le pasamos el codigo
    //enseñamos por pantalla que se ha producido un nuevo examen con su codigo
    @Override
    public void run() {
        int aa = LocalDateTime.now().getYear();
        String codigo = this.hilo.getName();
        buffer.fabricarNuevoExamen(codigo);
        System.out.println("Producido examen " + codigo);
    }
}
