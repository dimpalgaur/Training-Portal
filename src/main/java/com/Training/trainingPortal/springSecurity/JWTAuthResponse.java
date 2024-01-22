package com.Training.trainingPortal.springSecurity;

import lombok.Data;

@Data
public class JWTAuthResponse 
{
    private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
}
