public class Launcher {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
        Worker worker = new Worker(arr);
        long a = System.currentTimeMillis();
        worker.run();
        System.out.println(System.currentTimeMillis() - a);

        float[] a1 = new float[size];
        float[] a2 = new float[size];
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Worker thread1 = new Worker(a1);
        Worker thread2 = new Worker(a2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.arraycopy(thread1.arr, 0, arr, 0, h);
        System.arraycopy(thread2.arr, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - b);
    }
}
