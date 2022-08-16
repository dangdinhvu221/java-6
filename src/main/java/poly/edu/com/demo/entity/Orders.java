package poly.edu.com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Orders  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created;
    private String address1;
    private String address2;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Users usersByUserId;

    @JsonIgnore
    @OneToMany(mappedBy = "ordersByOrdersId")
    List<OrderDetails> orderDetails;
}
