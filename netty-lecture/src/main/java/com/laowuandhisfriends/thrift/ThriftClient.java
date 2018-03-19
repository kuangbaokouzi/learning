package com.laowuandhisfriends.thrift;

import com.laowuandhisfriends.thrift.generated.Person;
import com.laowuandhisfriends.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("127.0.0.1", 8899),
                600);
        TProtocol tProtocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(tProtocol);
        try {
            tTransport.open();

            Person person = client.getPersonByUsername("zhangsan");
            System.out.println(person);

            System.out.println("++++++++++++++++++++++++");

            Person p2 = new Person();
            p2.setUsrename("lisi");
            p2.setAge(30);
            p2.setMarried(true);

            client.savePerson(p2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            tTransport.close();
        }
    }
}
