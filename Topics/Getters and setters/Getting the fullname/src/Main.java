class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if(this.firstName!=null){
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if(this.lastName!=null){
            this.lastName=lastName;
        }
    }

    public String getFullName() {
        if(this.firstName==null && this.lastName==null){
            return "Unknown";
        }else if(firstName == null){
            return lastName;
        }else if(lastName==null){
            return firstName;
        }else{
            return firstName + " "+lastName;
        }
    }
}