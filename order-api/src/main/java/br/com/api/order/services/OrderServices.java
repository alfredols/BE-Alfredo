package br.com.api.order.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.order.converter.DozerConverter;
import br.com.api.order.data.dto.OrderRequestDTO;
import br.com.api.order.data.dto.OrderResponseDTO;
import br.com.api.order.data.model.Order;
import br.com.api.order.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepository repository;	
	public List<OrderResponseDTO> findAll() {			
		return DozerConverter.parseListObjects(repository.findAll(),OrderResponseDTO.class);		
	}
	
	public OrderResponseDTO findById(Long id) {
		
		var result = repository.findById(id);		
		return result.isPresent() ? DozerConverter.parseObject(result.get(), OrderResponseDTO.class) : null;
	}

	public OrderResponseDTO create(OrderRequestDTO order) {

		var entity = DozerConverter.parseObject(order, Order.class);		
		entity.setCreated_at(new Date());
		var result = repository.save(entity);
		return DozerConverter.parseObject(result, OrderResponseDTO.class);				
	}

	public OrderResponseDTO update(OrderRequestDTO order, long id) {	
		var entity = DozerConverter.parseObject(order, Order.class);
		entity.setId(id);
		entity.setUpdated_at(new Date());
		return DozerConverter.parseObject(repository.save(entity), OrderResponseDTO.class);
	}
	
	public void delete(Long id){						
		repository.deleteById(id);
	}	
	
}
