package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private int series;

	@OneToOne //(orphanRemoval = true)
	@JoinColumn (name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public User setUser(User user) {
		this.user = user;
		return user;
	}

	public Car() {

	}

	public Car(String model, int series) {
		this.model = model;
		this.series = series;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	@Override
	public int hashCode() {
		int result = 37;
		result = 37 * result + (int)(id ^ (id >>> 32));
		result = 37 * result + model.hashCode();
		result = 37 * result + series;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Car other = (Car) obj;
		return (id.equals(other.id) &&
				model.equals(other.model) &&
				(series == other.series));
	}

	@Override
	public String toString() {
		return "Car [" +
				"model = " + model +
				", series = " + series +
				']';
	}
}
