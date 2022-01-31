package br.com.api.order.controllher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.api.order.data.dto.OrderResponseDTO;
import br.com.api.order.data.dto.UserDTO;
import br.com.api.order.services.OrderServices;

@RestController
@RequestMapping("/userorder")
public class UserOrderControllher {
	
	    @Autowired
	    private OrderServices service;
	
		@GetMapping("/{id}")
	    public ResponseEntity<OrderResponseDTO> findById(@PathVariable Long id) {

			var restTemplate = new RestTemplate();

			var request  = restTemplate.getForObject(
	                   "http://user-api:8080/user/" + id, UserDTO.class);
			
			var userOrder = service.findById(id);
						
			if(request != null) userOrder.setUser_name(request.getName());
			
			return userOrder != null ? ResponseEntity.ok(userOrder)
					: ResponseEntity.notFound().build();
	    }		
}
