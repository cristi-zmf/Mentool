package com.cristi.web.mentool.infra.persistence.subject;

import com.cristi.web.mentool.domain.subject.Description;
import com.cristi.web.mentool.domain.subject.Subject;
import com.cristi.web.mentool.domain.subject.Title;
import com.cristi.web.mentool.application.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
@SpringBootTest(classes = {ApplicationConfig.class})
@EnableAutoConfiguration
@ActiveProfiles("MEMORY_MONGO")
public class SubjectsMongoLocalIT {

    @Autowired
    private MongoSubjects repo;
    @Autowired
    private SubjectsMongo sut;

    @Before
    public void clearDb() {
        repo.deleteAll();
    }
    @Test
    public void findAll() {
    }

    @Test
    public void getOrThrow() {
    }

    @Test
    public void get() {
        Subject subject = someSubject();
        repo.insert(subject);
        Optional<Subject> actual = sut.get(subject.getId());
        assertThat(actual).isNotEmpty();
        assertThat(actual.get()).isEqualToComparingFieldByFieldRecursively(subject);
    }

    @Test
    public void add() {
        Subject expected = someSubject();
        sut.add(expected);
        Subject actual = repo.findById(expected.getId()).get();
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void find_by_title_containing_should_return_all_subjects_with_that_title_key_in_their_title() {
        Subject someSubject = someSubject();
        String keyToSearch = someSubject.getTitle().getValue();
        keyToSearch = keyToSearch.substring(2, keyToSearch.length() - 1);
        repo.insert(someSubject);
        Set<Subject> actual = sut.findByTitleContaining(keyToSearch);
        assertThat(actual).isNotEmpty();
        assertThat(actual.stream().findFirst().get()).isEqualToComparingFieldByField(someSubject);
    }

    private Subject someSubject() {
        return new Subject(new Title("iphone xs"), new Description("It is so expensive!!"));
    }
}