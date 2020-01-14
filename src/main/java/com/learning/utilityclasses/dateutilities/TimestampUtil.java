package com.learning.utilityclasses.dateutilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

@Component
@Converter
public class TimestampUtil implements AttributeConverter<LocalDateTime,Timestamp > {

	public TimestampUtil() {
		super();
	}

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return locDateTime==null?null:Timestamp.valueOf(locDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlDate) {
		return sqlDate==null?null:sqlDate.toLocalDateTime();
	}

}
