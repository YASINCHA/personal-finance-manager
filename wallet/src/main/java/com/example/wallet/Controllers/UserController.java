package com.example.wallet.Controllers;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.wallet.Dto.OperationDTO;
import com.example.wallet.Dto.UserDto;
import com.example.wallet.Entities.Operation;
import com.example.wallet.Entities.User;
import com.example.wallet.Services.OperationServiceImpl;
import com.example.wallet.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/wallet") 
public class UserController {
@Autowired
 

 private UserService userService;

 public UserController(UserService userService) {
  this.userService = userService;
 }

@GetMapping("/home")
public String home(Model model, HttpSession session) {
    String username = (String) session.getAttribute("username");

    if (username == null) {
        // Redirect to login page if user is not authenticated
        return "redirect:/wallet/login";
    }

    // Assuming you have a custom User object and UserService
    User user = userService.findByUsername(username);
    model.addAttribute("userdetail", user);

    return "home";
}


 @GetMapping("/login")
 public String login(Model model, UserDto userDto) {

  model.addAttribute("user", userDto);
  return "login";
 }



 @PostMapping("/login")
 public String login(@ModelAttribute("user") UserDto userDto, HttpSession session, Model model) {
     // Add your login logic here
     User user = userService.findByUsername(userDto.getUsername());
     if (user != null && user.getPassword().equals(userDto.getPassword())) {
         session.setAttribute("username", userDto.getUsername());
         return "redirect:/wallet/home";
     }

     model.addAttribute("error", "Invalid username or password");
     return "login";
 } 

 @GetMapping("/register")
 public String register(Model model, UserDto userDto) {
  model.addAttribute("user", userDto);
  return "register";
 }

 @PostMapping("/register")
 public String registerSava(@ModelAttribute("user") UserDto userDto, Model model) {
  User user = userService.findByUsername(userDto.getUsername());
  if (user != null) {
   model.addAttribute("Userexist", user);
   return "register";
  }
  userService.save(userDto);
  return "redirect:/wallet/register?success";
 }


 @GetMapping("/logout")
 public String logoutSuccess() {
     return "login";
 }

     @Autowired
    private OperationServiceImpl operationService;

    @GetMapping("/operations")
    public String getAllOperations(Model model) {
        List<OperationDTO> operationDTOs = operationService.getAllOperations2();

        // Define a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format dates in OperationDTO
        List<OperationDTO> formattedOperationDTOs = operationDTOs.stream()
            .map(dto -> new OperationDTO(
                dto.getOperationId(),
                dto.getOperationType(),
                dto.getCategory(),
                dto.getAmount(),
                dto.getCreatedAt().formatted(formatter), // Format date
                dto.getUpdatedAt().formatted(formatter), // Format date
                dto.getAmountSigned(),
                dto.getAmountCredit(),
                dto.getAmountDebit()
            ))
            .collect(Collectors.toList());

        model.addAttribute("operations", formattedOperationDTOs);

        return "operations"; // Thymeleaf template name
    }
    
     



    @GetMapping("/create")
    public String createOperationForm() {
        return "createOperation";  // Return view name for create form
    }

    @PostMapping("/create")
    public String createOperation(@RequestParam("operationType") String operationType,
                                  @RequestParam("category") long category,
                                  @RequestParam("amount") Double amount) {
        Operation operation = new Operation(null, operationType, category, amount);
        operationService.saveOperation(operation);
        return "redirect:/wallet/operations";
    }

    @GetMapping("/modify/{id}")
    public String modifyOperationForm(@PathVariable Long id, Model model) {
        Operation operation = operationService.getOperationById(id);
        model.addAttribute("operation", operation);
        return "modifyOperation";  // Return view name for modify form
    }

    @PostMapping("/modify/{id}")
    public String modifyOperation(@RequestParam("id") Long id,
                                  @RequestParam("operationType") String operationType,
                                  @RequestParam("category") long category,
                                  @RequestParam("amount") Double amount) {
        Operation operation = new Operation(id, operationType, category, amount);
        operationService.updateOperation(id, operation);
        return "redirect:/wallet/operations";
    }

    @PostMapping("/delete/{id}")
    public String deleteOperation(@PathVariable Long id) {
        operationService.deleteOperation(id);
        return "redirect:/wallet/operations";
    }

}
