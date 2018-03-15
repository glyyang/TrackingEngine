package mv.service;

import mv.dao.Dao;
import mv.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private Dao dao;

    public Employee authenticate(String username, String password) {
        Employee emp = this.dao.validate(username);
        if (emp != null && password.equals(emp.getPassword())) {
            return emp;
        }
        return null;
    }
}