import java.util.Random;

//creamos la clase de examinador
//implementamos la interfaz de Runnable para poder crear un hilo
//creamos un hilo y un buffer de examenes
public class Examinador implements Runnable {
    private Thread hilo;
    private BufferExamenes buffer;

    //creamos el constructor de la clase
    //le pasamos el nombre del alumno y el objeto de la clase BufferExamenes
    //iniciamos el hilo con el nombre del alumno
    //asignamos el buffer al que se meteran los examenes
    //iniciamos el hilo con el metodo start
    public Examinador(String alumno, BufferExamenes generador) {
        hilo = new Thread(this, alumno);
        this.buffer = generador;
        hilo.start();
    }

    //creamos el metodo de run con un override para sobrescribir el metodo
    //creamos un try catch
    //creamos una variable de codigo de examen para que sepa que codigo tiene el examen
    //hacemos que si el codigo del examen es distinto de null se cree un bucle de 10 preguntas y respuestas
    //mostramos las preguntas por pantalla con el codigo, la funcion de getname para el nombre del alumno, luego el numero de pregunta del bucle for y por ultimo la funcion de generarRespuestaAleatoria
    //si el codigo del examen es null mostramos que se ha agotado el tiempo de espera y no hay mas examenes
    //con el catch mostramos si ocurre algun error
    @Override
    public void run() {
        try {
            String codigoExamen = this.buffer.consumirExamen();
            if (codigoExamen != null) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(codigoExamen + "; " + hilo.getName() + "; Pregunta " + i + ";" + generarRespuestaAleatoria());
                }
            } else {
                System.out.println("Agotado tiempo de espera y no hay más exámenes");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //creamos el metodo de generarRespuestaAleatoria
    //creamos un objeto de la clase random el para generar numeros aleatorios
    //creamos un array con las posibles respuestas
    //crea un numero aleatorio con la longitud del array con lo cual si genera el 0 saldra la A, si genera el 1 saldra la B etc
    //devolvemos la respuesta
    private char generarRespuestaAleatoria() {
        Random random = new Random();
        char[] respuestas = {'A', 'B', 'C', 'D', '-'};
        int indiceRespuesta = random.nextInt(respuestas.length);
        return respuestas[indiceRespuesta];
    }
}
