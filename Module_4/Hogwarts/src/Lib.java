import java.util.*;

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }
    }

    public Optional<Book> findByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public Optional<Book> findByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .findFirst();
    }

    public Optional<Book> findByYear(int year) {
        return books.stream()
                .filter(b -> b.getYear() == year)
                .findFirst();
    }
}
