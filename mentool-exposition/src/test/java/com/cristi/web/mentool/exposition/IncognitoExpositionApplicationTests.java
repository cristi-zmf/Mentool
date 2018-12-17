package com.cristi.web.mentool.exposition;

import com.cristi.web.mentool.application.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
@ActiveProfiles("MEMORY_MONGO")
public class IncognitoExpositionApplicationTests {
	@Test
	public void contextLoads() {
	}
}
