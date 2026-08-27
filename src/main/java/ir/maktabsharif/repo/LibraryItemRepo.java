package ir.maktabsharif.repo;

import ir.maktabsharif.model.LibraryItem;
import ir.maktabsharif.util.HibernateUtil;

public class LibraryItemRepo {
    public void increaseCopies(LibraryItem item) {
        item.setAvailableCopies(item.getAvailableCopies()+1);
    }

    public void decreaseCopies(LibraryItem item) {
        HibernateUtil.inTxReturn(
                em -> {
                    LibraryItem oldEntity = em.find(LibraryItem.class, item.getId());
                    if (oldEntity == null) return null;

                    oldEntity.setAvailableCopies(item.getAvailableCopies()-1);

                    return oldEntity;
                }
        );
    }
}
