package org.springboot.tutorials.mapper;

import org.springboot.tutorials.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author DevinYang
 * @version 1.0.0
 * @createTime 2020-03-22
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
