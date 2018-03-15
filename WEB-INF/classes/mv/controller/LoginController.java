package mv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mv.dao.Dao;
import mv.domain.Employee;
import mv.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
  @Autowired
  LoginService loginService;
  @Autowired
  Dao dao;
  
  public LoginController() {}
  
  @RequestMapping(value={"/trylogin"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String handleLogin(@javax.validation.Valid Employee employee, BindingResult bindingResult, HttpSession ses, HttpServletRequest request) throws Exception
  {
    if (!bindingResult.hasErrors())
    {
      Employee authenticatePerson = loginService.authenticate(employee.getUsername(), employee.getPassword());
      if (authenticatePerson != null) {
        ses.setAttribute("fullwh", dao.getAllAssets());
        ses.setAttribute("employee", authenticatePerson);
        ses.setAttribute("myErr", "");
        if (authenticatePerson.getRole().getRole_value().equalsIgnoreCase("manager")) {
          return "adminhome";
        }
        return "home";
      }
    }
    ses.setAttribute("myErr", "Username/Password not matching!");
    return "login";
  }
  
  @RequestMapping({"/goToLoginPage"})
  public String goToLogin(HttpServletRequest request, ModelMap modMap) throws Exception {
    request.getSession().setAttribute("employee", null);
    request.getSession().setAttribute("myErr", "");
    modMap.addAttribute("employee", new Employee());
    return "login";
  }
}