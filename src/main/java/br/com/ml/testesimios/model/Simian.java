package br.com.ml.testesimios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="TB_SIMIAN")
@NoArgsConstructor
public class Simian {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@NotBlank  
    private String dna;

    
    @NotBlank
    private String isSimian;

	public Simian(@NotBlank String dna, @NotBlank String isSimian) {
		super();
		this.dna = dna;
		
		this.isSimian = isSimian;
	}

    
}
