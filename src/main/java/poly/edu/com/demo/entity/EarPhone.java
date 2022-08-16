package poly.edu.com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;
import poly.edu.com.demo.entity.typeEnum.TypeCondition;
import poly.edu.com.demo.entity.typeEnum.TypeEarPhone;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class EarPhone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nationalized
    private String name;
    @Nationalized
    private String title;
    @Nationalized
    private String warranty; // bảo hành
    private Integer frequency; // tần số
    @Nationalized
    private String color;
    private BigDecimal price;
    private String impedance; //trở kháng
    @Nationalized
    private String image;
    @Nationalized
    private String description;
    @Temporal(TemporalType.DATE)
    private Date created;
    private Integer quantity;
    @Enumerated(EnumType.ORDINAL)
    private TypeEarPhone typeEarPhone;
    @Enumerated(EnumType.ORDINAL)
    private TypeCondition typeCondition; // Tình trạng
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturerByManufacturerId;

    @JsonIgnore
    @OneToMany(mappedBy = "earPhoneByEarPhoneId")
    List<OrderDetails> orderDetails;
}
