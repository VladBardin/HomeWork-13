package Task2;

public class User {
        private int userId;
        private int id;
        private String title;
        private String body;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("User{");
            sb.append("id=").append(id);
            sb.append(", userId=").append(userId);
            sb.append(", title='").append(title).append('\'');
            sb.append(", body='").append(body).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

