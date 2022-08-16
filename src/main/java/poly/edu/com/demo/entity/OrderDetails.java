package poly.edu.com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OrderDetails  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Orders ordersByOrdersId;
    @ManyToOne
    @JoinColumn(name = "earPhone_id", referencedColumnName = "id")
    private EarPhone earPhoneByEarPhoneId;
}
