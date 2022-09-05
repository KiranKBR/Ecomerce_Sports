package dto;

public class User {
String emailId;
String userName;
String password;

public User(String emailId, String userName, String password) {
super();
this.emailId = emailId;
this.userName = userName;
this.password = password;
}

public User() {
super();
}
public String getEmailId() {
return emailId;
}

public void setEmailId(String emailId) {
this.emailId = emailId;
}

public User(String userName, String password) {
super();
this.userName = userName;
this.password = password;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
@Override
public String toString() {
return "Login [userName=" + userName + ", email=" + emailId + "]";
}


}