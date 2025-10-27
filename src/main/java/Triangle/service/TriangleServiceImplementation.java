package Triangle.service;

import Triangle.data.Triangle;

public class TriangleServiceImplementation implements TriangleService{
    @Override
    public double perimeter(Triangle triangle) {
        return triangle.getSide1() +
                triangle.getSide2() +
                triangle.getSide3();
    }
}
