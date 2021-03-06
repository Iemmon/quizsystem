package quizsystem.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private final Long userId;
    private final String email;
    private final String password;
    private double averageMark;
    private final Role role;

    public User(Builder builder) {
        this.userId = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
        this.averageMark = builder.averageMark;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.averageMark, averageMark) == 0 &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, averageMark, role);
    }

    public static class Builder {
        private Long id;
        private String email;
        private String password;
        private double averageMark;
        private Role role;

        public User build() {
            return new User(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withAverageMark(double averageMark){
            this.averageMark = averageMark;
            return this;
        }

        public Builder withRole(Role role){
            this.role = role;
            return this;
        }

    }
}
