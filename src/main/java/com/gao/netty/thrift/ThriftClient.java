package com.gao.netty.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {

    public static void main(String[] args) {
        TFramedTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TCompactProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println("----------");
            Person person1 = new Person();
            person1.setUsername("里斯");
            person1.setAge(22);
            person1.setMarried(true);
            client.savePerson(person1);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}
