
package Persistencia;

import Model.Carnivoro;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Sector;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CarnivoroJpaController implements Serializable {

    public CarnivoroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public CarnivoroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ZoologicoJPA-PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carnivoro carnivoro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector sector = carnivoro.getSector();
            if (sector != null) {
                sector = em.getReference(sector.getClass(), sector.getId());
                carnivoro.setSector(sector);
            }
            em.persist(carnivoro);
            if (sector != null) {
                sector.getMamiferos().add(carnivoro);
                sector = em.merge(sector);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carnivoro carnivoro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carnivoro persistentCarnivoro = em.find(Carnivoro.class, carnivoro.getCodigo());
            Sector sectorOld = persistentCarnivoro.getSector();
            Sector sectorNew = carnivoro.getSector();
            if (sectorNew != null) {
                sectorNew = em.getReference(sectorNew.getClass(), sectorNew.getId());
                carnivoro.setSector(sectorNew);
            }
            carnivoro = em.merge(carnivoro);
            if (sectorOld != null && !sectorOld.equals(sectorNew)) {
                sectorOld.getMamiferos().remove(carnivoro);
                sectorOld = em.merge(sectorOld);
            }
            if (sectorNew != null && !sectorNew.equals(sectorOld)) {
                sectorNew.getMamiferos().add(carnivoro);
                sectorNew = em.merge(sectorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = carnivoro.getCodigo();
                if (findCarnivoro(id) == null) {
                    throw new NonexistentEntityException("The carnivoro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carnivoro carnivoro;
            try {
                carnivoro = em.getReference(Carnivoro.class, id);
                carnivoro.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carnivoro with id " + id + " no longer exists.", enfe);
            }
            Sector sector = carnivoro.getSector();
            if (sector != null) {
                sector.getMamiferos().remove(carnivoro);
                sector = em.merge(sector);
            }
            em.remove(carnivoro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carnivoro> findCarnivoroEntities() {
        return findCarnivoroEntities(true, -1, -1);
    }

    public List<Carnivoro> findCarnivoroEntities(int maxResults, int firstResult) {
        return findCarnivoroEntities(false, maxResults, firstResult);
    }

    private List<Carnivoro> findCarnivoroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carnivoro.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Carnivoro findCarnivoro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carnivoro.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarnivoroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carnivoro> rt = cq.from(Carnivoro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
