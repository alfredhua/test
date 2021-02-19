package com.es.service;

import com.es.entity.Person;
import com.es.resp.PersonRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author guozhenhua
 * @date 2020/03/29
 */
@Component

public class PersonService  implements ApplicationContextAware {

    @Autowired
    PersonRepository personRepository;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected PersonDao createPersonDao() {
        return this.applicationContext.getBean( PersonDao.class);
    }

    public void test(){
        System.out.println(createPersonDao());
        createPersonDao().test();
    }

//    @Autowired
//    ElasticsearchTemplate elasticsearchTemplate;

//    @Autowired
//    ReactiveElasticsearchOperations template;

    public void savePerson() {
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            person.setId((long) (i + 1));
            person.setName("张三" + i);
            person.setDesc("描述AAAAAAA" + i);
            person.setSex((short) (i % 2));
            person.setText("aaaa,bbb,ccc,ddd,eee" + i);
            personRepository.save(person);
        }
    }

    public List<Person> search(String key) {
        return personRepository.find(key);
    }

    public List<Person> pageSearch(String key,int page) {
        Sort.TypedSort<Person> person = Sort.sort(Person.class);
//        Sort sort = person.by(Person::getId).ascending()
//                .and(person.by(Person::getName).descending());
        return personRepository.findByName(key, PageRequest.of(page, 10));
    }

    public List<Person> findByDesc(String key) {
        return personRepository.findByDesc(key);
    }


    public void savePerson2(){
        Person person1 = new Person();
        person1.setId((long) ( 1));
        person1.setName("李四");
        person1.setDesc("描述AAAAAAA" );
        person1.setSex((short)1);
        person1.setText("aaaa,bbb,ccc,ddd,eee" );
//        template.save( person1);
    }
}
