package dev.wmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Url extends PanacheEntity {

	public String shortUrl;
	@Column(length=1000)
	public String longUrl;
}
