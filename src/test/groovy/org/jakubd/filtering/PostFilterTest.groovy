package org.jakubd.filtering

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DatabaseSetup
import org.jakubd.filtering.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = FilteringApp)
@WebIntegrationTest
@TestExecutionListeners([DependencyInjectionTestExecutionListener, DbUnitTestExecutionListener])
@Transactional(readOnly = true)
@DatabaseSetup("/posts.xml")
class PostFilterTest extends Specification {

    @Autowired
    PostRepository postRepository

    def "should contain posts loaded from dbunit"() {
        when:
            def books = postRepository.findAll()
        then:
            books*.id == [1,2,3,4,5,6]
    }
}
