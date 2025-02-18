package com.egg;

public class Main {
    public static void main(String[] args) {
        SampleDataLoader sampleDataLoader = new SampleDataLoader();
        Thread thread = new Thread(sampleDataLoader);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}