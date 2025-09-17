public class Main{
	
	public static void main(String[] args){
		ShapesManager manager = new ShapesManager();
		manager.addShape(new Triangle(0, 0, 10, 10));
		manager.addShape(new Triangle(2, 7, 15, 10));
		manager.addShape(new Circle(0, 0, 10));

		System.out.println(manager.getAverageArea());
	}
}
