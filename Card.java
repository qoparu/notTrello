import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

public class Card {
    private final String id;
    private String title;
    private String description;
    private final List<String> tags;
    private String assignee;
    private Priority priority;
    private String dueDate;
    private final List<Comment> comments;
    private boolean isArchived;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Card(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.priority = Priority.MEDIUM;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title, "Title cannot be null");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description; // null allowed for description
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags); // другой метод, чем создание новой копии
    }

    public void addTag(String tag) {
        if (tag != null && !tag.trim().isEmpty() && !tags.contains(tag)) {
            tags.add(tag.trim());
        }
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee; // null allowed for assignee
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = Objects.requireNonNull(priority, "Priority cannot be null");
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate; // null allowed for dueDate
    }

    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    public void addComment(Comment comment) {
        comments.add(Objects.requireNonNull(comment, "Comment cannot be null"));
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", dueDate='" + dueDate + '\'' +
                ", commentsCount=" + comments.size() +
                ", isArchived=" + isArchived +
                '}';
    }

    public static class Comment {
        private final String author;
        private final String text;
        private final String timestamp;

        public Comment(String author, String text, String timestamp) {
            this.author = Objects.requireNonNull(author, "Author cannot be null");
            this.text = Objects.requireNonNull(text, "Text cannot be null");
            this.timestamp = Objects.requireNonNull(timestamp, "Timestamp cannot be null");
        }

        public String getAuthor() {
            return author;
        }

        public String getText() {
            return text;
        }

        public String getTimestamp() {
            return timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comment comment = (Comment) o;
            return author.equals(comment.author) &&
                   text.equals(comment.text) &&
                   timestamp.equals(comment.timestamp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(author, text, timestamp);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id.equals(card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
