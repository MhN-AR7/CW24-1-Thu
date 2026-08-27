package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Member;
import ir.maktabsharif.util.HibernateUtil;

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

    public Member findMemberByName(String name){
        return HibernateUtil.read(em ->
            em.createQuery("SELECT m FROM Member m where m.fullName like lower(concat('%' ,:name,'%') )", Member.class)
                    .setParameter("name",name)
                    .getSingleResult()
        );
    }
}
