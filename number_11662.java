import java.util.Scanner;

public class number_11662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double aX = sc.nextDouble();
        double aY = sc.nextDouble();
        double bX = sc.nextDouble();
        double bY = sc.nextDouble();
        double cX = sc.nextDouble();
        double cY = sc.nextDouble();
        double dX = sc.nextDouble();
        double dY = sc.nextDouble();

        sc.close();

        double start = 0;
        double end = 1;

        while(end - start > 1e-9){
            double mid1 = start + (end - start) / 3;
            double mid2 = end - (end-start) / 3;
            if(distance(mid1, aX, aY, bX, bY, cX, cY, dX, dY)>distance(mid2, aX, aY, bX, bY, cX, cY, dX, dY)){
                start = mid1;
            }
            else{
                end = mid2;
            }
            
        }

        System.out.print(distance(start, aX, aY, bX, bY, cX, cY, dX, dY));
    }

    public static double distance(double param, double aX, double aY,double bX, double bY,double cX, double cY,double dX, double dY){
        double minhoX   = aX*param + bX*(1-param);
        double minhoY = aY*param + bY*(1-param);
        double kanghoX = cX * param + dX * (1 - param);
        double kanghoY = cY * param + dY * (1 - param);
        return Math.sqrt(Math.pow(kanghoX - minhoX,2) + Math.pow(kanghoY - minhoY, 2));
    }
        
}
