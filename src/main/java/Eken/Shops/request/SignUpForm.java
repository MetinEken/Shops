package Eken.Shops.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
public class SignUpForm {


    private String userName;
    private String name;
    private String email;
    private String lastName;
    private String password;
    private String loginDates;
    private String role="USER";

    public SignUpForm(){}

    public SignUpForm(String userName, String name, String email, String lastName, String password, String loginDates){
      this.userName=userName;
        this.name= name;
        this.email =email;
        this.lastName=lastName;
        this.password=password;
        this.loginDates=loginDates;
        }
}
