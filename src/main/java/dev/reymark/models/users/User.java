package dev.reymark.models.users;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class User extends FXModel {

    private FXIntegerProperty userid;
    private FXStringProperty username;
    private FXStringProperty designaton;
    private FXStringProperty fname;
    private FXStringProperty Mname;
    private FXStringProperty lname;
    private FXStringProperty address;
    private FXStringProperty password;
    private FXDoubleProperty salary;

    public User(Integer userid,
            String username,
            String designation,
            String fname,
            String Mname,
            String lname,
            String address,
            String password,
            Double salary) {
        this.userid = new FXIntegerProperty(userid);
        this.username = new FXStringProperty(username);
        this.designaton = new FXStringProperty(designation);
        this.fname = new FXStringProperty(fname);
        this.Mname = new FXStringProperty(Mname);
        this.lname = new FXStringProperty(lname);
        this.address = new FXStringProperty(address);
        this.password = new FXStringProperty(password);
        this.salary = new FXDoubleProperty(salary);

        track_properties(this.userid,
                this.username,
                this.designaton,
                this.fname,
                this.Mname,
                this.lname,
                this.address,
                this.password,
                this.salary);
    }

    public FXIntegerProperty useridProperty() {
        return userid;
    }

    public Integer getuserid() {
        return useridProperty().get();
    }

    public void setuserid(Integer userid) {
        useridProperty().set(userid);
    }

    public FXStringProperty usernameProperty() {
        return username;
    }

    public String getusername() {
        return usernameProperty().get();
    }

    public void setusername(String username) {
        usernameProperty().set(username);
    }

    public FXStringProperty designationProperty() {
        return designaton;
    }

    public String getdesignation() {
        return designationProperty().get();
    }

    public void setdesignation(String designation) {
        designationProperty().set(designation);
    }

    public FXStringProperty fnamProperty() {
        return fname;
    }

    public String getfnameProperty() {
        return fnamProperty().get();
    }

    public void setfname(String fname) {
        fnamProperty().set(fname);
    }

    public FXStringProperty MnameProperty() {
        return Mname;
    }

    public String getMnameProperty() {
        return MnameProperty().get();
    }

    public void setMname(String Mname) {
        MnameProperty().set(Mname);
    }

    public FXStringProperty lnameProperty() {
        return lname;
    }

    public String getlnameProperty() {
        return lnameProperty().get();
    }

    public void setlname(String lname) {
        lnameProperty().set(lname);
    }

    public FXStringProperty addressProperty() {
        return address;
    }

    public String getaddressProperty() {
        return addressProperty().get();
    }

    public void setaddress(String address) {
        addressProperty().set(address);
    }

    public FXStringProperty passwordProperty() {
        return password;
    }

    public String getpasswordProperty() {
        return lnameProperty().get();
    }

    public void setpassword(String password) {
        passwordProperty().set(password);
    }

    public FXDoubleProperty salaryProperty() {
        return salary;
    }

    public Double getsalaryProperty() {
        return salaryProperty().get();
    }

    public void setsalary(Double salary) {
        salaryProperty().set(salary);
    }

    @Override
    public FXModel clone() {
        User user = new User(getuserid(),
                getusername(),
                getdesignation(),
                getfnameProperty(),
                getMnameProperty(),
                getlnameProperty(),
                getaddressProperty(),
                getpasswordProperty(),
                getsalaryProperty());
        return user;
    }

    @Override
    public void copy(FXModel arg0) {
        User c = (User) arg0;

        setuserid(c.getuserid());
        setusername(c.getusername());
        setdesignation(c.getdesignation());
        setfname(c.getfnameProperty());
        setMname(c.getMnameProperty());
        setlname(c.getlnameProperty());
        setaddress(c.getaddressProperty());
        setpassword(c.getpasswordProperty());
        setsalary(c.getsalaryProperty());
    }

}
