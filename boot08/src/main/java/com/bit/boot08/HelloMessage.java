package com.bit.boot08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelloMessage {
	private String cmd;
	private String name;
}
