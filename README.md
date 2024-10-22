# Documentación del Proyecto: Sistema de Gestión de Productos

## Índice
1. [Introducción](#introducción)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Requisitos](#requisitos)
4. [Instalación](#instalación)
5. [Uso](#uso)
6. [Funcionalidades](#funcionalidades)
7. [Predicción de Precios](#predicción-de-precios)
8. [Agradecimientos](#agradecimientos)


## Introducción
Este proyecto es un sistema de gestión de productos que permite registrar diferentes tipos de productos, realizar ventas, mostrar productos registrados y predecir precios mediante regresión lineal. Está diseñado en dos partes: una en C++ para la parte de regresión y otra en Java para la gestión de productos.

## Estructura del Proyecto
ProyectoFinal/ ├── C++/ │ ├── main.cpp // Implementación principal en C++ │ ├── regresion_lineal.h // Archivo de cabecera para la regresión lineal │ └── regresion_lineal.cpp // Implementación de la regresión lineal ├── Java/ │ ├── src/ │ │ ├── controllers/ │ │ │ └── VentasController.java // Controlador de la interfaz gráfica o consola │ │ ├── models/ │ │ │ ├── Producto.java // Clase Producto (base) │ │ │ ├── ProductoElectronico.java // Clase derivada ProductoElectrónico │ │ │ ├── ProductoAlimenticio.java // Clase derivada ProductoAlimenticio │ │ │ └── PrediccionPrecios.java // Conexión con la regresión lineal en C++ │ │ └── views/ │ │ └── VentasView.fxml // Archivo FXML para la interfaz gráfica (solo si aplicable) │ └── Main.java // Punto de entrada principal para el sistema en Java ├── README.md // Instrucciones y detalles del proyecto ├── .gitignore // Archivos que no deben incluirse en el repositorio └── mse.txt // Archivo donde se registran los errores cuadráticos medios (si es necesario)


## Funcionalidades

1. **Registro de Productos**: Permite registrar productos de tipo alimenticio y electrónico, incluyendo información como nombre, precio base, cantidad disponible, garantía (para productos electrónicos) y fecha de caducidad (para productos alimenticios).

2. **Registro de Ventas**: Facilita el registro de las ventas realizadas en el sistema, permitiendo mantener un historial de transacciones.

3. **Predicción de Precios**: Implementa un modelo de regresión lineal en C++ para predecir precios basados en la cantidad vendida.

4. **Mostrar Productos**: Permite visualizar la lista de productos registrados en el sistema.

## Requisitos

- **C++**: Un compilador compatible con C++11 o superior.
- **Java**: JDK 11 o superior.

## Instalación

1. Clona el repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tu_usuario/ProyectoFinal.git
   
Navega a la carpeta del proyecto:
cd ProyectoFinal
## Uso

- Ejecuta el programa en C++ para realizar la regresión y predicción de precios.
- Ejecuta el programa en Java para registrar productos, realizar ventas y mostrar productos.

## Funcionalidades

- Registrar productos (electrónicos y alimenticios).
- Mostrar lista de productos registrados.
- Registrar ventas (por implementar).
- Predecir precios basados en la regresión lineal de datos históricos de ventas.

## Predicción de Precios

La funcionalidad de predicción de precios se implementa en C++. Se utiliza regresión lineal para calcular la relación entre la cantidad vendida y el precio. Los resultados se muestran en la consola y se guardan en un archivo `mse.txt`.

## Agradecimientos

Agradecemos al profesor [CRISTHIAM CAMPOS JULCA] por su apoyo y orientación durante el desarrollo de este proyecto. Su conocimiento y entusiasmo por la programación avanzada en la Universidad Javeriana han sido fundamentales para el éxito de esta iniciativa.


