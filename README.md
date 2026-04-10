# EJERCICIO DE AUTOMATIZACION E2E

## Descripción

Este proyecto contiene la automatización de pruebas E2E utilizando **Serenity BDD con el patrón Screenplay**, validando el flujo completo de compra en la aplicación SauceDemo.

---

## Tecnologías utilizadas

* Java 17
* Gradle 7.6.1
* Serenity BDD
* Screenplay Pattern
* Selenium WebDriver
* Microsoft Edge WebDriver

---

## Requisitos

* JDK 17
* Gradle 7.6.1
* Edge WebDriver compatible

> Nota: Se utilizó Edge debido a un conflicto con Chrome relacionado a un popup de seguridad de contraseñas.

---

## Estructura del proyecto

```text
src
├── main
├── test
│   ├── java
│   │   ├── tasks
│   │   ├── questions
│   │   ├── interactions
│   │   ├── stepdefinitions
│   │   └── runners
│   └── resources
│       └── features
```

---

## Ejecución de pruebas

Ejecutar el siguiente comando:

```bash
gradle clean test
```

O ejecutar directamente el runner:

```text
PurchaseRunner.java
```

---

## Escenario automatizado

Se automatizó el flujo completo de compra:

* Login con usuario válido
* Agregar dos productos al carrito
* Visualizar carrito
* Completar formulario de compra
* Finalizar compra
* Validar mensaje: **"THANK YOU FOR YOUR ORDER"**

---

## Reporte

Serenity genera automáticamente el reporte en:

```text
target/site/serenity/index.html
```

---

## Buenas prácticas implementadas

* Uso del patrón **Screenplay**
* Separación de responsabilidades (Tasks, Questions)
