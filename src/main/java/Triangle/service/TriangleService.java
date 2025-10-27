package Triangle.service;

import Triangle.data.Triangle;

import java.util.ArrayList;

public interface TriangleService {
    double perimeter(Triangle triangle) throws IllegalArgumentException;


    ArrayList<Double> listOfPerimeters(ArrayList<Triangle> triangles);
}
