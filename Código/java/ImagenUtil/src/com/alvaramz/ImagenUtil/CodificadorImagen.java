
package com.alvaramz.ImagenUtil;

import java.util.Base64;

/**
 * Propociona métodos para codificar una imagen.
 * @author Ing. Adrián Alvarado Ramírez.
 */
public class CodificadorImagen {
    
    /**
     * Convierte una imagen almacenada en un arreglo de bytes a una hilera de
     * caracteres en base64. Utiliza el método de codificacion provisto en el 
     * API de java.
     * @param imagen Contenido de la imagen, almacenado en un arreglo de bytes.
     * @return String con la representación de la imagen en Base64.
     */
    public String imagenABase64(byte[] imagen){
        return Base64.getEncoder().encodeToString(imagen);
    }
    
    /**
     * Convierte una imagen almacenada en un arreglo de bytes a una representación
     * que se puede mostrar en una etiqueta html img. Para esto, codifica la imagen
     * en Base64, utilizando el método imagenABase64.
     * @param imagen Contenido de la imagen.
     * @param nombre El nombre del archivo, se utiliza para extraer la extensión.
     * @return 
     */
    public String imagenAHTMLData(byte[] imagen, String nombre){
       String imagenEnBase64 = imagenABase64(imagen);
       String extension = obtenerExtensionArchivo(nombre);
       String HTMLData =  String.format("data:image/%s;base64,%s", extension, imagenEnBase64);
       return HTMLData;
    }
    
    /**
     * Obtiene la extensión de un archivo a partir del nombre.
     * @param nombre El nombre del archivo.
     * @return 
     */
    private String obtenerExtensionArchivo(String nombre){
        int indiceUltimoPunto = nombre.lastIndexOf('.');
        String extension = nombre.substring(indiceUltimoPunto);
        return extension;
    }
    
}
