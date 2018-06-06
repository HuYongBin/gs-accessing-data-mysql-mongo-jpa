package hello;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import sample.spring.bigben0123.Application;
import sample.spring.bigben0123.mysql.model.User;
import sample.spring.bigben0123.mysql.repository.UserRepository;
import org.junit.runners.MethodSorters;  

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  
public class MysqlTests {

	@Autowired
	UserRepository repository;
	static User dave, oliver, carter;

	static void log(String s) {
		System.out.println(s);
	}

	@Before
	public void setUp() {
		log("====start setup==========");
		repository.deleteAll();

		dave = repository.save(new User("Dave", "Matthews@aaa.com"));
		oliver = repository.save(new User("Oliver August", "Matthews@aaa.com"));
		carter = repository.save(new User("Carter", "Carter@aaa.com"));
		log("====end setup==========");
	}

	@Test
	public void setsIdOnSave() {
		log("====start setsIdOnSave==========");
		User dave = repository.save(new User("Dave", "Matthews@aaa.com"));
		assertThat(dave.id).isNotNull();
		log("====end setsIdOnSave==========");
	}

	@Test
	public void zLastExec() {
		log("====start exec==========");
		int r = repository.updateEmail("IamDave@aaa.com", dave.id);
		repository.updateName("real dave", dave.id);
		repository.myUpdateName();
		log("====end exec==========");
	}

	@Test
	public void findsByEmail() {

		User probe = new User(null, "Matthews@aaa.com");
		List<User> result = repository.findAll(Example.of(probe));
		assertThat(result).hasSize(2).extracting("name").contains("Dave", "Oliver August");
	}
}