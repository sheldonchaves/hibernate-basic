package br.com.financas.model;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class LoggableInfo {

	@Temporal(TemporalType.DATE)
	private Calendar creationDate = Calendar.getInstance();

	@Temporal(TemporalType.DATE)
	private Calendar lastUpdatedDate;

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Calendar lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	// private final User createdBy = session.getUser()?;
	// private User lastUpdatedBy = session.getUser()?;

}
