package br.com.api.order.controllher;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import br.com.api.order.data.dto.OrderRequestDTO;
import br.com.api.order.data.dto.OrderResponseDTO;
import br.com.api.order.data.model.Order;
import br.com.api.order.services.OrderServices;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServices service;
	
	@GetMapping	
	public List<OrderResponseDTO> getAll() {
		
		try{			

			var result =  service.findAll();
			return result;

		}catch(Exception e){
			return null;
			// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }		
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id) {

		try {

			var result = service.findById(id);
			return result != null ? ResponseEntity.ok(result)
					: ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping	
	public ResponseEntity<OrderResponseDTO> save(@RequestBody @Valid OrderRequestDTO order,
			UriComponentsBuilder uriBuilder) {
		try {
			var result = service.create(order);
			URI uri = uriBuilder.path("/order/{id}").buildAndExpand(result.getId()).toUri();
			return ResponseEntity.created(uri).body(result);
		} catch (Exception e) {

			//log.error("save", order.getName() + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")	
	public ResponseEntity<OrderResponseDTO> update(@PathVariable Long id,
			@RequestBody @Valid OrderRequestDTO order) {
		try {

			var result = service.findById(id);

			if (result != null) {
				return ResponseEntity.ok(service.update(order, id));
			}
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			//log.error("update", id + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<Order> delete(@PathVariable Long id) {

		try {
			var result = service.findById(id);
			if (result != null) {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}

		catch (Exception e) {
//			log.error("delete", id + " " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}	
}
