package com.pruebapractica.apitestdocker.seguridad.infraestructura;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "jms.jwt")
public class JwtIOProperties {
	
	private Security security;
	private String timezone;
	private String issuer;
	private Token token;
	private Excluded excluded;
	
	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Excluded getExcluded() {
		return excluded;
	}

	public void setExcluded(Excluded excluded) {
		this.excluded = excluded;
	}

	@Data
	public static class Security {
		
		private boolean enabled;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}
	
	@Data
	public static class Token {
		
		private Auth auth;
		private String secret;
		private int expiresIn;
		
		public Auth getAuth() {
			return auth;
		}
		public void setAuth(Auth auth) {
			this.auth = auth;
		}
		public String getSecret() {
			return secret;
		}
		public void setSecret(String secret) {
			this.secret = secret;
		}
		public int getExpiresIn() {
			return expiresIn;
		}
		public void setExpiresIn(int expiresIn) {
			this.expiresIn = expiresIn;
		}
	}
	
	@Data
	public static class Auth {
		
		private String path;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}
	
	@Data
	public static class Excluded {
		
		private String path;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}

}
