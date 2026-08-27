package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.model.Member;
import ir.maktabsharif.repo.impl.MemberRepoImpl;

public class MemberServiceImpl extends BaseServiceImpl<Member> {
    public MemberServiceImpl() {
        super(new MemberRepoImpl());
    }

    @Override
    protected Long getId(Member entity) {
        return entity.getId();
    }

    @Override
    public void validate(Member member) throws BusinessException {

    }
}
