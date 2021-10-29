class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Point p1 = new Point(2.1, 3.2);
        Point p2 = new Point(4.2, 3.4);


        System.out.print(Point.distance(p1, p2));
    }
}