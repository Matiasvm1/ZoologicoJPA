/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Herbivoro;
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

/**
 *
 * @author Matias
 */
public class HerbivoroJpaController implements Serializable {

    public HerbivoroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public HerbivoroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ZoologicoJPA-PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Herbivoro herbivoro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector sector = herbivoro.getSector();
            if (sector != null) {
                sector = em.getReference(sector.getClass(), sector.getId());
                herbivoro.setSector(sector);
            }
            em.persist(herbivoro);
            if (sector != null) {
                sector.getMamiferos().add(herbivoro);
                sector = em.merge(sector);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Herbivoro herbivoro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Herbivoro persistentHerbivoro = em.find(Herbivoro.class, herbivoro.getCodigo());
            Sector sectorOld = persistentHerbivoro.getSector();
            Sector sectorNew = herbivoro.getSector();
            if (sectorNew != null) {
                sectorNew = em.getReference(sectorNew.getClass(), sectorNew.getId());
                herbivoro.setSector(sectorNew);
            }
            herbivoro = em.merge(herbivoro);
            if (sectorOld != null && !sectorOld.equals(sectorNew)) {
                sectorOld.getMamiferos().remove(herbivoro);
                sectorOld = em.merge(sectorOld);
            }
            if (sectorNew != null && !sectorNew.equals(sectorOld)) {
                sectorNew.getMamiferos().add(herbivoro);
                sectorNew = em.merge(sectorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = herbivoro.getCodigo();
                if (findHerbivoro(id) == null) {
                    throw new NonexistentEntityException("The herbivoro with id " + id + " no longer exists.");
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
            Herbivoro herbivoro;
            try {
                herbivoro = em.getReference(Herbivoro.class, id);
                herbivoro.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The herbivoro with id " + id + " no longer exists.", enfe);
            }
            Sector sector = herbivoro.getSector();
            if (sector != null) {
                sector.getMamiferos().remove(herbivoro);
                sector = em.merge(sector);
            }
            em.remove(herbivoro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Herbivoro> findHerbivoroEntities() {
        return findHerbivoroEntities(true, -1, -1);
    }

    public List<Herbivoro> findHerbivoroEntities(int maxResults, int firstResult) {
        return findHerbivoroEntities(false, maxResults, firstResult);
    }

    private List<Herbivoro> findHerbivoroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Herbivoro.class));
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

    public Herbivoro findHerbivoro(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Herbivoro.class, id);
        } finally {
            em.close();
        }
    }

    public int getHerbivoroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Herbivoro> rt = cq.from(Herbivoro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
