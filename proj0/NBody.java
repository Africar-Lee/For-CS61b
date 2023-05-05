import javax.swing.plaf.BorderUIResource;

public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);

        int n = in.readInt();
        double uRadius = in.readDouble();
        return uRadius;
    }

    public static Body[] readBodies(String fileName) {
        In in = new In(fileName);
        int n = in.readInt();
        double uRadius = in.readDouble();
        Body[] bodies = new Body[n];
        for(int i = 0; i < n; i++) {
            Body B = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            // bodies[i].xxPos = in.readDouble();
            // bodies[i].yyPos = in.readDouble();
            // bodies[i].xxVel = in.readDouble();
            // bodies[i].yyVel = in.readDouble();
            // bodies[i].mass  = in.readDouble();
            // String temp = in.readString();
            bodies[i] = B;
        }
        return bodies;
    }

    public static void main(String[] args) {
        /** Collecting all needed input */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double uRadius = readRadius(filename);

        /** Draw background */
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-256, 256);
        StdDraw.clear();

        StdDraw.picture(0, 0, "./images/starfield.jpg");
        for(Body b:bodies) {
            b.draw(uRadius);
        }
        StdDraw.show();

        double tt = 0.0;
        while(tt < T) {
            tt += dt;
            StdDraw.pause(100);
            int n = bodies.length;
            double[] xForces = new double[n], yForces = new double[n];
            for(int i = 0; i < n; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for(int i = 0; i < n; ++i) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for(Body b:bodies) {
                b.draw(uRadius);
            }
            StdDraw.show();
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", uRadius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
            bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
        }
    }
}
