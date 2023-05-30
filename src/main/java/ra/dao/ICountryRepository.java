package ra.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.Country;



@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country,Long> {
}
