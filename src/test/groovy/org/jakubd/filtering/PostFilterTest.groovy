package org.jakubd.filtering

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DatabaseSetup
import org.jakubd.filtering.filter.PostFilter
import org.jakubd.filtering.filter.PostFilterOldBuilder
import org.jakubd.filtering.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = FilteringApp)
@WebIntegrationTest
@TestExecutionListeners([DependencyInjectionTestExecutionListener, DbUnitTestExecutionListener])
@Transactional(readOnly = true)
@DatabaseSetup("/posts.xml")
class PostFilterTest extends Specification {

    @Autowired
    PostRepository postRepository

    def filterBuilder = new PostFilterOldBuilder()

    def "should contain posts loaded from dbunit"() {
        when:
            def books = postRepository.findAll()
        then:
            books*.id == [1,2,3,4,5,6]
    }

    @Unroll("should retrieve posts #ids given filter #postFilter")
    def "should retrieve posts given filter"(Map postFilter, List<Integer> ids) {
        expect:
            def predicate = filterBuilder.build(new PostFilter(postFilter))
            def posts = postRepository.findAll(predicate)
            posts*.id == ids
        where:
            postFilter                       | ids
            [:]                              | [1, 2, 3, 4, 5, 6]
            [author: 'larman']               | [1]
            [title: 'phone']                 | [1, 3]
            [from: LocalDate.of(2016, 1, 1)] | [1, 2, 4, 5]
            [to: LocalDate.of(2016, 1, 1)]   | [3, 6]
            [tags: ['tech']]                 | [1,2,3,5]
            [tags: ['tech', 'cooking']]      | [1, 2, 3, 4, 5, 6]
    }
}
