package com.dbs.ordermanagesystem.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class Header {

	private String msgId;
	private String timestamp;
}
