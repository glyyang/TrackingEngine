package mv.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mv.dao.Dao;
import mv.domain.Asset_WareHouse;
import mv.domain.Employee;
import mv.domain.Record;
import mv.domain.WareHouse;
import mv.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController
{
  @Autowired
  Dao dao;
  @Autowired
  ReportService repServ;
  
  public ReportController() {}
  
  @RequestMapping(value={"/createDelivery"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String createDeliveryReport(HttpServletRequest request)
  {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    Employee user = (Employee)request.getSession().getAttribute("employee");
    WareHouse warehouseIn = user.getWarehouse();
    String destination = request.getParameter("destination");
    
    List<String> assetNames = Arrays.asList(request.getParameterValues("assets"));
    List<String> quantities = Arrays.asList(request.getParameterValues("quantities"));
    
    Record myRec = repServ.generateReport(true, quantities, assetNames, warehouseIn, null, destination, user);
    if (myRec == null) {
      request.setAttribute("myErr", "Unable to generate report, invalid inputs");
      return "delivery";
    }
    repServ.subRecords(myRec);
    request.setAttribute("rec", myRec);
    return "result";
  }
  
  @RequestMapping(value={"/createRelocation"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String createRelocate(HttpServletRequest request) {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    Employee user = (Employee)request.getSession().getAttribute("employee");
    WareHouse warehouseIn = user.getWarehouse();
    List<WareHouse> whl = dao.getAllWareHouse();
    int index = -1;
    for (WareHouse wh : whl) {
      if (wh.getName().equals(((Employee)request.getSession().getAttribute("employee")).getWarehouse().getName())) {
        index = whl.indexOf(wh);
      }
    }
    whl.remove(index);
    request.setAttribute("relo", whl);
    WareHouse warehouseOut = dao.getWareHouse(request.getParameter("warehouse"));
    if (warehouseOut == null) {
      request.setAttribute("myErr", "Invalid warehouse");
      return "relocate";
    }
    Object assetNames = Arrays.asList(request.getParameterValues("assets"));
    List<String> quantities = Arrays.asList(request.getParameterValues("quantities"));
    
    Record myRec = repServ.generateReport(false, quantities, (List)assetNames, warehouseIn, warehouseOut, null, user);
    if (myRec == null) {
      request.setAttribute("myErr", "Unable to generate report, invalid asset quantity inputs");
      return "relocate";
    }
    repServ.subRecords(myRec);
    request.setAttribute("rec", myRec);
    return "result";
  }
  
  @RequestMapping(value={"/createReceive"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String createReceive(HttpServletRequest request) {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    Employee user = (Employee)request.getSession().getAttribute("employee");
    request.setAttribute("rec", dao.getUncommitedRecords(user));
    return "receiving";
  }
  
  @RequestMapping(value={"/commitReceive"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String commitReceive(HttpServletRequest request) {
    if ((Employee)request.getSession().getAttribute("employee") == null)
      return "login";
    try {
      String[] ids = request.getParameterValues("ids");
      
      List<Long> idL = new java.util.ArrayList();
      for (String str : ids) {
        idL.add(Long.valueOf(Long.parseLong(str)));
      }
      
      repServ.commitChosenRecords(idL);
    }
    finally {}
    return "home";
  }
  
  @RequestMapping(value={"/viewWH"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getWareHouseInventory(HttpServletRequest request)
  {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    Employee user = (Employee)request.getSession().getAttribute("employee");
    
    List<Asset_WareHouse> awList = dao.getWareHouseReport(user);
    request.setAttribute("awList", awList);
    request.setAttribute("pgName", "navbar");
    return "info";
  }
  
  @RequestMapping(value={"/toDelivery"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String toDelivery(HttpServletRequest request) {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    return "delivery";
  }
  
  @RequestMapping(value={"/toRelocation"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String toRelocate(HttpServletRequest request) {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    List<WareHouse> whl = dao.getAllWareHouse();
    int index = -1;
    for (WareHouse wh : whl) {
      if (wh.getName().equals(((Employee)request.getSession().getAttribute("employee")).getWarehouse().getName())) {
        index = whl.indexOf(wh);
      }
    }
    System.out.println(index);
    whl.remove(index);
    request.setAttribute("relo", whl);
    return "relocate";
  }
  
  @RequestMapping(value={"/goHome"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String toHome(HttpServletRequest request) {
    if (dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null)
      return "login";
    if (((Employee)request.getSession().getAttribute("employee")).getRole().getRole_value().equals("manager"))
      return "adminhome";
    return "home";
  }
}