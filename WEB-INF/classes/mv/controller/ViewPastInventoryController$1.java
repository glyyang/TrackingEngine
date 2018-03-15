package mv.controller;

import java.util.Comparator;
import mv.domain.View_History;

class ViewPastInventoryController
implements Comparator<View_History> {
    ViewPastInventoryController() {
    }

    @Override
    public int compare(View_History vh1, View_History vh2) {
        return (int)(vh1.getId() - vh2.getId());
    }
}