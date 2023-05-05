public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body B){
        this.xxPos = B.xxPos;
        this.yyPos = B.yyPos;
        this.xxVel = B.xxVel;
        this.yyVel = B.yyVel;
        this.mass = B.mass;
        this.imgFileName = B.imgFileName;
    }

    public double calcDistance(Body B2) {
        double dx = this.xxPos - B2.xxPos;
        double dy = this.yyPos - B2.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public static final double G = 6.67e-11;
    public double calcForceExertedBy(Body B2) {
        double dis = this.calcDistance(B2);
        return (G * this.mass * B2.mass / (dis * dis));
    }
    public double calcForceExertedByX(Body B2) {
        double dis = this.calcDistance(B2);
        double dx = B2.xxPos - this.xxPos;
        double force = this.calcForceExertedBy(B2);
        return (force * dx / dis);
    }
    public double calcForceExertedByY(Body B2) {
        double dis = this.calcDistance(B2);
        double dy = B2.yyPos - this.yyPos;
        double force = this.calcForceExertedBy(B2);
        return (force * dy / dis);
    }
    public double calcNetForceExertedByX(Body[] Bodys) {
        double fx = 0.0;
        for(Body B:Bodys) {
            if(this.equals(B)) continue;
            fx = fx + this.calcForceExertedByX(B);
        }
        return fx;
    }
    public double calcNetForceExertedByY(Body[] Bodys) {
        double fy = 0.0;
        for(Body B:Bodys) {
            if(this.equals(B)) continue;
            fy = fy + this.calcForceExertedByY(B);
        }
        return fy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw(double uRadius) {
        double picX = 256 * this.xxPos / uRadius;
        double picY = 256 * this.yyPos / uRadius;

        StdDraw.enableDoubleBuffering();
        StdDraw.picture(picX, picY, "./images/" + this.imgFileName);
    }
}