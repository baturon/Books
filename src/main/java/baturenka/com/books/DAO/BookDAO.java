package baturenka.com.books.DAO;

import baturenka.com.books.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class BookDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public BookDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Book> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select b from Book b",Book.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Book show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Transactional
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        Session session = sessionFactory.getCurrentSession();
        Book bookToBeUpdated = session.get(Book.class, id);

       bookToBeUpdated.setTitle(updatedBook.getTitle());
       bookToBeUpdated.setAuthor(updatedBook.getAuthor());
       bookToBeUpdated.setDate(updatedBook.getDate());
        bookToBeUpdated.setStyle(updatedBook.getStyle());
        bookToBeUpdated.setNumberOfPages(updatedBook.getNumberOfPages());
        bookToBeUpdated.setDescription(updatedBook.getDescription());


    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Book.class, id));
    }
}
