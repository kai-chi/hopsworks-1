/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.bbc.jobs.jobhistory;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import se.kth.bbc.project.fb.Inode;
import se.kth.kthfsdashboard.user.AbstractFacade;


public class ExecutionInputfilesFacade extends AbstractFacade<ExecutionsInputfiles>{
    
    @PersistenceContext(unitName = "kthfsPU")
    private EntityManager em;

    public ExecutionInputfilesFacade(Class<ExecutionsInputfiles> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void create(Execution executionId, Inode inodeId, Inode inodeName){
        ExecutionsInputfiles file = new ExecutionsInputfiles(executionId, inodeId, inodeName);
        em.persist(file);
        em.flush();
    }
    
    public List<ExecutionsInputfiles> findExecutionInputFileByExecutionId(int executionId){
        TypedQuery<ExecutionsInputfiles> q = em.createNamedQuery(
            "ExecutionsInputfiles.findByExecutionId", ExecutionsInputfiles.class);
        q.setParameter("executionId", executionId);
        return null;
    }
    
    public List<ExecutionsInputfiles> findExecutionInputFileByInodePid(int inodePid){
        TypedQuery<ExecutionsInputfiles> q = em.createNamedQuery(
            "ExecutionsInputfiles.findByInodePid", ExecutionsInputfiles.class);
        q.setParameter("inodePid", inodePid);
        return null;
    }
    
    public List<ExecutionsInputfiles> findExecutionInputFileByInodePidName(int inodePid){
        TypedQuery<ExecutionsInputfiles> q = em.createNamedQuery(
            "ExecutionsInputfiles.findByInodePidName", ExecutionsInputfiles.class);
        q.setParameter("inodePid", inodePid);
        return null;
    }
    
    public List<ExecutionsInputfiles> findExecutionInputFileByByInodeName(String inodeName){
        TypedQuery<ExecutionsInputfiles> q = em.createNamedQuery(
            "ExecutionsInputfiles.findByInodeName", ExecutionsInputfiles.class);
        q.setParameter("inodeName", inodeName);
        return null;
    }
}
