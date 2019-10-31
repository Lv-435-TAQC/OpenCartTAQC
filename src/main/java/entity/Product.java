package entity;

public class Product {
    private Integer id;
    private String productName;
    private String imageLink;
    private Double prise;
    private String model;
    private String brands;
    private String availability;
    private String rating;
    private String summary;
    private Double weight;
    private String dimensions;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", prise=" + prise +
                ", model='" + model + '\'' +
                ", brands='" + brands + '\'' +
                ", availability='" + availability + '\'' +
                ", rating='" + rating + '\'' +
                ", summary='" + summary + '\'' +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                '}';
    }

    public boolean equals(Product product) {
        if (this == product) return true;
        if (product == null || getClass() != product.getClass()) return false;
        return id.equals(product.id) &&
                productName.contains(product.productName) &&
                prise.equals(product.prise) &&
                summary.contains(product.summary);
    }
}
