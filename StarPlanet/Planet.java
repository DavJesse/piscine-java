public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {  // First check parent class equality
            return false;
        }
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Planet planet = (Planet) obj;
        return centerStar != null ? centerStar.equals(planet.centerStar) : planet.centerStar == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();  // Include parent class hashCode
        result = 31 * result + (centerStar != null ? centerStar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar);
    }
}