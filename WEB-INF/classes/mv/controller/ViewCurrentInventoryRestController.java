package mv.controller;

import java.util.ArrayList;
import java.util.List;
import mv.dao.Dao;
import mv.domain.AWList;
import mv.domain.Asset;
import mv.domain.AssetWareHouse;
import mv.domain.Asset_WareHouse;
import mv.domain.RAsset;
import mv.domain.RWareHouse;
import mv.domain.WareHouse;

@org.springframework.web.bind.annotation.RestController
public class ViewCurrentInventoryRestController
{
  @org.springframework.beans.factory.annotation.Autowired
  Dao dao;
  
  public ViewCurrentInventoryRestController() {}
  
  @org.springframework.web.bind.annotation.RequestMapping(value={"/findCompare"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public AWList handleCompare()
  {
    List<Asset_WareHouse> awl = dao.getReport();
    List<AssetWareHouse> awlR = new ArrayList();
    int index = 0;
    while (awl.size() != index) {
      Asset_WareHouse aw = (Asset_WareHouse)awl.get(index);
      AssetWareHouse awR = new AssetWareHouse();
      awR.setId(aw.getId());
      awR.setAsset_quantity(aw.getAsset_quantity());
      awR.setAsset(new RAsset(aw.getAsset().getId(), aw.getAsset().getName(), aw.getAsset().getPrice()));
      awR.setWarehouse(new RWareHouse(aw.getWarehouse().getId(), aw.getWarehouse().getName()));
      awlR.add(awR);
      index++;
    }
    
    AWList awlist = new AWList(awlR);
    
    return awlist;
  }
}