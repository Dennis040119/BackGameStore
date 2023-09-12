package com.example.demo.service.mtnm;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;




@Service
public class StorageServiceImpl implements StorageService {
	
	private Path rootLocation;
	
	@Value("${media.location}")
	private String mediaLocation;

	@Override
	@jakarta.annotation.PostConstruct
	public void init() throws IOException {
		//Inicializamos la ruta raiz de almacenamiento
				
		
	}

	@Override
	public String store(MultipartFile file, String id,String tipofile) {
		try {
			
			//Verificamos si el archivo no está vacío
			if(file.isEmpty()) {
				throw new RuntimeException ("No se puede almacenar un archivo vacío");
			}
			
			//habitacionpricipal948484.jpg
			//1-Vamos a conseguir la parte del tipo del archivo. Ejemplo: ".jpg"
			
			//Creamos las diferentes carpetas
			rootLocation = Paths.get(mediaLocation);
			Files.createDirectories(rootLocation);
			
			Path pathDir = rootLocation.resolve(tipofile);
	        Files.createDirectories(pathDir);
			
	        ///////
			String fileContentType = file.getContentType();//"(image/jpeg)" "(image/jpg)"
			String tipo = "." + fileContentType.substring(fileContentType.lastIndexOf("/")+1); //".jpeg"
			
			tipo=".jpg";
			
			
			//2-Conseguimos el nombre del archivo
			String filename = String.valueOf(Calendar.getInstance().getTimeInMillis());
			filename = filename.concat(tipo);//95202025526458484884.jpg
			String nombre = id.concat(filename);
			//3-Añadimos el string nombre del archivo a la ruta prefijada de destino 
			//de almacenamiento
			Path destinationFile = pathDir.resolve(Paths.get(nombre));
			
			//4-Movemos el archivo FÍSICAMENTE a su destino final
			
			//Esto es un try con recursos. Para utilizar un try con recursos
			//es necesario que las clases utilizadas dentro del paréntesis
			//implementen la interfaz "Autocloseable"
			try(InputStream inputStream = file.getInputStream()){
				
				//Si existe un archivo con el mismo nombre se reemplazará 
				//Lo vamos a almacenar utilizando la clase Files a partir de un inputStream
				//que maneja el archivo físico REAL
				Files.copy(inputStream,destinationFile,StandardCopyOption.REPLACE_EXISTING);
			}
			
			//5-Creamos la notación en la BBDD
			//////////////////////////////////////////////////////////////////
			//PREFIERO SUBIR PRIMERO LA IMAGEN Y POSTERIORMENTE CREAR LA
			//IMAGEN EN LA BBDD PORQUE SI LA IMAGEN NO SE CREA (ALGÚN ERROR)
			//SÓLO TENDRÉ COMO PARTE NEGATIVA UNA IMAGEN "FISICA" NO VINCULADA
			//DE LA OTRA FORMA TENDRÍA UN REGISTRO ERRÓNEO EN LA BBDD.
			//////////////////////////////////////////////////////////////////
			
			
			
			///////////////////////////////////////////////////////////////////
			
			return nombre;
			
			///////////////////////////////////////////////////////////////////
			
	}catch(IOException e) {
		
		throw new RuntimeException("Fallo al almacenar el archivo");
	}
		
	}

	@Override
	public Resource loadAsResource(String filename,String dirFile) {
		//Conseguimos el path REAL del archivo
				
				
				
				try {
					
					//Creamos las diferentes carpetas
					rootLocation = Paths.get(mediaLocation);
					Files.createDirectories(rootLocation);
					
					Path pathDir = rootLocation.resolve(dirFile);
			        Files.createDirectories(pathDir);
			        
			        Path file = pathDir.resolve(Paths.get(filename));
					
			        ///////
				
					Resource resource = new UrlResource(file.toUri());
					
					Resource resourceExtra=new UrlResource(file.toUri());
					
					if(resource.exists() || resource.isReadable()) {
						return resource;
					}else {
						return resourceExtra;
						//throw new RuntimeException("No se puede leer el archivo 1 " + filename);
					}
					
				} catch (MalformedURLException e) {
					throw new RuntimeException("No se puede leer el archivo 2 " + filename);
				}
				catch (IOException e) {
					throw new RuntimeException("Directorio no encontrado: " + dirFile);
				}
	}

	@Override
	public boolean deleteFile(String filename, String dirFile)throws IOException {
		  Path filePath = Paths.get(mediaLocation, dirFile, filename);
	       return Files.deleteIfExists(filePath);
	}

}
