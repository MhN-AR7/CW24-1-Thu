package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.BusinessException;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.repo.BaseRepo;
import ir.maktabsharif.repo.impl.BookRepoImpl;

public class BookServiceImpl extends BaseServiceImpl<Book> {
    public BookServiceImpl() {
        super(new BookRepoImpl());
    }

    @Override
    protected Long getId(Book entity) {
        return entity.getId();
    }

    @Override
    public void validate(Book book) throws BusinessException {

    }

    public Book findBookByPublicationYear(int publicationYear){
        return new BookRepoImpl().findBookByPublicationYear(publicationYear);
    }
}
