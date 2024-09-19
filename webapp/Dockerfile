# Utiliza una imagen base de Node.js
FROM node:18-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia los archivos del proyecto
COPY package*.json ./

# Instala las dependencias
RUN npm install

# Copia el resto del código
COPY . .

# Construye la aplicación
RUN npm run build

# Expone el puerto en el que correrá la aplicación frontend
EXPOSE 3000

# Comando para ejecutar la aplicación
CMD ["npm", "start"]
