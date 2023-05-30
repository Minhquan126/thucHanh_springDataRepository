package ra.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.Customer;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}
