public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String From;
    private String To;
    private double flightTime;

    public Ticket(int id, int price, String from, String to, double flightTime) {
        this.id = id;
        this.price = price;
        From = from;
        To = to;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }


    public String getFrom() {
        return From;
    }


    public String getTo() {
        return To;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
