import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Robot> robots = new LinkedList<>();
        robots.add(new Robot(1, 2, Directions.North));
        robots.add(new Robot(22, 3, Directions.North));
        robots.add(new Robot(4, 44, Directions.North));
        robots.add(new Robot(0, 12, Directions.East));
        robots.add(new Robot(3, 22, Directions.West));
        robots.add(new Robot(200, 2, Directions.South));
        robots.add(new Robot(100, 12, Directions.South));


        List<Robot> southWatchers = robots.stream()
                .filter(rob -> rob.direction == Directions.South)
                .collect(Collectors.toList());

        System.out.println("Роботы, которые смотрят на Юг: " + southWatchers);

        
        Map<Directions, Long> directionCount = robots.stream()
                .collect(Collectors.groupingBy(rob -> rob.direction, Collectors.counting()));

        System.out.println("Количество роботов в каждом направлении: " + directionCount);
    }
}

enum Directions {
    North, East, South, West;
}

class Robot {
    int x, y;
    Directions direction;

    public Robot(int x, int y, Directions direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public void turnLeft() {
        switch (direction) {
            case East -> direction = Directions.North;
            case North -> direction = Directions.West;
            case South -> direction = Directions.East;
            case West -> direction = Directions.South;
        }
    }

    public void turnRight() {
        switch (direction) {
            case East -> direction = Directions.South;
            case North -> direction = Directions.East;
            case South -> direction = Directions.West;
            case West -> direction = Directions.North;
        }
    }
}