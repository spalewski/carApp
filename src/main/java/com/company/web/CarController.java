package com.company.web;


import com.company.model.Car;
import com.company.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {

  private final CarRepository carRepository;

  @Autowired
  public CarController(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @GetMapping("/")
  public String root() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/access-denied")
  public String accessDenied() {
    return "/error/access-denied";
  }

  @GetMapping("signup")
  public String showSignUpForm(Car car) {
    return "user/add-car";
  }

  @GetMapping("/user")
  public String showUpdateForm(Model model) {
    model.addAttribute("cars", carRepository.findAll());
    return "user/index";
  }

  @PostMapping("add")
  public String addCar(@Valid Car car, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "user/add-car";
    }

    carRepository.save(car);
    return "redirect:user";
  }

  @GetMapping("edit/{id}")
  public String showUpdateForm(@PathVariable("id") long id, Model model) {
    Car car = carRepository.findOne(id);
    model.addAttribute("car", car);
    return "user/update-car";
  }

  @PostMapping("update/{id}")
  public String updateStudent(@PathVariable("id") long id, @Valid Car car, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      car.setId(id);
      return "update-car";
    }

    carRepository.save(car);
    model.addAttribute("cars", carRepository.findAll());
    return "user/index";
  }

  @GetMapping("delete/{id}")
  public String deleteStudent(@PathVariable("id") long id, Model model) {
    Car car = carRepository.findOne(id);
    carRepository.delete(car);
    model.addAttribute("cars", carRepository.findAll());
    return "user/index";
  }

}
