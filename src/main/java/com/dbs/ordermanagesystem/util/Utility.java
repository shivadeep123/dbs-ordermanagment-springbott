package com.dbs.ordermanagesystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.UUID;

import com.dbs.ordermanagesystem.dto.Header;

public class Utility {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");
	DateFormat orderDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public Header createHeader() {
		return Header.builder().msgId(UUID.randomUUID().toString()).timestamp(df.format(new java.util.Date())).build();
	}
	
	public Date dateConvert(String date) {
		try {
			return (Date) orderDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Double doubleConvert(String total) {
		return Double.valueOf(total);
	}
}
