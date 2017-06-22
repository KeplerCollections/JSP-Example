package bean;

public class User {
	private String email,pass,name;  
	int id;
        public int getId(){
            return id;
        }
        
        public void setId(int id){
            this.id=id;
        }
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getEmail() {  
	    return email;  
	}  
	  
	public void setEmail(String email) {  
	    this.email = email;  
	}  
	  
	public String getPass() {  
	    return pass;  
	}  
	  
	public void setPass(String pass) {  
	    this.pass = pass;  
	}  
	  
	  
}
