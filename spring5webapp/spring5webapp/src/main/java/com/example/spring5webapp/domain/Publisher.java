package com.example.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public Publisher() {
	}
	
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
	 	}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Publisher publisher = (Publisher) obj;
		return id != null ? id.equals(publisher .id) : publisher .id == null;
	}
	
	
	
	
	
	
	
}
