
class interThread {

    int data;
    boolean produced = false;

    synchronized void produce(int value) {
        if (produced) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        data = value;
        System.out.println("Produced : " + data);
        produced = true;
        notify();
    }

    synchronized void consume() {
        if (!produced) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Consumed:" + data);
        produced = false;
        notify();
    }

    public static void main(String[] args) {
        System.out.println("Hello Mahi");
    }
}
