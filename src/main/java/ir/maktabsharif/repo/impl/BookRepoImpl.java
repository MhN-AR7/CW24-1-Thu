package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Book;
import ir.maktabsharif.util.HibernateUtil;

public class BookRepoImpl extends BaseRepoImpl<Book> {
    public BookRepoImpl() {
        super(Book.class);
    }

    @Override
    protected void setUpdate(Book oldEntity, Book newEntity) {

    }

    @Override
    protected Long getId(Book entity) {
        return entity.getId();
    }

    public Book findBookByPublicationYear(int publishYear){
        return HibernateUtil.read(em ->
            em.createQuery("SELECT b FROM Book b where b.publishYear = ?1", Book.class)
                    .setParameter(1,publishYear)
                    .getSingleResult()
        );
    }
}
