package com.hj.algorithm;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * @author Administrator
 */
public class ExternalSort {

    private class ResultEntry<T extends Comparable<T>>
            implements Comparable<ResultEntry<T>> {
        private final T value;
        private final Iterator<T> source;

        public ResultEntry(T value, Iterator<T> source) {
            this.value = value;
            this.source = source;
        }

        @Override
        public int compareTo(ResultEntry<T> o) {
            // compare only value with o.value
            return value.compareTo(o.value);
        }
    }

    private class MergeResultIterator<T extends Comparable<T>>
            implements Iterator<T> {
        private final PriorityQueue<ResultEntry<T>> queue;

        public MergeResultIterator(List<Iterable<T>> sortedData) {
            // Collect minimum data in each sortedData.
            queue = new PriorityQueue<>();
            for (Iterable<T> data : sortedData) {
                Iterator<T> iterator = data.iterator();
                if (iterator.hasNext()) {
                    queue.add(
                            new ResultEntry<>(iterator.next(), iterator));
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        /**
         * Finds minimum data in our collection.
         */
        @Override
        public T next() {
            if (queue.isEmpty()) {
                throw new NoSuchElementException();
            }

            ResultEntry<T> entry = queue.poll();

            // Replace extracted data with next minimum in its source.
            if (entry.source.hasNext()) {
                queue.add(new ResultEntry<>(
                        entry.source.next(), entry.source));
            }
            return entry.value;
        }
    }

    public <T extends Comparable<T>> Iterable<T> merge(
            List<Iterable<T>> sortedData) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new MergeResultIterator<>(sortedData);
            }
        };
    }


}

