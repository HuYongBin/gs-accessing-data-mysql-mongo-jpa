package sample.spring.bigben0123.mysql.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public class UserRepositoryImpl implements UserExRepository {
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public int updateEmail(String email,Integer id) {
		log.info("== updateEmail ===");
		//这里是数据库里面的表名，注意区分大小写
		String sql = "update user u set u.email = ?1 where u.id = ?2";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, id);
		return query.executeUpdate();
		
	}


}
