package dk.demo.model;

import javax.persistence.*;

@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToOne
	private Recipe recipe;
}
