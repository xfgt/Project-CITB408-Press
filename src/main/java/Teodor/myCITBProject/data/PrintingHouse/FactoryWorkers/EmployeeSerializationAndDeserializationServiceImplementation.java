package Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers;

import Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers.EmployeeSerializationAndDeserializationService;

import java.io.*;

public class EmployeeSerializationAndDeserializationServiceImplementation
    implements EmployeeSerializationAndDeserializationService {
    @Override
    public void serializeEmployee(String fileName, Employee employee) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(employee);
        }
    }

    @Override
    public Employee deSerializeEmployee(String fileName) throws IOException, ClassNotFoundException {
        Employee employee = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            employee = (Employee) objectInputStream.readObject();

        }
        return employee;
    }
}
