/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Model.Mamifero;
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
public class MamiferoJpaController implements Serializable {

    public MamiferoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    } 
    public MamiferoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ZoologicoJPA-PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mamifero mamifero) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector sector = mamifero.getSector();
            if (sector != null) {
                sector = em.getReference(sector.getClass(), sector.getId());
                mamifero.setSector(sector);
            }
            em.persist(mamifero);
            if (sector != null) {
                sector.getMamiferos().add(mamifero);
                sector = em.merge(sector);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mamifero mamifero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mamifero persistentMamifero = em.find(Mamifero.class, mamifero.getCodigo());
            Sector sectorOld = persistentMamifero.getSector();
            Sector sectorNew = mamifero.getSector();
            if (sectorNew != null) {
                sectorNew = em.getReference(sectorNew.getClass(), sectorNew.getId());
                mamifero.setSector(sectorNew);
            }
            mamifero = em.merge(mamifero);
            if (sectorOld != null && !sectorOld.equals(sectorNew)) {
                sectorOld.getMamiferos().remove(mamifero);
                sectorOld = em.merge(sectorOld);
            }
            if (sectorNew != null && !sectorNew.equals(sectorOld)) {
                sectorNew.getMamiferos().add(mamifero);
                sectorNew = em.merge(sectorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mamifero.getCodigo();
                if (findMamifero(id) == null) {
                    throw new NonexistentEntityException("The mamifero with id " + id + " no longer exists.");
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
            Mamifero mamifero;
            try {
                mamifero = em.getReference(Mamifero.class, id);
                mamifero.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mamifero with id " + id + " no longer exists.", enfe);
            }
            Sector sector = mamifero.getSector();
            if (sector != null) {
                sector.getMamiferos().remove(mamifero);
                sector = em.merge(sector);
            }
            em.remove(mamifero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mamifero> findMamiferoEntities() {
        return findMamiferoEntities(true, -1, -1);
    }

    public List<Mamifero> findMamiferoEntities(int maxResults, int firstResult) {
        return findMamiferoEntities(false, maxResults, firstResult);
    }

    private List<Mamifero> findMamiferoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mamifero.class));
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

    public Mamifero findMamifero(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mamifero.class, id);
        } finally {
            em.close();
        }
    }

    public int getMamiferoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mamifero> rt = cq.from(Mamifero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
