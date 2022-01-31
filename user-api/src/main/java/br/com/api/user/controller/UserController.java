package br.com.api.user.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.api.user.data.dto.UserRequestDTO;
import br.com.api.user.data.dto.UserResponseDTO;
import br.com.api.user.services.UserServices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServices service;

	@GetMapping
	@Cacheable(value = "getAll")
	public List<UserResponseDTO> getAll() {
		
		try{
			log.info("GETL ALL");
			return service.findAll();

		}catch(Exception e){
			
			log.error("getAll",e.getMessage());
			return null;
			// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
	}

	@GetMapping("/{id}")
	@CacheEvict(value = "getAll", allEntries = true)
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {

		try {

			var result = service.findById(id);
			return result != null ? ResponseEntity.ok(result)
					: ResponseEntity.notFound().build();

		} catch (Exception e) {

			log.error("findById", id + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "getAll", allEntries = true)
	public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserRequestDTO user,
			UriComponentsBuilder uriBuilder) {
		try {
			var result = service.create(user);
			URI uri = uriBuilder.path("/user/{id}").buildAndExpand(result.getId()).toUri();
			return ResponseEntity.created(uri).body(result);
		} catch (Exception e) {

			log.error("save", user.getName() + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "getAll", allEntries = true)
	public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,
			@RequestBody @Valid UserRequestDTO user) {
		try {

			var result = service.findById(id);

			if (result != null) {
				return ResponseEntity.ok(service.update(user, id));
			}
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			log.error("update", id + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "getAll", allEntries = true)
	public ResponseEntity<UserResponseDTO> delete(@PathVariable Long id) {

		try {
			var result = service.findById(id);
			if (result != null) {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}

		catch (Exception e) {
			log.error("delete", id + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}

	}
}
