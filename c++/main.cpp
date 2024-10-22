#include <iostream>
#include <fstream>
#include <sstream>
#include "regresion_lineal.h"

using namespace std;

int main() {
    // Definir el tamaño máximo para los datos
    const int MAX_DATOS = 100; 
    double* x = new double[MAX_DATOS]; // Cantidad vendida
    double* y = new double[MAX_DATOS]; // Precio
    int n = 0;

    // Leer datos del archivo CSV
    ifstream archivo("datos_ventas.csv"); // Cambié la extensión a .csv para mayor claridad
    string linea;

    if (archivo.is_open()) {
        while (getline(archivo, linea) && n < MAX_DATOS) {
            stringstream ss(linea);
            string valor;

            // Leer cantidad vendida
            getline(ss, valor, ',');
            x[n] = stod(valor); 

            // Leer precio
            getline(ss, valor, ',');
            y[n] = stod(valor); 

            n++;
        }
        archivo.close();
    } else {
        cout << "No se pudo abrir el archivo." << endl;
        return 1;
    }

    // Calcular parámetros de la regresión lineal
    double a, b;
    calcularRegresionLineal(x, y, n, a, b); // a es la pendiente y b la intersección

    // Solicitar al usuario la cantidad para la predicción
    double cantidad;
    cout << "Ingrese la cantidad para la predicción: ";
    cin >> cantidad;

    // Predecir el precio basado en la cantidad ingresada
    double prediccionGeneral = predecir(a, b, cantidad);
    double mse = calcularMSE(x, y, n, a, b); // Calcular MSE

    // Mostrar resultados
    cout << "Predicción para cantidad=" << cantidad << ": " << prediccionGeneral << endl;
    cout << "MSE: " << mse << endl;

    // Guardar MSE en mse.txt
    ofstream archivoMSE("mse.txt", ios::app); // Abrir en modo append
    if (archivoMSE.is_open()) {
        archivoMSE << "Cantidad: " << cantidad << ", MSE: " << mse << endl; // Guardar en el archivo
        archivoMSE.close();
    } else {
        cout << "No se pudo abrir mse.txt para escribir." << endl;
    }

    // Liberar memoria
    delete[] x;
    delete[] y;

    return 0;
}

