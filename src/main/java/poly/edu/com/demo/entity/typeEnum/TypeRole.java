package poly.edu.com.demo.entity.typeEnum;

public enum TypeRole {
    ADMIN(0), CUSTOMER(1) , USER(2);

    private Integer value;

    TypeRole(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
