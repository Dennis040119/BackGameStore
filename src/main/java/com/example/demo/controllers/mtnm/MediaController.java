package com.example.demo.controllers.mtnm;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.service.mtnm.StorageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/media")
@CrossOrigin(origins= {"http://localhost:4200"})
public class MediaController {
	
	private final StorageService storageService;
	private final javax.servlet.http.HttpServletRequest request;
	
	//ESTE MÉTODO SIRVE PARA SUBIR ARCHIVOS DE CUALQUIER TIPO Y RETORNA EN UN MAP
		//LA URL FINAL DEL ARCHIVO SUBIDO PARA SU POSTERIOR CONSULTA
		//EN @REQUESTPARAM CAPTURAMOS EL ARCHIVO CON EL NAME "file" IMPORTANTE!!!!!!!
		
		@PostMapping("/upload/{id}/{tipofile}")
		public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile, @PathVariable String id,
				@PathVariable String tipofile){
			
			//ALMACENAMOS EL ARCHIVO UTILIZANDO EL SERVICIO DE ALMACENAMIENTO...
			String path = storageService.store(multipartFile,id,tipofile);//nombre del archivo
			
			//NOS DEVUELVE LA URL DEL ARCHIVO
			String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
			
			String url = ServletUriComponentsBuilder
			.fromHttpUrl(host) //Añadimos el host
			.path("/media/file/") //Añadimos la carpeta en la que se encuentra
			.path(path) //Añadimos el nombre del archivo
			.toUriString();
			
			return Map.of("url",path);
			
			
		}
		
		
		@CrossOrigin(origins= {"http://localhost:4200"})
		@GetMapping("/file/{filename:.+}/{dirFile}") 
		public ResponseEntity<Resource> getFile(@PathVariable String filename,@PathVariable String dirFile) throws IOException{
			
			Resource file = storageService.loadAsResource(filename,dirFile);
			
			String contentType = Files.probeContentType(file.getFile().toPath());
			
			return ResponseEntity
					.ok()
					.header(HttpHeaders.CONTENT_TYPE,contentType)
					.body(file);
			
		}

}
