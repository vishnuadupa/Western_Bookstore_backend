package com.avp.models;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {
	
	private String token;
	
	private String message;
}
