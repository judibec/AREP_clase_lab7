# AREP_clase_lab7

Creacion de proyecto en el cual se realice una conexion segura entre 2 APIs generando certificados, para que el browser las pueda consumir mediante HTTPS

## Iniciando

### Prerequisitos

* Git: controlador de versiones y administrador de repositorio
* Java: Ambiente de desarrollo
* Maven: Administrador del ciclo de vida del proyecto
* AWS: Servicio de nube

### Funcionalidad 

Podemos ver el funcionamiento de los servidores corriendo por AWS, si realizamos la peticion a uno de ellos nos responde el otro, y asi mismo para el otro, cada servicio esta corriendo de manera segura por medio de HTTPS

![image](https://user-images.githubusercontent.com/90010884/226952203-adb7d08e-eda9-41c1-8ad4-3fd67cf3a950.png)
![image](https://user-images.githubusercontent.com/90010884/226952235-2d341b9e-297d-4c7a-a434-1dad72f054c2.png)
![image](https://user-images.githubusercontent.com/90010884/226952262-ecfdfe6e-e03f-445f-b6e5-40a4e4dbf5c4.png)
![image](https://user-images.githubusercontent.com/90010884/226952283-c45e4eb0-3ae2-4f62-9f59-1d6a1265ce6e.png)

Podemos ver las llaves generadas, ya que para cada API necesita un certificado diferente

![image](https://user-images.githubusercontent.com/90010884/226952319-12819b0d-e444-4083-b8a2-e925a002e92b.png)

Y por ultimo vemos los DNS de la maquina para ver que realmente son los servidores que se estan corriendo
![image](https://user-images.githubusercontent.com/90010884/226952346-6169887c-8f15-49b4-9e5e-0ad9c4fd0064.png)
![image](https://user-images.githubusercontent.com/90010884/226952374-8a1a8bac-a292-44c7-a7f4-0fcc5667ca55.png)

```
keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650
```

Con este comando podemos generar los certificados para cada API, cambiando restectivamente el nombre de la keystore

## Video



## Construido Con

* [Maven](https://maven.apache.org/) - Administrador de dependencias

## Version

Version 1.0

## Autores

* **Juan Diego Becerra Peña**: [judibec](https://github.com/judibec)

## Arquitectura

La arquitectura usada es la que se muestra en la imagen, por medio de SSL se realizan las peticiones para cada API y asi la lee el browser
![image](https://user-images.githubusercontent.com/90010884/226968254-086e72ef-a7dc-48f6-b828-fe0edfc203d6.png)
