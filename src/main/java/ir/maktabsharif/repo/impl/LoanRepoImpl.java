package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Loan;
import ir.maktabsharif.util.HibernateUtil;

public class LoanRepoImpl extends BaseRepoImpl<Loan> {
    public LoanRepoImpl() {
        super(Loan.class);
    }

    @Override
    protected void setUpdate(Loan oldEntity, Loan newEntity) {
        oldEntity.setLoanStatus(newEntity.getLoanStatus());
        oldEntity.setReturnDate(newEntity.getReturnDate());
        oldEntity.setItem(newEntity.getItem());
    }

    @Override
    protected Long getId(Loan entity) {
        return entity.getId();
    }

    public Long countOfNonReturnedItems(){

        return HibernateUtil.read(em ->
            em.createQuery("SELECT count(l) FROM Loan l where l.loanStatus != 'RETURNED'", Long.class)
                    .getSingleResult()
        );
    }
}
