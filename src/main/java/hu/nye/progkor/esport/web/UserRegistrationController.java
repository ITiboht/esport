package hu.nye.progkor.esport.web;

import hu.nye.progkor.esport.service.UserService;
import hu.nye.progkor.esport.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class UserRegistrationController {

  private UserService userService;

  public UserRegistrationController(UserService userService) {
    this.userService = userService;
  }

  @ModelAttribute("user")
  public UserRegistrationDto userRegistrationDto() {
    return new UserRegistrationDto();
  }

  @GetMapping
  public String showSignupForm() {
    return "signup";
  }

  @PostMapping
  public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
    userService.save(registrationDto);
    return "redirect:/signup?success";
  }
}
