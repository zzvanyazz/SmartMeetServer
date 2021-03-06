package com.lemonado.smartmeetserver.database.data.modes;


import javax.persistence.*;

@Entity
@Table(name = "registration_codes")
public class RegistrationCodeEntity {

    @Id
    @Column(name = "registration_code")
    private String registrationCode;

    @Column(name = "email")
    private String email;

    @Column(name = "role_id")
    private long roleId;

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
