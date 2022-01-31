package br.com.api.order.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.order.data.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {	

}
