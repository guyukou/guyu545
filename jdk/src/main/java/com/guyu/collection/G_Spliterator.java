package com.guyu.collection;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class G_Spliterator {
    public static void main(String[] args) {
    }

    static class MySpliterator implements Spliterator<String> {

        @Override
        public boolean tryAdvance(Consumer<? super String> action) {
            return false;
        }

        @Override
        public Spliterator<String> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}
