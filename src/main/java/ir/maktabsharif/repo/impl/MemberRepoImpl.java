package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Member;

public class MemberRepoImpl extends BaseRepoImpl<Member> {
    public MemberRepoImpl() {
        super(Member.class);
    }

    @Override
    protected void setUpdate(Member oldEntity, Member newEntity) {

    }

    @Override
    protected Long getId(Member entity) {
        return entity.getId();
    }
}
