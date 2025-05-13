public class Card {
    private String id;
    private String title;
    private String description;
    private List<String> tags; // для высокого рейтинга

    // Конструктор, геттеры, сеттеры
    public Card(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.tags = new ArrayList<>();
    }
}
