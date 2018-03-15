package mv.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mv.dao.Dao;
import mv.domain.Asset_WareHouse;
import mv.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewCurrentInventoryController
{
  @Autowired
  Dao dao;
  
  public ViewCurrentInventoryController() {}
  
  @RequestMapping(value={"/getCurrent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getCurrentReport(HttpServletRequest request)
  {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    List<Asset_WareHouse> myAL = dao.getCurrentReport(true);
    
    request.setAttribute("awList", myAL);
    request.setAttribute("pgName", "navbaradmin");
    
    return "info";
  }
}