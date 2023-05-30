package ra.service.country;

import ra.model.Country;
import ra.service.IGenericService;

public interface ICountryService extends IGenericService<Country,Long> {
    Iterable<Country> findAll();
}
