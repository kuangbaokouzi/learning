package com.laowuandhisfriends.thrift;

import com.laowuandhisfriends.thrift.generated.DataException;
import com.laowuandhisfriends.thrift.generated.Person;
import com.laowuandhisfriends.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param: " + username);
        Person person = new Person();
        person.setUsrename(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param: " + person);

        System.out.println(person.getUsrename());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
