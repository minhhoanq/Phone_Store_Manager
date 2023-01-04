/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emplyee_Manager;

import trido_main.Helper;

/**
 *
 * @author Minh Hoanfg
 */
public class NhanVienLoginInfor {

    private String email;
    private String password;

    public NhanVienLoginInfor(String email, String password) {
        this.email = email.toLowerCase();
        this.password = Helper.clearSpace(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Helper.clearSpace(password);
    }
}
