package br.com.api.order.converter.mocks;
import br.com.api.order.data.dto.OrderResponseDTO;
import br.com.api.order.data.model.Order;

public class MockOrder {
	
	public Order mockEntity() {
    	return mockEntity(0);
    }
    
    public OrderResponseDTO mockVO() {
    	return mockVO(0);
    }
    
    
    private Order mockEntity(Integer number) {
    	Order order = new Order();
    	order.setItem_description("teste");    	
    	order.setItem_quantity(20);      	
        return order;
    }

    private OrderResponseDTO mockVO(Integer number) {
    	OrderResponseDTO  response = new OrderResponseDTO();    	    	
    	response.setItem_description("descrição");
    	response.setItem_quantity(10);    	
    	return response;
    }
}
