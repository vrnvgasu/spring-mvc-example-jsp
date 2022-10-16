package ru.edu;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users", consumes = MediaType.ALL_VALUE)
public class UsersRestController {

  private final UsersCatalog usersCatalog;

  @Autowired // DI через конструктор
  public UsersRestController(UsersCatalog usersCatalog) {
    this.usersCatalog = usersCatalog;
  }

  // возвращаем данные в формате json
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
  public Collection<UserInfo> getAll() {
    return usersCatalog.getAll();
  }

  @PostMapping
  // RequestBody - десериализует тело json запроса в UserInfo
  public UserInfo create(@RequestBody UserInfo userInfo) {
    return usersCatalog.create(userInfo);
  }

  @DeleteMapping("/{id}")
  public UserInfo delete(@PathVariable String id) {
    return usersCatalog.deleteById(id);
  }

}
