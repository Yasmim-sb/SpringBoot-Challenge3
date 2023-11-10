package br.com.compassUOL.challenge3.ms_user.user;

public enum UserRole {
    ADMIN("admin"),
    USER_ROLE("user");

    private String role;

    UserRole(String role){
        this.role= role;
    }
    String getRole(){
        return role;
    }
}
