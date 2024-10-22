#ifndef PROYECTOFINAL_H
#define PROYECTOFINAL_H
#include <string>
#include <vector>

using namespace std;

// Definición de la estructura Producto
struct Producto {
    string nombre;            // Nombre del producto
    double precio_base;       // Precio base del producto
    int ventas_previas;       // Cantidad de ventas previas
    double precio_actual;     // Precio actual
};

// Definición de la estructura ModeloRegresion
struct ModeloRegresion {
    double pendiente;
    double interseccion;
};

// Funciones declaradas
vector<Producto> leerCSV(const string& nombre_archivo);
void imprimirProductos(const vector<Producto>& productos);
ModeloRegresion ajustarModelo(const vector<double>& x, const vector<double>& y);
double predecir(const ModeloRegresion& modelo, double x);
double calcularMSE(const vector<double>& x, const vector<double>& y, const ModeloRegresion& modelo);
double calcularR2(const vector<double>& x, const vector<double>& y, const ModeloRegresion& modelo);

#endif // PROYECTOFINAL_H

