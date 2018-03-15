package mv.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import mv.dao.Dao;
import mv.domain.Asset;
import mv.domain.Asset_WareHouse;
import mv.domain.Employee;
import mv.domain.Record;
import mv.domain.Sub_Record;
import mv.domain.WareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportService {
    @Autowired
    Dao dao;

    public Record generateReport(boolean stat, List<String> quantities, List<String> assetNames, WareHouse wIn, WareHouse wOut, String str, Employee user) {
        return this.dao.generateReport(stat, quantities, assetNames, wIn, wOut, str, user);
    }

    public void addRecords(Record rec) {
        List awList = this.dao.getCurrentReport(false);
        WareHouse myWH = rec.getEndWareHouse();
        for (Sub_Record sRec : rec.getSub_record()) {
            boolean isExist = false;
            Asset ast = sRec.getAsset();
            long quant = sRec.getQuantity();
            if (quant <= 0) continue;
            for (Asset_WareHouse aw : awList) {
                if (!aw.getAsset().getName().equals(ast.getName()) || !aw.getWarehouse().getName().equals(myWH.getName())) continue;
                aw.setAsset_quantity(aw.getAsset_quantity() + quant);
                this.dao.update((Object)aw);
                isExist = true;
            }
            if (isExist) continue;
            Asset_WareHouse aws = new Asset_WareHouse();
            aws.setAsset(ast);
            aws.setWarehouse(rec.getEndWareHouse());
            aws.setAsset_quantity(sRec.getQuantity());
            this.dao.save((Object)aws);
        }
    }

    public void subRecords(Record rec) {
        List awList = this.dao.getCurrentReport(false);
        WareHouse myWH = rec.getStartWareHouse();
        for (Sub_Record sRec : rec.getSub_record()) {
            Asset ast = sRec.getAsset();
            long quant = sRec.getQuantity();
            for (Asset_WareHouse aw : awList) {
                if (!aw.getAsset().getName().equals(ast.getName()) || !aw.getWarehouse().getName().equals(myWH.getName())) continue;
                aw.setAsset_quantity(aw.getAsset_quantity() - quant);
                this.dao.update((Object)aw);
            }
        }
    }

    public List<Record> getUncommitedRecords(Employee emp) {
        return this.dao.getUncommitedRecords(emp);
    }

    public List<Record> commitChosenRecords(List<Long> ids) {
        List recs = this.dao.getForCommit(ids);
        for (Record rec : recs) {
            this.addRecords(rec);
            rec.setCommit(true);
            rec.setDateCommit(new Date());
            this.dao.update((Object)rec);
        }
        return recs;
    }
}