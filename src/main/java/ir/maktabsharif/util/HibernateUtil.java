package ir.maktabsharif.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Function;

public final class HibernateUtil {
    private static final String PERSISTENCE_UNIT = "cw24-1-pu";

    private static EntityManagerFactory emf;

    private HibernateUtil() {
    }

    //Singleton Pattern
    private static synchronized EntityManagerFactory getInstanceEmf() {
        if (emf == null) emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return emf;
    }

    private static void closeEmf() {
        if (emf != null && emf.isOpen()) emf.close();
    }

    private static EntityManager getEm() {
        return getInstanceEmf().createEntityManager();
    }

    public static <T> T inTxReturn(Function<EntityManager, T> operation) {
        EntityManager em = getEm();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        }
        catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }

    public static <T> T read(Function<EntityManager, T> operation) {
        try (EntityManager em = getEm()) {
            return operation.apply(em);
        }
    }
}
