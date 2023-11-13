public class Principal {
    //creamos la clase main la cual es la que ejecuta el programa
    //creamos un objeto de la clase BufferExamenes para poder generadar un nuevo examen
    //ahora creamos un nuevo productor de examenes por cada examinador que tengamos y le pasamos el objeto de la clase BufferExamenes
    //llamamos a cada examinador con un nombre y le pasamos el objeto de la clase BufferExamenes
    public static void main(String[] args) throws InterruptedException {
        BufferExamenes generador = new BufferExamenes();
        new ProductorExamenes(generador);
        new Examinador("Rosa", generador);
        new ProductorExamenes(generador);
        new Examinador("Miguel", generador);
        new ProductorExamenes(generador);
        new Examinador("Carlos", generador);
    }
}
