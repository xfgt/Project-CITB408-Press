package Triangle.service;

import Triangle.data.Triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // important import


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TriangleServiceImplementationTest {

    /*



            NOTE: Settings > Build,Execution,Deployment > Build Tools > Gradle > Runner > "Run tests using:" INTELIJ IDEA
            href: https://velog.io/@yeseul/No-matching-tests-found-in-any-candidate-test-task.-%EC%97%90%EB%9F%AC-%ED%95%B4%EA%B2%B0



     */


    TriangleService triangleService;
    Triangle triangle;

    @BeforeEach
    void setup(){
        triangleService = new TriangleServiceImplementation();
        triangle = new Triangle(5, 6, 7);
    }


    @Test
    void VeryDetailedDecriptionOfTest_whenAllSidesAreZero_thenReturnZero() {
        // given
        Triangle triangle = new Triangle(0,0,0);
        //TriangleService triangleService = new TriangleServiceImplementation();

        // when
        double actual = 0;
        try {
            actual = triangleService.perimeter(triangle);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // then
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void whenSide1_5Side2_6Side3_7_thenReturn18() {
        try {
            assertEquals(18, triangleService.perimeter(triangle));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void whenAllSidesToBePositiveNumbers_thenReturnPositiveNumber() {
        try {
            assertTrue(triangleService.perimeter(triangle) > 0);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void whenOneOfTheSidesIsNegative_thenIllegalArgumentExceptionIsThrown(){

        // given
        Triangle triangleWithNegativeSide1 = new Triangle(-1, 5, 6);
                    // Expected,  2-nd argument: (Executable);         lambda expression
        assertThrows(IllegalArgumentException.class,
                        () -> triangleService.perimeter(triangleWithNegativeSide1));

    }

    @Test
    void whenTrianglesListIsEmpty_thenReturnEmptyList() {

        // given
        ArrayList<Triangle> triangles = new ArrayList<>();

        // when, then
        assertTrue(triangleService.listOfPerimeters(triangles).isEmpty());

    }
    @Test
    void whenTrianglesList_NOT_IsEmpty_thenReturnListOfPerimeters() {

        // given
        ArrayList<Triangle> triangles = new ArrayList<>();
        Triangle triangle1 = new Triangle(3,4,5);

        triangles.add(triangle1);
        triangles.add(triangle); // new Triangle(5, 6, 7);

        // when, then
        ArrayList<Double> expectedList = new ArrayList<>();
        expectedList.add(12.);
        expectedList.add(18.);
        assertIterableEquals(expectedList, triangleService.listOfPerimeters(triangles));

    }
}