package com.example.demo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Infinity97
 */
@Data
@Entity
@Table(name = "details")
public class ShowDetails {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	@Column
	private String name;
}
