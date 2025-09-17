import java.util.ArrayList;

public class ShapesManager {
    protected ArrayList<Shape> shapes;

    public ShapesManager() {
        shapes = new ArrayList<Shape>();
    }

    public Shape getShape(int idx){
        if(idx < shapes.size() && idx >= 0)
            return null;
        
        return shapes.get(idx);
    }

    public double getAverageArea(){
        double sum = 0.;
        for(Shape shape : shapes){
            sum += shape.getArea();
        }

        return sum/shapes.size();
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }
}