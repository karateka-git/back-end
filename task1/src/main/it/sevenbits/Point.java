package main.it.sevenbits;

public class Point {
    private int X;
    private int Y;

    public Point(int X, int Y) {
        SetX(X);
        SetY(Y);
    }

    public int GetX() {
        return X;
    }

    public void SetX(int X) {
        this.X = X;
    }

    public int GetY() {
        return Y;
    }

    public void SetY(int Y) {
        this.Y = Y;
    }
}
