package mv.dao;

import java.util.List;
import mv.domain.Asset_WareHouse;
import mv.domain.WareHouse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class WareHouseDao
{
  public WareHouseDao() {}
  
  @Transactional
  public WareHouse getWareHouse(String name, SessionFactory sesfac)
  {
    Session ses = sesfac.getCurrentSession();
    Criteria crit = ses.createCriteria(WareHouse.class);
    
    crit.add(Restrictions.eq("name", name));
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<WareHouse> warehouse = crit.list();
    
    if (warehouse.isEmpty()) {
      return null;
    }
    
    return (WareHouse)warehouse.get(0);
  }
  
  @Transactional
  public List<Asset_WareHouse> getWareHouseInventory(String name, SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    WareHouse wh = getWareHouse(name, sesfac);
    
    Criteria crit = ses.createCriteria(Asset_WareHouse.class);
    
    crit.add(Restrictions.eq("warehouse", wh));
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Asset_WareHouse> aw = crit.list();
    
    return aw;
  }
  
  @Transactional
  public List<WareHouse> getAllWareHouse(SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    Criteria crit = ses.createCriteria(WareHouse.class);
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    crit.addOrder(Order.asc("id"));
    List<WareHouse> warehouses = crit.list();
    ses.clear();
    
    if (warehouses.isEmpty()) {
      return null;
    }
    
    return warehouses;
  }
}