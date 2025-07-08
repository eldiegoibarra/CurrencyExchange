# 🪙 Currency Exchange

Aplicación Java (Alura Latam Challange) para conversión de divisas en tiempo real usando [ExchangeRate-API](https://www.exchangerate-api.com/).

## 🚀 Características
- Conversión entre 4 divisas (USD, EUR, GBP, CLP)
- Tasas de cambio actualizadas
- Interfaz de línea de comandos intuitiva
- Manejo seguro de claves API

## 📦 Requisitos
- Java 17+
- Clave API de ExchangeRate-API

## 🔧 Configuración

### 1. Obtener clave API
Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) y obtén tu clave gratuita.
 
1. **Clona el repositorio:**  
   ```bash
   git clone https://github.com/tu-usuario/CurrencyExchange.git
### 2. Configurar entorno
Crea un archivo `.env` en la raíz del proyecto:
```bash
# Windows
echo EXCHANGE_RATE_API_KEY=tu_clave_aqui > .env

# Linux/Mac
touch .env
echo "EXCHANGE_RATE_API_KEY=tu_clave_aqui" >> .env 
```

**Configura las variables de entorno:**

- Copia `.env.example` a `.env`:
```
cp .env.example .env
``` 
- Edita `.env` y agrega tu API Key:

```
EXCHANGE_RATE_API_KEY=tu_api_key_aquí 
```

- Ejecuta la aplicacion:
```
cd src/
javac Main.java && java Main
```

## 🖥 Uso

El programa muestra un menú con opciones para convertir:

- USD ↔ EUR
- USD ↔ GBP
- USD ↔ CLP (Peso chileno)

## 📄 Estructura del Proyecto

```CurrencyExchange/
├── src/
│   ├── Main.java                 # Punto de entrada
│   ├── CurrencyService.java      # Cliente de la API
│   ├── CurrencyConverter.java    # Lógica de conversión
│   └── ...                       # Otros archivos Java
├── .env.example                  # Plantilla para variables de entorno
└── README.md                     # Este archivo
```

## 📜 Licencia 

Este proyecto fue desarrollado como parte del curso Alura LATAM por Diego Ibarra-Asiain. **Julio 2025**