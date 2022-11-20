import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1_299, "MOW", "KZN", 1.35);
    Ticket ticket2 = new Ticket(2, 2_199, "MOW", "KZN", 1.35);
    Ticket ticket3 = new Ticket(3, 1_500, "MOW", "KZN", 1.35);
    Ticket ticket4 = new Ticket(4, 1_500, "MOW", "KZN", 1.55);

    @Test

    public void addAll() {
        repository.save(ticket1);
        repository.save(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
        Arrays.sort(actual);

    }

    @Test
    public void removeAll() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.removeById(1);

        Ticket[] expected = {ticket2};
        Ticket[] actual = repository.getAll();
        Assertions.assertArrayEquals(expected, actual);
        Arrays.sort(actual);

    }

    @Test
    public void test1FindAndScan() {
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.searchBy("MOW", "KZN");
        Assertions.assertArrayEquals(expected, actual);
        Arrays.sort(actual);

    }

    @Test
    public void test2FindAndScan() {
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = manager.searchBy("MOW", "KZN");
        Assertions.assertArrayEquals(expected, actual);
        Arrays.sort(actual);

    }

    @Test
    public void test3FindAndScan() {
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] expected = {ticket3, ticket2};
        Ticket[] actual = manager.searchBy("MOW", "KZN");
        Assertions.assertArrayEquals(expected, actual);
        Arrays.sort(actual);

    }

    @Test
    public void test4SearchBy() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        String from = "ABC";
        String to = "CVB";

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy(from, to);
        Assertions.assertArrayEquals(expected, actual);


    }

}
