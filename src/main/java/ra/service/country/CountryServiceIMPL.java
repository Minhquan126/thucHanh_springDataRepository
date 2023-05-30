package ra.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.dao.ICountryRepository;
import ra.model.Country;

import java.util.Optional;
@Service

public class CountryServiceIMPL implements ICountryService{
    @Autowired
    private ICountryRepository countryRepository;
    @Override
    public Page<Country> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(),3,sort);
        return countryRepository.findAll(pageable);
    }

    @Override
    public Optional<Country> findById(Long aLong) {
        return countryRepository.findById(aLong);
    }

    @Override
    public void save(Country country) {
countryRepository.save(country);
    }

    @Override
    public void remove(Long aLong) {
countryRepository.deleteById(aLong);
    }

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }
}
