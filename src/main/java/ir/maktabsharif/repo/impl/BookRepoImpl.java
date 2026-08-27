package ir.maktabsharif.repo.impl;

import ir.maktabsharif.model.Book;

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
}
