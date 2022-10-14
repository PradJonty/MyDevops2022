package valtechspring.ioc;

public class Live {
 private Point start;
 private Point end;
 
public Live() {}
public Live(Point start, Point end) {
	super();
	this.start = start;
	this.end = end;
}
public Point getStart() {
	return start;
}
public void setStart(Point start) {
	this.start = start;
}
@Override
public String toString() {
	return "Live [start=" + start + ", end=" + end + "]";
}
public Point getEnd() {
	return end;
}
public void setEnd(Point end) {
	this.end = end;
}
}
