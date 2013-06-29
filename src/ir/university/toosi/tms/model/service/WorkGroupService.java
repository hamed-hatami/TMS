package ir.university.toosi.tms.model.service;

import ir.university.toosi.tms.model.entity.Role;
import ir.university.toosi.tms.model.entity.WorkGroup;

import javax.jws.WebService;
import java.util.List;
import java.util.Set;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@WebService
public interface WorkGroupService<T extends WorkGroup> {

    public boolean exist(T entity);

    public T findById(String id);

    public T findByTitle(String title);

    public List<T> getAllWorkGroup();

    public boolean deleteWorkGroup(T entity);

    public T createWorkGroup(T entity);

    public boolean editWorkGroup(T entity);

    public boolean deleteWorkGroupUpdateRoles(T entity);

    public T createWorkGroupWithRoles(T entity, Set<Role> roles);

    public boolean editWorkGroupWithRoles(T entity, Set<Role> newRoles);

}
