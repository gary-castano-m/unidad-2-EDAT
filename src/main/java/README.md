# Actividad Unidad-2
## Sistema de gestión con Lista, Cola y Pila
### Caso asignado: Veterinaria

## Descripción general

Este proyecto corresponde al desarrollo de una aplicación de consola en **Java** que implementa un sistema de gestión para una **veterinaria**, usando estructuras de datos personalizadas basadas en **nodos enlazados**.

El propósito principal de la actividad es aplicar de forma práctica los conceptos de:

- **Lista**
- **Cola**
- **Pila**
- **Programación orientada a objetos**
- **Manejo de datos mediante nodos enlazados**
- **Control de flujo dentro de una aplicación de consola**
- **Git y control de versiones**

La aplicación permite registrar mascotas para atención veterinaria, administrarlas en una lista general, organizarlas en una cola de pendientes y almacenar el historial de atenciones procesadas en una pila.

---

## Objetivo de la actividad

Desarrollar una solución funcional en Java que represente un caso real de gestión, utilizando de forma obligatoria tres estructuras de datos personalizadas:

- **Lista**: para almacenar todos los elementos registrados en el sistema.
- **Cola**: para gestionar los elementos pendientes por procesar en orden de llegada.
- **Pila**: para guardar el historial de elementos procesados y permitir deshacer la última operación.

En este caso específico, la solución fue adaptada al contexto de una **veterinaria**.

---

## Caso implementado: Veterinaria

La entidad principal del sistema es:

**MascotaAtencion**

Cada objeto de esta clase representa una mascota registrada para recibir atención veterinaria.

### Identificador principal
El identificador utilizado para comparar objetos es:

**codigoAtencion**

El método `equals()` de la clase compara las mascotas usando este atributo, cumpliendo con lo solicitado en la actividad.

---

## Estructuras de datos utilizadas

### 1. Lista
La lista se utiliza para almacenar el **registro general de todas las mascotas** ingresadas al sistema.

Permite:
- Agregar elementos
- Buscar por posición
- Buscar por objeto
- Eliminar elementos
- Contar elementos
- Mostrar el contenido hacia adelante y hacia atrás

Su propósito dentro del sistema es conservar el historial completo de registros, independientemente de si la mascota está pendiente, atendida o cancelada.

---

### 2. Cola
La cola se utiliza para gestionar las **mascotas pendientes por atención**.

Aplica el principio:

**FIFO (First In, First Out)**  
El primero en entrar es el primero en ser atendido.

Permite:
- Encolar mascotas
- Desencolar la siguiente mascota pendiente
- Consultar el primer elemento
- Verificar si está vacía
- Contar elementos
- Mostrar la cola
- Buscar si un elemento está contenido

Dentro del sistema, esta estructura representa el orden de llegada de las mascotas a la veterinaria.

---

### 3. Pila
La pila se utiliza para guardar el **historial de mascotas ya procesadas**.

Aplica el principio:

**LIFO (Last In, First Out)**  
El último en entrar es el primero en salir.

Permite:
- Apilar elementos procesados
- Desapilar el último procesado
- Consultar el elemento superior
- Verificar si está vacía
- Mostrar el historial
- Buscar elementos
- Limpiar la pila

Dentro del sistema, esta estructura se usa para almacenar las atenciones realizadas y para implementar la función de **deshacer la última atención**.

---

## Funcionalidades del sistema

El menú del sistema incluye las siguientes opciones:

1. Registrar mascota para atención
2. Ver todas las mascotas registradas
3. Ver mascotas pendientes
4. Procesar siguiente mascota
5. Ver historial de mascotas atendidas
6. Buscar mascota por código
7. Cancelar mascota pendiente
8. Deshacer última atención
9. Ver cantidad de elementos
10. Salir

---

## Flujo general del sistema

### Registro
Cuando se registra una mascota:
1. Se crea un objeto `MascotaAtencion`.
2. Se almacena en la **lista general**.
3. Se agrega a la **cola de pendientes**.

### Procesamiento
Cuando se procesa una mascota:
1. Se extrae de la **cola**.
2. Se actualiza su estado.
3. Se almacena en la **pila de historial**.

### Deshacer procesamiento
Cuando se deshace una atención:
1. Se extrae la última mascota procesada desde la **pila**.
2. Se cambia nuevamente a estado pendiente.
3. Se vuelve a encolar en la **cola**.

### Cancelación
Para cancelar una mascota pendiente:
1. Se recorre la cola.
2. Se utiliza una **cola auxiliar**.
3. No se elimina directamente desde el centro de la cola, cumpliendo la regla de la actividad.

---

## Clases del proyecto

El proyecto está compuesto por las siguientes clases:

### `Nodo.java`
Representa la unidad básica de almacenamiento de las estructuras enlazadas.  
Contiene el dato y las referencias necesarias para enlazar nodos.

### `Lista.java`
Implementa una lista enlazada para registrar todos los elementos del sistema.

### `Cola.java`
Implementa una cola enlazada para administrar los elementos pendientes por procesar.

### `Pila.java`
Implementa una pila enlazada para mantener el historial de procesados.

### `MascotaAtencion.java`
Clase principal del caso veterinaria.  
Contiene los atributos de cada mascota registrada, sus métodos de acceso, `toString()` y `equals()`.

### `SistemaVeterinaria.java`
Contiene la lógica principal del programa, el menú interactivo y la coordinación entre la lista, la cola y la pila.

---

## Atributos de la entidad principal

La clase `MascotaAtencion` fue diseñada con atributos que permiten representar de forma clara la atención veterinaria.

Ejemplo de atributos:

- `codigoAtencion`
- `nombreMascota`
- `especie`
- `nombrePropietario`
- `estado`

Estos atributos permiten identificar la mascota, registrar información básica y controlar su estado dentro del sistema.

---

## Conceptos aplicados en el desarrollo

Durante esta actividad se aplicaron conceptos importantes de programación, entre ellos:

- Programación orientada a objetos
- Encapsulamiento
- Creación y uso de clases
- Constructores
- Métodos `get` y `set`
- Sobrescritura de métodos `toString()` y `equals()`
- Manipulación de nodos enlazados
- Recorridos sobre estructuras dinámicas
- Validaciones de entrada
- Manejo de errores
- Modularización del código
- Separación de responsabilidades por clase
- Control de versiones con Git y GitHub

---

## Requisitos cumplidos

Este proyecto fue desarrollado siguiendo las condiciones establecidas en la actividad:

- Uso obligatorio de **Lista**, **Cola** y **Pila**
- Implementación con **nodos enlazados**
- Desarrollo en **Java**
- Aplicación de un **caso funcional específico**
- Menú con las opciones obligatorias
- Clase principal con mínimo:
    - 4 atributos
    - constructor
    - getters
    - setters
    - `toString()`
    - `equals()`
- Uso de Git para evidenciar el proceso de construcción

---

## Evidencia de desarrollo

El repositorio incluye el avance progresivo del trabajo mediante commits descriptivos, con el fin de evidenciar el proceso real de construcción del sistema.

Se busca demostrar:
- evolución del código
- implementación gradual de funcionalidades
- uso correcto del control de versiones

---

## Ejemplo de uso del sistema

Un ejemplo del flujo del sistema sería:

1. Registrar una mascota con código `V001`
2. Registrar una mascota con código `V002`
3. Ambas quedan almacenadas en la lista general
4. Ambas quedan en la cola de pendientes
5. Se procesa `V001`
6. `V001` sale de la cola y pasa a la pila de historial
7. Si se deshace la operación, `V001` vuelve a la cola

