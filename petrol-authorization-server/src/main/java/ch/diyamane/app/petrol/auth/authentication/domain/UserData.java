package ch.diyamane.app.petrol.auth.authentication.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_UserName", columnNames = "USER_NAME"),
        @UniqueConstraint(name = "UK_Email", columnNames = "EMAIL")
    })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "UserData.roles",
    attributeNodes = @NamedAttributeNode("roles")
)
public class UserData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "USER_NAME", length = 20, nullable = false)
  private String userName;

  @Column(name = "PASSWORD", length = 120, nullable = false)
  private String password;

  @Email
  @Column(name = "EMAIL", length = 50, nullable = false)
  private String email;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE",
      joinColumns = @JoinColumn(name = "USER_ID"),
      inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
  @Default
  private Set<Role> roles = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserData)) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(userName, userData.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName);
  }
}