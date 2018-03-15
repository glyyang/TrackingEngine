package mv.dao;

import java.io.Serializable;
import java.util.List;
import mv.domain.Asset;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Transactional;

public class AssetDao {
    @Transactional
    public Asset getAsset(String name, SessionFactory sesfac) {
        Session ses = sesfac.getCurrentSession();
        Criteria crit = ses.createCriteria(Asset.class);
        crit.add((Criterion)Restrictions.eq((String)"name", (Object)name));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List asset = crit.list();
        if (asset.isEmpty()) {
            return null;
        }
        return (Asset)asset.get(0);
    }

    @Transactional
    public List<Asset> getAllAssets(SessionFactory sesfac) {
        Session ses = sesfac.getCurrentSession();
        Criteria crit = ses.createCriteria(Asset.class);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List asset = crit.list();
        return asset;
    }

    @Transactional
    public void saveAsset(Asset a, SessionFactory sesfac) {
        Session ses = sesfac.getCurrentSession();
        ses.save((Object)a);
    }
}