public class Tester {

    public static void main(String args[]) {
        VipQueue<Integer> vq = new VipQueue<Integer>(10);
        for (int i = 0; i < 5; i++) {
            if (!vq.isFull()) vq.enqueue(i); //a "regular" enqueue
            if (!vq.isFull()) vq.vipEnqueue(i * i); //a vip enqueue
        }
        while (!vq.isEmpty()) System.out.printf("->%d", vq.dequeue());
        //test1();
    }

//    public static void test1() {
//        VipQueue<String> vq = new VipQueue<String>(10);
//        vq.enqueue("hello");
//        vq.enqueue("world");
//        vq.vipEnqueue("goodbye");
//        vq.vipEnqueue("greeting");
//        while (!vq.isEmpty()) System.out.printf("->%s", vq.dequeue());
//    }
}