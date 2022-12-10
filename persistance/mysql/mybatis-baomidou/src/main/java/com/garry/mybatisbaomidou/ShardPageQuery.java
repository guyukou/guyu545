package com.garry.mybatisbaomidou;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
public class ShardPageQuery<T> {
    private Function<String, Integer> countFunc;
    private Function<PageQueryParam, List<T>> queryFunc;
    private Collection<String> shards;
    private int pageNum;
    private int pageSize;

    public static <E> Builder<E> builder(Function<PageQueryParam, List<E>> queryFunc) {
        Builder<E> builder = new Builder<>();
        builder.queryFunc = queryFunc;
        return builder;
    }

    public static class Builder<E> {
        private Function<String, Integer> countFunc;
        private Function<PageQueryParam, List<E>> queryFunc;
        private Collection<String> shards;
        private int pageNum;
        private int pageSize;

//        public static <E> Builder of() {
//        }

        public Builder<E> pageNum(int pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder<E> pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder<E> shards(Collection<String> shards) {
            this.shards = shards;
            return this;
        }

        public Builder<E> countFunc(Function<String, Integer> countFunc) {
            this.countFunc = countFunc;
            return this;
        }

        public ShardPageQuery<E> build() {
            return new ShardPageQuery<>(countFunc, queryFunc, shards, pageNum, pageSize);
        }
    }

    public Page<T> doQuery() {
        long globalStartIndex = pageSize * (pageNum - 1) + 1;
        long globalEndIndex = pageSize * pageNum;
        long offset = 0;
        List<T> resultList = new ArrayList<>();
        long total = 0;
        for (String shard : shards) {
            int countOfShard = countFunc.apply(shard);
            total += countOfShard;
            long shardStartIndex = offset + 1;
            long shardEndIndex = offset + countOfShard;
            if (globalEndIndex >= shardStartIndex && globalStartIndex <= shardEndIndex) {
                long pageStartIndex = Math.max(shardStartIndex, globalStartIndex);
                long pageEndIndex = Math.min(shardEndIndex, globalEndIndex);
                long innerOffset = pageStartIndex - 1 - offset;
                long innerLimit = pageEndIndex - pageStartIndex + 1;

                List<T> supplierLogsInShard = queryFunc.apply(new PageQueryParam(shard, (int) innerOffset, (int) innerLimit));
                resultList.addAll(supplierLogsInShard);
            }
            offset += countOfShard;
        }
        Page<T> page = new Page<>();
        page.setTotal(total);
        page.setList(resultList);
        page.setPageNum(pageNum);
        page.setPageSize(resultList.size());
        page.setPages((int) ((total + pageSize - 1) / pageSize));
        return page;
    }

}
