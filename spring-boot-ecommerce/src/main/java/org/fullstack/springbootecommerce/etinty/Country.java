package org.fullstack.springbootecommerce.etinty;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "iso3")
	private String iso3;
	
	@Column(name = "numeric_code")
	private String numericCode;
	
	@Column(name = "iso2")
	private String iso2;
	
	@Column(name = "phonecode")
	private String phoneCode;
	
	@Column(name = "capital")
	private String capital;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "currency_name")
	private String currencyName;
	
	@Column(name = "currency_symbol")
	private String currencySymbol;
	
	@Column(name = "tld")
	private String tld;
	
	@Column(name = "native")
	private String language;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "subregion")
	private String subregion;
	
	@Column(name = "timezones")
	private String timezones;
	
	@Column(name = "translations")
	private String translations;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "emoji")
	private String emoji;
	
	@Column(name = "emojiU")
	private String emojiU;
	
	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at")
	@CreationTimestamp
	private Date updatedAt;
	
	@Column(name = "flag")
	private int flag;
	
	@Column(name = "wiki_data_id")
	private String wikiDataId;
	
	@OneToMany(mappedBy = "country")
	private List<State> states;
}