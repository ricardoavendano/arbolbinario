# arbolbinario
Ricardo Avendaño Casas
Ing. Sistemas

Para correr el proyecto tener en cuenta:
1. Aplicacion realizada con Spring boot con IDE Spring Tool Suite 4
2. Uso de apache Maven 3.6.1
3. Java 8
4. Descargue el proyecto en su ordenador
  a) git clone https://github.com/ricardoavendano/arbolbinario.git
5. Para ejecutar el proyecto, ubicarse en la carpeta donde clono el proyecto, ejecutar
  a) mvn clean install (descarga las dependencias necesarias para que el proyecto funcione)
6. Si usa el IDE Spring Tool Suite 4, 
  a) ubicarse en la parte de debug/run
  b) clic en debug/run configurations
  c) elegir Spring Boot App, 
  d) clic derecho, new configuration
  e) dar nombre
  f) project "arbolbinario"
  g) main type com.arbolbinario.ArbolbinarioApplication
  h) clic en apply
  i) clic debug/run
7. Una vez despliegue puede consumir los servicios
  a) GET: http://localhost:8080/arbol/api/ancestro/buscar/{nodo1}/{nodo2}
  b) POST: http://localhost:8080/arbol/api/ancestro/crear/arbol
    body ejemplo 
    {
      "listNode":[ 67, 39, 76, 28, 44, 74, 85, 29, 83, 87 ]
    }
  c). Swagger (Con esta dependencia se pueden consumir los servicios de una forma mas amigable)
  http://localhost:8080/arbol/swagger-ui.html
  d) puede hacer uso de postman o soapUI si lo requiere
  Nota: La aplicacion valida que primero se agregue un arbol antes de consultar el ancestro comun mas cercano 
 
   
