package com.gao.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Get client param:" + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(22);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Get client param:");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
