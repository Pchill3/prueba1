public class Principal {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Uso: java Principal <nombreExaminador1> <nombreExaminador2>...");
            System.exit(1);
        }

        BufferExamenes generador = new BufferExamenes();

        for (String nombre : args) {
            new Examinador(nombre, generador);
        }

        for (String nombre : args) {
            new ProductorExamenes(generador);
        }
    }
}
