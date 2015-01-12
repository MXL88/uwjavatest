import java.beans.*;
import java.util.*;

class Point 
	implements Comparable<Point>
{
	private int x;
	private int y;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.addPropertyChangeListener(listener);
     }

     public void removePropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.removePropertyChangeListener(listener);
     }

	public static class YComparator implements Comparator<Point>
	{
		public int compare(Point lhs, Point rhs) {
			return lhs.y - rhs.y;
		}
	}

	public Point(int xx, int yy) { this.x = xx; this.y = yy; }

	public int getX() { return x; }
	public void setX(int value) { 
		int old = x;
		x = value; 
		pcs.firePropertyChange(new PropertyChangeEvent(this, "x", old, value));
	}

	@Override
	public int compareTo(Point other) {
		return this.x - other.x;
	}

	@Override
	public String toString() {
		return "Point: (" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Point) {
			Point p = (Point)other;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
}


public class Hello
{
	public static void main(String... args) {
		Point p1 = new Point(1,2); //p1.x = 1; p1.y = 2;
		Point p2 = new Point(1,2); //p2.x = 1; p2.y = 2;
		Point p3 = new Point(2,1); //p3.x = 2; p3.y = 1;
		Point p4 = new Point(-5,12);// p4.x = -5; p4.y = 12;

		ArrayList<Point> points = new ArrayList<Point>(50);
		points.add(p1); points.add(p2); points.add(p3); points.add(p4);
		System.out.println(points);

		Collections.sort(points);
		System.out.println(points);

		Collections.sort(points, new Point.YComparator());
		System.out.println(points);

		final int foo = 12;
		p2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				foo = 24;
				System.out.println("Object " + evt.getSource() + " says that " +
					evt.getPropertyName() + " is now " + evt.getNewValue() + foo);
			}
		} );
		p2.addPropertyChangeListener((evt) -> {
			foo = 24;
			System.out.println("Object " + evt.getSource() + " says that " +
				evt.getPropertyName() + " is now " + evt.getNewValue() + foo);
		} );

		p2.setX(24);

	}
}
















