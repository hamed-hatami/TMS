package ir.university.toosi.tms.model.service;

import ir.university.toosi.tms.model.entity.User;

import javax.jws.WebService;
import java.util.List;

/**
 * @author : Hamed Hatami , Javad Sarhadi , Farzad Sedaghatbin, Atefeh Ahmadi
 * @version : 0.8
 */

@WebService
public interface UserService<T extends User> {

    public boolean exist(String username);

    public T authenticate(String username, String password);

    public T findById(String id);

    public T findByUsername(String username);

    public T findOld(String username);

    public boolean modifyPassword(T entity);

    public List<T> getAllUser();

    public List<T> getAllPendingUser();

    public List<T> getAllBanksPendingUser(T entity);

    public List<T> getAllPending(T entity);

    public T createUser(T entity);

    public boolean create(T entity);

    public boolean deleteUser(T entity);

    public boolean editUser(T entity);


}
