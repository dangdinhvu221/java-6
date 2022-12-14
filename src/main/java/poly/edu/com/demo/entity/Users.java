package poly.edu.com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import poly.edu.com.demo.entity.typeEnum.TypeGender;
import poly.edu.com.demo.entity.typeEnum.TypeRole;
import poly.edu.com.demo.entity.typeEnum.TypeStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Users  implements Serializable {
    private Long id;

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String image;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private Date created;
    @Enumerated(EnumType.ORDINAL)
    private TypeRole typeRole;
    @Enumerated(EnumType.ORDINAL)
    private TypeGender typeGender;
    @Enumerated(EnumType.ORDINAL)
    private TypeStatus typeStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "usersByUserId")
    List<Orders> orders;

}
