package it.ispw.efco.nottitranquille.view;

import it.ispw.efco.nottitranquille.controller.Access;
import it.ispw.efco.nottitranquille.model.Person;
import org.json.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "loggedusers")
public class LoginBean {
    private String username = "";
    private String password = "";
    private String cookie = "";
    private boolean expired;

    public boolean isExpired() {
        return expired;
    }


    public void login() throws Exception {
        if (!this.username.equals("") && !this.password.equals("")) {
            Person person = Access.getRegisteredUser(this.username, this.password);
            if (person == null) {
                throw new Exception("User not registered");
            } else {
                this.username = person.getUsername();
                int value = isLoggedIn();
                if (value == 0) {
                    //you can not perform login if you are already logged
                    throw new Exception("User is already logged");
                } else if (value == 1) {
                    return;
                } else {
//                  this.user_id = id;
                    Access.logNewUser(this);
                }

            }
        } else {
            throw new Exception("Invalid data");
        }
    }

    @Transient
    public int isLoggedIn() {
        if (!this.username.equals("") && !this.password.equals("") && !this.cookie.equals("")) {
            return Access.isAlreadyLogged(this, cookie);
        } else {
            return 2;
        }
    }

    public void logout() throws Exception {
        if (this.id != null) {
            Access.setLogout(this.id);
        }
    }

    @Transient
    public Person getUser() {
        return Access.getRegisteredUser(this.username, this.password);
    }

    public int modifyField(String field, String[] value) {
        if (field != null && value != null) {
            try {
                Access.modifyField(field, value, getUser().getId());
                //In order to refresh data for user after suc
                if (field.equals("password"))
                    this.password = value[1];
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }

    public String api_login_response() {
        JSONObject response = new JSONObject();
        try {
            this.login();
            response.put("code", 1);
            response.put("message", "user_logged");
            return response.toString();
        } catch (Exception e) {
            response.put("code", 0);
            response.put("message", e.getMessage());
            return response.toString();
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cookie='" + cookie + '\'' +
//                ", user_id=" + user_id +
                ", expired=" + expired +
                ", id=" + id +
                '}';
    }
}

