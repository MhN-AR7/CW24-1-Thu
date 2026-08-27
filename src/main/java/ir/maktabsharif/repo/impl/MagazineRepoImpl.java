package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Magazine;

public class MagazineRepoImpl extends BaseRepoImpl<Magazine> {
    public MagazineRepoImpl() {
        super(Magazine.class);
    }

    @Override
    protected void setUpdate(Magazine oldEntity, Magazine newEntity) {

    }

    @Override
    protected Long getId(Magazine entity) {
        return entity.getId();
    }
}
