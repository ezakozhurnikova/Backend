package de.ait.timepad.repositories;

import de.ait.timepad.models.User;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends CrudRepository<User> {

    // TODO: убрать метод, как только подключим базы данных
    void clear();

}
