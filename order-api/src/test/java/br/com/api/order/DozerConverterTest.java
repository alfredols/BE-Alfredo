package br.com.api.order;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Assert;

import br.com.api.order.converter.DozerConverter;
import br.com.api.order.converter.mocks.MockOrder;

import br.com.api.order.data.dto.OrderResponseDTO;
import br.com.api.order.data.model.Order;

@SpringBootTest
class DozerConverterTest {

	MockOrder inputObject;
	
	@Before(value = "")
    public void setUp() {
        inputObject = new MockOrder();
    }
	
	@Test
    public void parseEntityToDTOTest() {
		OrderResponseDTO output = DozerConverter.parseObject(inputObject.mockEntity(), OrderResponseDTO.class);        
        Assert.assertEquals("teste", output.getItem_description());
        Assert.assertEquals("20", output.getItem_quantity());        
    }
	
	@Test
    public void parseVOToEntityTest() {
		Order output = DozerConverter.parseObject(inputObject.mockEntity(), Order.class);
		Assert.assertEquals("descriçãoe Test0", output.getItem_description());
        Assert.assertEquals("10", output.getItem_quantity());       
        
    }

}
