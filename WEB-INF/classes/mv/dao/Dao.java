package mv.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mv.domain.Asset;
import mv.domain.Asset_WareHouse;
import mv.domain.Employee;
import mv.domain.Record;
import mv.domain.Sub_Record;
import mv.domain.View_History;
import mv.domain.WareHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class Dao
{
  private SessionFactory sessionFactory;
  
  public Dao() {}
  
  private ReportDao report = new ReportDao();
  private AssetDao asset = new AssetDao();
  private EmployeeDao employee = new EmployeeDao();
  private WareHouseDao warehouse = new WareHouseDao();
  
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
  
  @Transactional
  public void save(Object obj) {
    Session session = sessionFactory.getCurrentSession();
    session.save(obj);
  }
  
  @Transactional
  public void update(Object obj)
  {
    Session ses = sessionFactory.getCurrentSession();
    ses.update(obj);
  }
  
  @Transactional
  public List<Asset> getAllAssets() {
    return asset.getAllAssets(sessionFactory);
  }
  
  @Transactional
  public Employee validate(String username) {
    return employee.getEmployee(username, sessionFactory);
  }
  
  @Transactional
  public List<Asset_WareHouse> getReport() {
    List<Asset_WareHouse> myRep = report.getReport(sessionFactory);
    return myRep;
  }
  
  @Transactional
  public List<Asset_WareHouse> getCurrentReport(boolean stat) {
    if (stat) {
      View_History vh = new View_History();
      vh.setEnt_date(new Date());
      
      save(vh);
    }
    return report.getCurrentReport(sessionFactory);
  }
  
  @Transactional
  public List<Asset_WareHouse> getWareHouseReport(Employee user) {
    return warehouse.getWareHouseInventory(user.getWarehouse().getName(), sessionFactory);
  }
  
  @Transactional
  public WareHouse getWareHouse(String name) {
    return warehouse.getWareHouse(name, sessionFactory);
  }
  
  @Transactional
  public Asset getAsset(String name) {
    return asset.getAsset(name, sessionFactory);
  }
  
  @Transactional
  public List<Asset_WareHouse> getOldReport(Date date) {
    List<Record> myRecs = new java.util.ArrayList(report.getAllRecords(sessionFactory));
    
    List<Asset_WareHouse> myCurRep = getReport();
    
    for (Record rc : myRecs) { Sub_Record src;
      Asset_WareHouse aw; if (rc.getDateOut().after(date)) {
        Set<Sub_Record> subRecs = rc.getSub_record();
        WareHouse warehouseIn = rc.getStartWareHouse();
        WareHouse warehouseOut = rc.getEndWareHouse();
        Iterator localIterator3;
        for (Iterator localIterator2 = subRecs.iterator(); localIterator2.hasNext(); 
            

            localIterator3.hasNext())
        {
          src = (Sub_Record)localIterator2.next();
          long quantEx = src.getQuantity();
          
          localIterator3 = myCurRep.iterator(); continue;aw = (Asset_WareHouse)localIterator3.next();
          if ((aw.getWarehouse().getId() == warehouseIn.getId()) && (src.getAsset().getId() == aw.getAsset().getId())) {
            aw.setAsset_quantity(aw.getAsset_quantity() + quantEx);
          }
          else if ((warehouseOut != null) && (aw.getWarehouse().getId() == warehouseOut.getId()) && (src.getAsset().getId() == aw.getAsset().getId())) {
            aw.setAsset_quantity(aw.getAsset_quantity() - quantEx);
          }
          
        }
      }
      else if ((rc.getDateCommit() != null) && (rc.getDateCommit().after(date))) {
        Set<Sub_Record> subRecs = rc.getSub_record();
        WareHouse warehouseOut = rc.getEndWareHouse();
        for (src = subRecs.iterator(); src.hasNext(); 
            
            aw.hasNext())
        {
          Sub_Record src = (Sub_Record)src.next();
          long quantEx = src.getQuantity();
          aw = myCurRep.iterator(); continue;Asset_WareHouse aw = (Asset_WareHouse)aw.next();
          if ((aw.getWarehouse().getId() == warehouseOut.getId()) && (src.getAsset().getId() == aw.getAsset().getId())) {
            aw.setAsset_quantity(aw.getAsset_quantity() - quantEx);
          }
        }
      }
    }
    


    return myCurRep;
  }
  
  @Transactional
  public List<Record> getUncommitedRecords(Employee emp) {
    return report.getUncommitedRecords(emp, sessionFactory);
  }
  
  @Transactional
  public List<Record> getForCommit(List<Long> ids) {
    List<Record> recs = new java.util.ArrayList();
    for (Iterator localIterator = ids.iterator(); localIterator.hasNext();) { long id = ((Long)localIterator.next()).longValue();
      Record rec = report.getUncommitedRecord(id, sessionFactory);
      recs.add(rec);
    }
    
    return recs;
  }
  
  @Transactional
  public Record generateReport(boolean stat, List<String> quantities, List<String> assetNames, WareHouse wIn, WareHouse wOut, String str, Employee user) {
    List<Sub_Record> sRecs = new java.util.ArrayList();
    Date date = new Date();
    int index = 0;
    Record rec = new Record();
    rec.setCommit(stat);
    
    rec.setDateOut(date);
    if (stat) {
      rec.setDateCommit(date);
    } else
      rec.setDateCommit(null);
    rec.setEmployee(user);
    rec.setStartWareHouse(wIn);
    rec.setEndWareHouse(wOut);
    rec.setDestination(str);
    for (;;)
    {
      Sub_Record sRec = new Sub_Record();
      try {
        String q = (String)quantities.get(index);
        if ((q.equals(null)) || (q.equals("")) || (q.equals(" ")) || (q.equals("\t"))) {
          q = "0";
        }
        long quant = Long.parseLong(q);
        
        Asset awName = getAsset((String)assetNames.get(index));
        long testQuant = 0L;
        
        for (Asset_WareHouse awI : wIn.getAsset_warehouses()) {
          if (awI.getAsset().getId() == awName.getId()) {
            testQuant = awI.getAsset_quantity();
            break;
          }
        }
        
        if ((quant < 0L) || (quant > testQuant)) {
          return null;
        }
        if ((q.length() > 0) && (quant > 0L)) {
          sRec.setQuantity(quant);
          sRec.setAsset(awName);
          sRec.setRecord(rec);
          sRecs.add(sRec);
        }
        
        index++;
        if (assetNames.size() != index) {}
      }
      catch (Exception e) {
        return null;
      }
    }
    
    if (sRecs.isEmpty()) {
      return null;
    }
    rec.setSub_record(new java.util.HashSet(sRecs));
    
    save(rec);
    
    return rec;
  }
  
  @Transactional
  public List<View_History> getAllHistory() {
    Session ses = sessionFactory.getCurrentSession();
    org.hibernate.Criteria crit = ses.createCriteria(View_History.class);
    crit.setResultTransformer(org.hibernate.Criteria.DISTINCT_ROOT_ENTITY);
    List<View_History> vh = crit.list();
    ses.clear();
    return vh;
  }
  
  @Transactional
  public List<WareHouse> getAllWareHouse() {
    return warehouse.getAllWareHouse(sessionFactory);
  }
}