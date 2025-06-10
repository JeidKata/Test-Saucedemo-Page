# Proyecto de Automatización de Pruebas: SauceDemo 🧪

Este repositorio contiene un framework de automatización de pruebas web construido con Selenium WebDriver, Java y TestNG, siguiendo el patrón de diseño Page Object Model (POM). El objetivo principal es automatizar y validar funcionalidades clave de la aplicación web de demostración SauceDemo.

## 🌟 Tecnologías Utilizadas
**Lenguaje de Programación:** Java 11+

**Automatización Web:** Selenium WebDriver

**Framework de Pruebas:** TestNG

**Gestor de Dependencias:** Maven

**Gestión de Drivers:** WebDriverManager

**Logging:** Apache Log4j2

## 📂 Estructura del Proyecto (Page Object Model)
El proyecto sigue una estructura limpia y modular basada en el patrón Page Object Model (POM) para mejorar la reusabilidad, mantenibilidad y legibilidad del código.

```
selenium-saucedemo
├── .gitignore                      // Archivos y carpetas a ignorar por Git
├── pom.xml                         // Configuración del proyecto Maven y dependencias
└── src
    ├── main
    └── test
        └── java
        │    └── com
        │        └── saucedemo
        │            ├── base                    // Clases base para la configuración del navegador y pre-condiciones
        │            │   └── BaseTest.java
        │            ├── data                    // Clases para la gestión de datos de prueba
        │            │   └── TestData.java
        │            ├── listeners               // Clases de TestNG Listeners para monitoreo y reporte de pruebas
        │            │   └── CustomTestListener.java
        │            ├── pages                   // Clases de Page Objects que modelan las páginas de la UI
        │            │   ├── CartPage.java
        │            │   ├── CheckoutCompletePage.java
        │            │   ├── CheckoutInformationPage.java
        │            │   ├── CheckoutOverviewPage.java
        │            │   ├── LoginPage.java
        │            │   └── ProductsPage.java
        │            └── tests                   // Clases que contienen los métodos de prueba (@Test)
        │                ├── LogoutTest.java
        │                ├── PurchaseProductTest.java
        │                └── RemoveFromCartTest.java
        └── resources
                └── log4j.properties
```

## 🛠️ Configuración del Entorno
Para configurar y ejecutar este proyecto en tu máquina, sigue los siguientes pasos:

**Clonar el Repositorio:**
git clone <URL_DEL_REPOSITORIO>

cd selenium-saucedemo

**Requisitos Previos:**
Java Development Kit (JDK) 11 o superior instalado.

Maven instalado (generalmente viene con IDEs como IntelliJ IDEA o Eclipse).

Un IDE compatible con Maven (IntelliJ IDEA, Eclipse).

**Importar el Proyecto en tu IDE:**

Abre tu IDE y selecciona "Import Project" o "Open Project".

Navega a la carpeta selenium-saucedemo y selecciona el archivo pom.xml.

El IDE debería detectar automáticamente que es un proyecto Maven y descargar todas las dependencias.

## 🚀 Ejecución de las Pruebas
Puedes ejecutar las pruebas de varias maneras:

**Desde tu IDE:**

Haz clic derecho en cualquier clase de prueba individual (por ejemplo, PurchaseProductTest.java) y selecciona "Run 'TestName'".

Haz clic derecho en el archivo testng.xml y selecciona "Run 'testng.xml'".

**Desde la Línea de Comandos (Maven):**

Abre una terminal en la raíz del proyecto (selenium-saucedemo).

**Ejecuta el siguiente comando:**

mvn clean test

Esto limpiará el proyecto, compilará el código y ejecutará todas las pruebas definidas en el pom.xml (o en un testng.xml si está configurado en el pom.xml).

## 🧪 Escenarios de Prueba Implementados
El framework de automatización actualmente cubre los siguientes escenarios clave en la aplicación SauceDemo:

__Comprar un Producto:__

Selecciona un producto al azar de la página de productos.

Lo añade al carrito de compras.

Procede al checkout y rellena los datos personales.

Finaliza la compra.

Verifica que la página de confirmación "Gracias por tu compra" se muestra correctamente.

__Eliminar Elementos del Carrito:__

Añade tres productos específicos al carrito de compras.

Navega a la página del carrito.

Elimina los tres productos del carrito.

Verifica que el carrito de compras está completamente vacío.


__Cerrar Sesión:__

Después de iniciar sesión, abre el menú lateral.

Hace clic en el enlace de "Logout".

Verifica que el usuario es redirigido correctamente a la página de inicio de sesión.
