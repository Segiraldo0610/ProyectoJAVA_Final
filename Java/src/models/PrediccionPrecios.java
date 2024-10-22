import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrediccionPrecios {

    // Método para invocar el programa C++ y obtener una predicción
    public double predecirPrecio(double cantidadVendida) {
        double precioPredicho = 0.0;
        try {
            // Cambia "ruta_a_tu_programa_cpp" por la ruta a tu ejecutable C++
            ProcessBuilder processBuilder = new ProcessBuilder("c++/main.cpp", String.valueOf(cantidadVendida));
            Process process = processBuilder.start();

            // Leer la salida del programa C++
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            if (line != null) {
                precioPredicho = Double.parseDouble(line);
            }

            process.waitFor(); // Esperar a que el proceso termine
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return precioPredicho;
    }
}

