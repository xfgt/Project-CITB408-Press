package Teodor.myCITBProject.service.PrintingHouse.FactoryWorkers;

import Teodor.myCITBProject.data.PrintingHouse.FactoryWorkers.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EmployeeSerializationAndDeserializationService {
    void serializeEmployee(String fileName, Employee employee) throws IOException;
    Employee deSerializeEmployee(String fileName) throws IOException, ClassNotFoundException;
}
