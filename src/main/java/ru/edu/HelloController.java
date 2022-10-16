package ru.edu;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/example")
public class HelloController {

  private UsersCatalog usersCatalog;

  @Autowired // DI через сеттер
  public void setUsersCatalog(UsersCatalog usersCatalog) {
    this.usersCatalog = usersCatalog;
  }

  @GetMapping("info")
  public ModelAndView info() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/hello.jsp");
    modelAndView.addObject("message", "Hello, friends! ");
    return modelAndView;
  }

  @GetMapping("users")
  public ModelAndView allUsers() {
    Collection<UserInfo> users = usersCatalog.getAll();

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/users.jsp");
    modelAndView.addObject("userList", users);
    return modelAndView;
  }

}
