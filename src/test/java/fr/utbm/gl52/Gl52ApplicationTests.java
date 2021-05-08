package fr.utbm.gl52;

import fr.utbm.gl52.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Gl52ApplicationTests {

	@Autowired
	SubjectRepository subjectRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void entityTest(){
		System.out.println(subjectRepository.findSubjectByName(""));
	}
}
