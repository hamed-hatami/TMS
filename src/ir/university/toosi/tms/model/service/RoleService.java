package ir.university.toosi.tms.model.service;

import ir.university.toosi.tms.model.entity.Role;

import javax.jws.WebService;
import java.util.List;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@WebService
public interface RoleService<T extends Role> {

    public boolean exist(T entity);

    public T findById(String id);

    public List<T> getAllRole();

    public boolean deleteRole(T entity);

    public T createRole(T entity);

    public boolean editRole(T entity);

}
