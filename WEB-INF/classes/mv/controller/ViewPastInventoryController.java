package mv.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mv.dao.Dao;
import mv.domain.Employee;
import mv.domain.View_History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewPastInventoryController {
    @Autowired
    Dao dao;

    @RequestMapping(value={"/toPast/{viewDate}"}, method={RequestMethod.GET})
    public String getReport(@PathVariable(value="viewDate") String myDate, HttpServletRequest request) throws ParseException {
        if (this.dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null) {
            return "login";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(myDate);
        List awList = this.dao.getOldReport(date);
        request.setAttribute("awList", (Object)awList);
        request.setAttribute("pgName", (Object)"navbaradmin");
        return "info";
    }

    @RequestMapping(value={"/toPast"}, method={RequestMethod.GET})
    public String toPastReports(HttpServletRequest request) {
        if (this.dao.validate(((Employee)request.getSession().getAttribute("employee")).getUsername()) == null) {
            return "login";
        }
        List vhs = this.dao.getAllHistory();
        Collections.sort(vhs, new Comparator<View_History>(){

            @Override
            public int compare(View_History vh1, View_History vh2) {
                return (int)(vh1.getId() - vh2.getId());
            }
        });
        request.setAttribute("vhs", (Object)vhs);
        return "pastList";
    }

}