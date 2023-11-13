import java.util.LinkedList;
import java.util.Queue;

//creamos la clase de buffer de examenes
//creamos una cola de examenes la cual contendra los examenes que se vayan generando
public class BufferExamenes {
    private Queue<String> colaExamenes;

    //aqui creamos el constructor de la clase
    //inicializamos la cola de examenes
    public BufferExamenes() {
        colaExamenes = new LinkedList<String>();
    }

    //creamos el metodo de fabricar un nuevo examen
    //le pasamos la variable de el codigo del examen que se va a generar
    //sincronizamos el metodo con un notify para que no se pueda acceder a el al mismo tiempo que hay otro hilo
    public synchronized void fabricarNuevoExamen(String codigo) {
        colaExamenes.add(codigo);
        notify();
    }

    //creamos el metodo de consumir examen
    //hacememos que mientras que la cola de examenes este vacia se espere hasta que haya algun examen
    //despues devolvemos el examen que se saco de la cola
    public synchronized String consumirExamen() throws InterruptedException {
        while (colaExamenes.isEmpty()) {
            wait();
        }
        return colaExamenes.poll();
    }
}
