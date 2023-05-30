package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.dao.ICountryRepository;
import ra.model.Country;
import ra.model.Customer;
import ra.service.customer.ICustomerService;

import java.util.Optional;

@Controller
public class CustomerController {
@Autowired
    private ICustomerService customerService;
@Autowired
private ICountryRepository countryRepository;
@ModelAttribute("countries")
Iterable<Country> getCountry(Model model){
    return countryRepository.findAll();
}
@GetMapping("/")
    public String getAll(@RequestParam("sortBy") Optional<String> sortBy, Model model, Pageable pageable){
    Sort sort = null;
if (sortBy.isPresent()){
    switch (sortBy.get()){
        case "age-ASC":
            sort = Sort.by("age").ascending();
            break;
        case "age-DESC":
            sort = Sort.by("age").descending();
            break;
        case "name-ASC":
            sort = Sort.by("name").ascending();
            break;
        case "name-DESC":
            sort = Sort.by("name").descending();
            break;
        default:
            break;
    }
} else {
    sort = Sort.by("age").descending().and(Sort.by("name").descending());
}
    Page<Customer> list = customerService.findAll(pageable,sort);
    model.addAttribute("list",list);
  return "home";
}
@GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
    customerService.remove(id);
    return "redirect:/";
}
@GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
    Optional<Customer> customer = customerService.findById(id);
    return new ModelAndView("edit","customer",customer.get());
}
@PostMapping("update")
    public String update(@ModelAttribute("customer") Customer customer){
    customerService.save(customer);
    return "redirect:/";
}
@GetMapping("create")
    public ModelAndView create (){
    return new  ModelAndView("create","customer",new Customer());
}
@PostMapping("add")
    public String add(@ModelAttribute("customer") Customer customer){
    customerService.save(customer);
    return "redirect:/";
}
}
