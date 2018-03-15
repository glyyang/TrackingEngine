package mv.dao;

import java.util.List;
import mv.domain.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDao
{
  public EmployeeDao() {}
  
  @org.springframework.transaction.annotation.Transactional
  public Employee getEmployee(String username, SessionFactory sesfac)
  {
    Session ses = sesfac.getCurrentSession();
    Criteria crit = ses.createCriteria(Employee.class);
    crit.add(org.hibernate.criterion.Restrictions.eq("username", username));
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    
    List<Employee> emp = crit.list();
    
    if (emp.isEmpty()) {
      return null;
    }
    return (Employee)emp.get(0);
  }
}