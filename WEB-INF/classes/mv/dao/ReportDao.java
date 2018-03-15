package mv.dao;

import java.util.List;
import mv.domain.Asset_WareHouse;
import mv.domain.Record;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class ReportDao
{
  public ReportDao() {}
  
  @Transactional
  public List<Asset_WareHouse> getCurrentReport(SessionFactory sesfac)
  {
    Session ses = sesfac.getCurrentSession();
    Criteria crits = ses.createCriteria(Asset_WareHouse.class);
    crits.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Asset_WareHouse> awlist = crits.list();
    
    return awlist;
  }
  
  @Transactional
  public List<Asset_WareHouse> getReport(SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    Criteria crits = ses.createCriteria(Asset_WareHouse.class);
    crits.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    
    List<Asset_WareHouse> awlist = crits.list();
    
    ses.clear();
    return awlist;
  }
  
  @Transactional
  public java.util.HashSet<Record> getAllRecords(SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    Criteria crits = ses.createCriteria(Record.class);
    crits.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    ses.clear();
    return new java.util.HashSet(crits.list());
  }
  
  @Transactional
  public List<Record> getUncommitedRecords(mv.domain.Employee emp, SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    Criteria crits = ses.createCriteria(Record.class);
    crits.add(org.hibernate.criterion.Restrictions.eq("isCommit", Boolean.valueOf(false))).add(org.hibernate.criterion.Restrictions.eq("endWareHouse", emp.getWarehouse()));
    crits.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<Record> myRecs = crits.list();
    return myRecs;
  }
  
  @Transactional
  public Record getUncommitedRecord(long id, SessionFactory sesfac) {
    Session ses = sesfac.getCurrentSession();
    Criteria crits = ses.createCriteria(Record.class);
    crits.add(org.hibernate.criterion.Restrictions.eq("id", Long.valueOf(id)));
    crits.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    return (Record)crits.list().get(0);
  }
}