package Triangle.service;

import Triangle.data.Triangle;

import java.util.ArrayList;

public class TriangleServiceImplementation implements TriangleService{


    @Override
    public double perimeter(Triangle triangle) throws IllegalArgumentException {
        if(triangle.getSide1() < 0 ||
            triangle.getSide2() < 0 ||
            triangle.getSide3() < 0){
            throw new IllegalArgumentException();
        }

        return triangle.getSide1() +
                triangle.getSide2() +
                triangle.getSide3();
    }



    @Override
    public ArrayList<Double> listOfPerimeters(ArrayList<Triangle> triangles) {
        ArrayList<Double> perimeters = new ArrayList<>();

        for(Triangle triangle : triangles){
            perimeters.add(perimeter(triangle));
        }


        return perimeters;
    }
}
