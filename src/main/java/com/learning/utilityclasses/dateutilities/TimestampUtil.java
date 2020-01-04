package com.learning.utilityclasses.dateutilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

@Component
@Converter
public class TimestampUtil implements AttributeConverter<LocalDateTime,Timestamp > {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return locDateTime==null?null:Timestamp.valueOf(locDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
