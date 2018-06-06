package sample.spring.bigben0123.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sample.spring.bigben0123.mysql.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long>, UserExRepository {
	//自定义SQL语句示例。注意需使用jpa的dsl语法，表名这里是实体类名字.
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.id = ?2")
	int updateName(String userName, Integer id);

	@Transactional
	@Modifying
	@Query("update User   set name= CONCAT(name,'888')")
	int myUpdateName();

	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	int deleteByUserId(Integer id);

	@Transactional(timeout = 10)
	@Query("select u from User u where u.email = ?1")
	User findByEmailAddress(String emailAddress);

	/*
	 * @Query("select h.name as name, avg(r.rating) as averageRating " -
	 * "from Hotel h left outer join h.reviews r  group by h")
	 * Page<HotelSummary> findByCity(Pageable pageable);
	 * 
	 * public interface HotelSummary {
	 * 
	 * City getCity();
	 * 
	 * String getName();
	 * 
	 * Double getAverageRating();
	 * 
	 * default Integer getAverageRatingRounded() { return getAverageRating() ==
	 * null ? null : (int) Math.round(getAverageRating()); }
	 * 
	 * }
	 * 
	 * Page<HotelSummary> hotels = this.hotelRepository.findByCity(new
	 * PageRequest(0, 10, Direction.ASC, "name")); for(HotelSummary
	 * summay:hotels){ System.out.println("Name" +summay.getName()); }
	 */
}
