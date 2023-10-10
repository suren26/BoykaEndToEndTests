package ui.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BillingData {
    private String addressLineOne;
    private String city;
    private String country;
    private String firstName;
    private String lastName;
    private String postCode;
    private String state;
}
