package work.student_dashboard.backend.payloads;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	 	
		private String accessToken;
	    private String tokenType = "Bearer";
	    private String userPrivilage="";

	    public JwtResponse(String accessToken) {
	        this.accessToken = accessToken;
	    }

	    public String getAccessToken() {
	        return accessToken;
	    }

	    public void setAccessToken(String accessToken) {
	        this.accessToken = accessToken;
	    }
	    
	    public String getTokenType() {
	        return tokenType;
	    }
	    
	    public void setTokenType(String tokenType) {
	        this.tokenType = tokenType;
	    }

		public String getUserPrivilage() {
			return userPrivilage;
		}

		public void setUserPrivilage(String userPrivilage) {
			this.userPrivilage = userPrivilage;
		}
	    
	    
}
