package tn.iteam.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
