package poly.edu.com.demo.entity.typeEnum;

public enum TypeGender {
    MALE(0), FEMALE(1);

    private Integer valueGender;

    TypeGender(Integer valueGender) {
        this.valueGender = valueGender;
    }

    public Integer getValueGender() {
        return valueGender;
    }

    public void setValueGender(Integer valueGender) {
        this.valueGender = valueGender;
    }
}
