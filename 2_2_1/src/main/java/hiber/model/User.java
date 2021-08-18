package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", nullable = false)
   private String firstName;

   @Column(name = "last_name", nullable = false)
   private String lastName;

   @Column(nullable = false)
   private String email;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
   private Car car;


   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public Car setCar(Car car) {
      this.car = car;
      return car;
   }


   @Override
   public int hashCode() {
      int result = 37;
      result = 37 * result + (int)(id ^ (id >>> 32));
      result = 37 * result + firstName.hashCode() + lastName.hashCode() + email.hashCode();
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
      User other = (User) obj;
      return (id.equals(other.id) &&
              firstName.equals(other.firstName) &&
              lastName.equals(other.lastName) &&
              email.equals(other.email));
   }

   @Override
   public String toString() {
      return "User [" +
              "firstName = " + firstName +
              ", lastName = " + lastName +
              ", email = " + email +
              ']';
   }
}
