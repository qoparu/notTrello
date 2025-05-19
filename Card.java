import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Card {
    private String id;
    private String title;
    private String description;
    private List<String> tags;
    private String assignee; // who assigned
    private Priority priority; // priority of task
    private String dueDate; // deadline
    private List<Comment> comments; // comments to the card
    private boolean isArchived; // Card is archived?

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Card(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.priority = Priority.MEDIUM; // middle priority by default
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return new ArrayList<>(tags); // returning the copy to prevent unnecessary changes
    }

    public void addTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
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

    // Вложенный класс для комментариев
    public static class Comment {
        private String author;
        private String text;
        private String timestamp;

        public Comment(String author, String text, String timestamp) {
            this.author = author;
            this.text = text;
            this.timestamp = timestamp;
        }

        // Геттеры для комментария
        public String getAuthor() {
            return author;
        }

        public String getText() {
            return text;
        }

        public String getTimestamp() {
            return timestamp;
        }
    }
}
