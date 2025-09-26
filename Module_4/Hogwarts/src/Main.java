public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("Potions 101", "Severus Snape", 1991));
        lib.addBook(new Book("Charms Advanced", "Filius Flitwick", 1985));

        lib.displayBooks();

        Book found = lib.findByTitle("Potions 101")
                .orElseThrow(() -> new RuntimeException("Book not found!"));
        System.out.println("Found: " + found);
    }
}
