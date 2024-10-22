#include "ProyectoFinal.h"
#include <fstream>
#include <sstream>
#include <iostream>

// Función para leer el CSV y almacenar los datos en un vector de Producto
vector<Producto> leerCSV(const string& nombre_archivo) {
    ifstream archivo(nombre_archivo);
    vector<Producto> productos;

    if (!archivo.is_open()) {
        cout << "Error al abrir el archivo" << endl;
        return productos;
    }

    string linea;
    getline(archivo, linea); // Leer la primera línea (cabecera)

    while (getline(archivo, linea)) {
        stringstream ss(linea);
        Producto prod;

        getline(ss, prod.nombre, ',');
        ss >> prod.precio_base; ss.ignore();  // Leer precio base e ignorar la coma
        ss >> prod.ventas_previas; ss.ignore();  // Leer ventas previas e ignorar la coma
        ss >> prod.precio_actual; // Leer el precio actual

        productos.push_back(prod);
    }

    archivo.close();
    return productos;
}

// Función para imprimir la información de los productos
void imprimirProductos(const vector<Producto>& productos) {
    for (const auto& prod : productos) {
        cout << "Nombre del producto: " << prod.nombre << endl;
        cout << "Precio base: " << prod.precio_base << endl;
        cout << "Ventas previas: " << prod.ventas_previas << endl;
        cout << "Precio actual: " << prod.precio_actual << endl;
        cout << "-----------------------------" << endl;
    }
}

// Función para ajustar el modelo de regresión lineal
ModeloRegresion ajustarModelo(const vector<double>& x, const vector<double>& y) {
    int n = x.size();
    double sumaX = 0, sumaY = 0, sumaXY = 0, sumaX2 = 0;

    for (int i = 0; i < n; ++i) {
        sumaX += x[i];
        sumaY += y[i];
        sumaXY += x[i] * y[i];
        sumaX2 += x[i] * x[i];
    }

    double pendiente, interseccion;
    double denominador = n * sumaX2 - sumaX * sumaX;

    if (denominador != 0) {
        pendiente = (n * sumaXY - sumaX * sumaY) / denominador;
        interseccion = (sumaY - pendiente * sumaX) / n;
    } else {
        cerr << "Error: no se puede ajustar un modelo de regresión lineal, divisor es cero." << endl;
        pendiente = 0;
        interseccion = 0;
    }

    return { pendiente, interseccion };
}

// Función para hacer una predicción con el modelo de regresión lineal
double predecir(const ModeloRegresion& modelo, double x) {
    return modelo.pendiente * x + modelo.interseccion;
}

// Función para calcular el error cuadrático medio (MSE)
double calcularMSE(const vector<double>& x, const vector<double>& y, const ModeloRegresion& modelo) {
    double mse = 0;
    int n = x.size();

    for (int i = 0; i < n; ++i) {
        double prediccion = predecir(modelo, x[i]);
        mse += (prediccion - y[i]) * (prediccion - y[i]);
    }

    return mse / n;
}

// Función para calcular el coeficiente de determinación (R²)
double calcularR2(const vector<double>& x, const vector<double>& y, const ModeloRegresion& modelo) {
    double media_y = 0;
    int n = y.size();

    for (int i = 0; i < n; ++i) {
        media_y += y[i];
    }
    media_y /= n;

    double ss_total = 0, ss_residual = 0;

    for (int i = 0; i < n; ++i) {
        double prediccion = predecir(modelo, x[i]);
        ss_total += (y[i] - media_y) * (y[i] - media_y);
        ss_residual += (y[i] - prediccion) * (y[i] - prediccion);
    }

    return 1 - (ss_residual / ss_total);
}

