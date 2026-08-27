package ir.maktabsharif.model;

import jakarta.persistence.Entity;

@Entity
public class Manuscript extends LibraryItem{
    /*
    originCountry`, `estimatedAge`, `isFragile`
     */
    private String originCountry;
    private int estimatedAge;
    private boolean isFragile;

    public Manuscript(String title, int publishYear, int availableCopies, String originCountry, int estimatedAge, boolean isFragile) {
        super(title, publishYear, availableCopies);
        this.originCountry = originCountry;
        this.estimatedAge = estimatedAge;
        this.isFragile = isFragile;
    }

    public Manuscript(String originCountry, int estimatedAge, boolean isFragile) {
        this.originCountry = originCountry;
        this.estimatedAge = estimatedAge;
        this.isFragile = isFragile;
    }

    public Manuscript() {
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(int estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    @Override
    public String toString() {
        return "Manuscript{" +
                "originCountry='" + originCountry + '\'' +
                ", estimatedAge=" + estimatedAge +
                ", isFragile=" + isFragile +
                '}';
    }
}
