package com.arquitecturajava.webcliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aquitecturajava.webspring.dtos.PersonaDto;

@RestController
public class ClienteRestPersona {
	@RequestMapping("/personascliente")
	public List<PersonaDto> listPersonas() {
		RestTemplate plantilla = new RestTemplate();
		ResponseEntity<PersonaDto[]> lista = plantilla.getForEntity("http://localhost:8083/personas", PersonaDto[].class);
		PersonaDto[] nuevaLista = lista.getBody();
		return Arrays.asList(nuevaLista);
	}

}
