package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Manuscript;

public class ManuscriptRepoImpl extends BaseRepoImpl<Manuscript> {
    public ManuscriptRepoImpl() {
        super(Manuscript.class);
    }

    @Override
    protected void setUpdate(Manuscript oldEntity, Manuscript newEntity) {

    }

    @Override
    protected Long getId(Manuscript entity) {
        return entity.getId();
    }
}
